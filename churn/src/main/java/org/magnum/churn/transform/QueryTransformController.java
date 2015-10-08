package org.magnum.churn.transform;

import java.util.List;

import org.elasticsearch.node.Node;
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
		return null;
	}

}
