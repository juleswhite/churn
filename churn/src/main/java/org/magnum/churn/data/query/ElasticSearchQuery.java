package org.magnum.churn.data.query;

import org.magnum.churn.transform.Transform;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElasticSearchQuery {

	// Fangzhou, fill in a representation for this
	
	public final int startUnixTimestamp;
	
	public final int endUnixTimestamp;
	
	public final String source;
	
	public ElasticSearchQuery(
			@JsonProperty("startUnixTimestamp") int startUnixTimestamp, 
			@JsonProperty("endUnixTimestamp") int endUnixTimestamp,
			@JsonProperty("source") String source) {
		super();
		this.startUnixTimestamp = startUnixTimestamp;
		this.endUnixTimestamp = endUnixTimestamp;
		this.source = source;
	};
	
}
