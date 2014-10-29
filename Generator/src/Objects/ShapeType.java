/**
 * Enum ShapeType. Dependency for AbstractShape class constructor. 
 * Used to define the types of shapes that can be created.
 *  
 * @author 	James Cootware
 * @version	1.0
 */
package Objects;

import com.example.generator.BuildConfig;

public enum ShapeType {
	CIRCLE		(360, 0), 
	TRIANGLE	(3, 0), 
	SQUARE		(4, 0),	 
	PENTAGON	(5, 0), 
	HEXAGON		(6, 0), 
	OCTAGON		(8, 0), 
	STAR		(5, 5);
	
	private final int 	outerPoints, 
						innerPoints;
	ShapeType (final int outerPoints, final int innerPoints) {
		if (BuildConfig.DEBUG) { assert outerPoints > 2; } 
		this.outerPoints = outerPoints;
		this.innerPoints = innerPoints;
	}
	
	/**
	 * Overrides the inherited toString() method and will
	 * return the name with the first letter capitalized
	 * and the rest as lower case. <br>
	 * <b>ex.</b> CIRCLE -> "Circle"
	 * @return the name of the shape.
	 */
	@Override
	public final String toString() {
		return this.name().substring(0, 1).toUpperCase() +
			   this.name().substring(1, this.name().length()).toLowerCase();
	}
	
	/**
	 * Provides the points in the outer ring of the shape
	 * @return the amount of outer points in the shape.
	 */
	public final int getOuterPoints() {
		return this.outerPoints;
	}
	
	/**
	 * Provides the points in the inner ring of the shape
	 * most shapes will not utilize this data.
	 * @return the amount of inner points in the shape.
	 */
	public final int getInnerPoints() {
		return this.innerPoints;
	}
}
