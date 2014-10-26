/**
 * Class Shape. Inherits from AbstractShape and implements comparable
 * Used to create a shape that can be displayed and animated on an Activity
 *  
 * @author 	James Cootware
 * @version	1.0
 */

package Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.graphics.Point;

public class Shape extends AbstractShape {
	private Point centerPoint;
	private LinkedList<Point> endPoints;
	
	public Shape(int _rotationSpeed, 
				 int _radiusLength, 
				 boolean isRotating, 
				 ShapeType _shapeType) {
		super(_rotationSpeed, _radiusLength, isRotating, _shapeType);
		
		//TODO write generation of centerPoint randomly.
		// must be within the bounds of the screen-radius;
	}
	
	public Shape(int _rotationSpeed, 
				 int _radiusLength, 
				 boolean isRotating, 
				 ShapeType _shapeType, 
				 Point _centerPoint) {
		super(_rotationSpeed, _radiusLength, isRotating, _shapeType);
		
		this.centerPoint = _centerPoint;
	}
	
	public Shape() {
		this(getRandomInt(100), 
			 getRandomInt(100), 
			 getRandomInt(10) % 2 == 0, 
			 getRandomShapeType());
	}
	
	/**
	 * Generates a random number between 0 and the upperBound
	 * @param upperBound the upperBound of the random int
	 * @return the random number generated
	 */
	private static int getRandomInt(int upperBound) {
		Random r = new Random();
		return r.nextInt() * upperBound;
	}
	
	private static ShapeType getRandomShapeType() {
		// Generate list of Enums and call Shuffle property of List
		List<ShapeType> shapes = new ArrayList<ShapeType>(Arrays.asList(ShapeType.values()));
		Collections.shuffle(shapes);
		
		if (shapes.size() > 0) 
			return shapes.get(0);
		
		throw new ArrayIndexOutOfBoundsException ("Random Generation of ShapeTypes could not generate.");
	}

	public Point getCenterPoint()	{ return centerPoint; } 
	public Point[] getEndPoints()	{ return (Point[])endPoints.toArray(); }
	
	
	public void setCenterPoint(Point c) { 
		
	}
	
	
	public void addEndPoint(Point e) {
		
	}
	
	
	public void removeEndPoint(Point e) { 
		
	}
	
	
	@Override
	public void rotate() {

	}
	
	@Override 
	public boolean equals(Object o){
		return false;
	}
}
