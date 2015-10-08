package org.magnum.churn.transform;

public class MappingTransform<I,O> implements Transform<I,O> {

	// This should represent a transformation that selects
	// certain attributes from each hit in the results and
	// maps it to a Data instance
	
	// Add what is needed to specify some type of simple property-based
	// mapping from a hit to a Data
	/**
	 * Example:
	 * 
	 * if the core data in the hit was like:
	 * 
	 * {
	 *   foo:1,
	 *   bar:2,
	 *   asdf:3
	 * }
	 * 
	 * The transform might map:
	 * 
	 * foo --> Data.mySize
	 * bar --> Data.myLength
	 * asdf is ignored
	 * 
	 */
	
	@Override
	public O apply(I t) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
