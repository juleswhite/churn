package org.magnum.churn.transform;

import org.magnum.churn.data.query.ElasticSearchQuery;

import com.fasterxml.jackson.annotation.JsonProperty;

//
public class QueryTransform {

	public final ElasticSearchQuery query;
	
	public final Transform transform;

	public QueryTransform(
			@JsonProperty("query") ElasticSearchQuery query, 
			@JsonProperty("transform") Transform transform) {
		super();
		this.query = query;
		this.transform = transform;
	};
	
}
