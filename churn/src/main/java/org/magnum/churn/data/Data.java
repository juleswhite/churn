package org.magnum.churn.data;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Represents data to input into a machine learning algorithm
 * 
 * @author jules
 *
 */
public class Data {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	// Initialize me
	private Map<String,Object> rawData_;
	
	private String labelAttribute_;
	/**
	 * Returns the order that the properties will appear in the
	 * vector representation of the data.
	 * 
	 * @return
	 */
	public List<String> keyOrdering(){
		return rawData_.keySet().stream().collect(Collectors.toList());
	}
	
	public String toString(){
		try{
			return MAPPER.writeValueAsString(this);
		}catch(JsonProcessingException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Converts the data into a format that is easily consumable
	 * by a framework like Weka.
	 * 
	 * @return
	 */
	public List<Double> toVector(){
		return rawData_.keySet()
				.stream().mapToDouble((item) -> {
					// Use the converter set below
					return 0d;
				})
				.boxed()
				.collect(Collectors.toList());
		
	}
	
	public void setLabelProperty(String propertyName){
		labelAttribute_ = propertyName;
	}
	
	public void setData(double[] vector){
		//fill me in
	}
	
	public void setData(Map<String,Object> data){
		//fill me in
	}
	
	public Object getLabel(){
		// Fill me in
		return null;
	}
	
	public void setNumericConvertver(String propertyName, Function<Object,Double> converter){
		// Fangzhou, this should set the converter function that is used for
		// each property above
	}
	
}
