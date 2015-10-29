package org.magnum.churn.transform;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.magnum.churn.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryTransformController {

	private Node elasticSearch_;

	@Autowired
	public QueryTransformController(Node elasticSearch) {
		elasticSearch_ = elasticSearch;
	}

	@RequestMapping(value="/query/transform",method=RequestMethod.POST)
	public List<Data> queryAndTransform(@RequestBody QueryTransform transform) {

		// Fill me in
		Date startDate = new Date(transform.query.startUnixTimestamp);
		Date endDate = new Date(transform.query.endUnixTimestamp);
		Client client = elasticSearch_.client();
		
		Transform trans = transform.transform;
		
		// Query ElasticSearch
		RangeQueryBuilder queryDate = QueryBuilders.rangeQuery("@timestamp").from(startDate).to(endDate);
		FilterBuilder filterBuilder = FilterBuilders.queryFilter(queryDate);

		QueryBuilder queryBuilder = QueryBuilders.matchQuery("source", transform.query.source);
		SearchResponse searchResponse = client.prepareSearch(getIndex()).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.filteredQuery(queryBuilder, filterBuilder)).setFrom(0).setSize(99999)
				.setExplain(true).execute().actionGet();

		SearchHit[] results = searchResponse.getHits().getHits();
		List dataList = new ArrayList();
		for (SearchHit result : results) {
			Map<String, Object> s = result.sourceAsMap();
			Data data = new Data();
			Map<String, Object> transformedData = s.entrySet().stream().collect(Collectors.toMap(
					e->(String)trans.apply(e.getKey()),
					e->e.getValue()
					));
			data.setData(transformedData);
			dataList.add(data);
		}
		return dataList;
	}
	
	public String getIndex() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = formatter.format(new Date());

		formattedDate = "logstash-" + formattedDate;
		return formattedDate;
	}

}
