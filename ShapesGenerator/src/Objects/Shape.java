/**
 * Class Shape. Inherits from AbstractShape and implements comparable
 * Used to create a shape that can be displayed and animated on an Activity
 *  
 * @author 	James Cootware
 * @version	1.0
 */

package Objects;

import java.util.LinkedList;
import android.graphics.Point;

public class Shape extends AbstractShape implements Comparable<Shape> {
	private Point centerPoint;
	private LinkedList<Point> endPoints;
	
	public Shape(int _rotationSpeed, 
				 int _radiusLength, 
				 boolean isRotating, 
				 ShapeType _shapeType) {
		
		super(_rotationSpeed, _radiusLength, isRotating, _shapeType);
	}
	
	public Shape(int _rotationSpeed, 
				 int _radiusLength, 
				 boolean isRotating, 
				 ShapeType _shapeType, 
				 Point _centerPoint) {
		
		super(_rotationSpeed, _radiusLength, isRotating, _shapeType);
	}

	public Point getCenterPoint(){ return centerPoint; } 
	public Point[] getEndPoints(){ return (Point[])endPoints.toArray(); }
	
	
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

	@Override
	public int compareTo(Shape another) {
		return 0;
	}
}
