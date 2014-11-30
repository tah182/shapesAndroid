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

import com.example.generator.BuildConfig;

import android.R;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

public class Shape extends AbstractShape {
	private Point centerPoint;
	private ArrayList<Point> endPoints;
	
	//TODO we need to add the max area width and max area height to the AbstractShape object
	// this is need to validate changes to the center point and the end points of the object
	
	public Shape(int _rotationSpeed, 
				 int _radiusLength, 
				 boolean isRotating, 
				 ShapeType _shapeType) {
		super(_rotationSpeed, _radiusLength, isRotating, _shapeType);
		
		if(_shapeType == null) { 
			throw new IllegalArgumentException("shapeType cannot be null");
		} 
		
		this.centerPoint = getRandomCenterPoint(_radiusLength);
		this.endPoints = new ArrayList<Point>(20);
		
		//TODO write generation of centerPoint randomly.
		// must be within the bounds of the screen-radius;
		// before we can generate a random point, we need to pass the screen a reference to the Display from the activity
		/*
			// From the activity, or the application state object:
			android.view.Display activityArea = getWindowManager().getDefaultDisplay();
			
			Shape bob = new Shape(activityArea);
			
			// inside the default constructor for Shape
			android.graphics.Rect screen = new android.graphics.Rect();
			activityArea.getRectSize(screen);
			
			_centerPoint = new Point(getRandomInt(screen.width()), 
									 getRandomInt(screen.height())); 
		*/
	}
	
	public Shape(int _rotationSpeed, 
				 int _radiusLength, 
				 boolean isRotating, 
				 ShapeType _shapeType, 
				 Point _centerPoint) {
		super(_rotationSpeed, _radiusLength, isRotating, _shapeType);
		
		if(_shapeType == null) { 
			throw new IllegalArgumentException("shapeType cannot be null");
		} else if(_centerPoint == null){ 
			throw new IllegalArgumentException("centerPoint cannot be null");
		}
		
		this.centerPoint = _centerPoint;
		this.endPoints = new ArrayList<Point>(20);
	}
	
	public Shape() {
		this(getRandomInt(100), 
			 getRandomInt(100), 
			 getRandomInt(10) % 2 == 0, 
			 getRandomShapeType());
		
		this.endPoints = new ArrayList<Point>(20);
	}
	
	/**
	 * Generates a random number between 0 and the upperBound
	 * @param upperBound the upperBound of the random int
	 * @return the random number generated
	 */
	private static int getRandomInt(int upperBound) {
		Random r = new Random();
		return r.nextInt(upperBound);
	}
	
	private static Point getRandomCenterPoint(int radiusLength){
		Point cp = new Point(getRandomInt(Shape.getScreenWidth() - radiusLength), 
				   			 getRandomInt(Shape.getScreenHeight() - radiusLength));
		
		while(cp.x  < radiusLength) { 
			cp.set(getRandomInt(Shape.getScreenWidth() - radiusLength), cp.y);
		}
		
		while(cp.y  < radiusLength) { 
			cp.set(cp.x,  getRandomInt(Shape.getScreenHeight() - radiusLength));
		}
		
		return cp;
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
	public ArrayList<Point> getEndPoints()	{ return endPoints; }
	
	public void setCenterPoint(Point c) {
		if(c == null){
			throw new IllegalArgumentException("Point c cannot be null");
		}
		
		centerPoint = c;
	}
	
	
	public void addEndPoint(Point e) {
		if(e == null) { 
			throw new IllegalArgumentException("Point e cannot be null");
		}
		
		endPoints.add(e);
	}
	
	
	public void removeEndPoint(Point e) { 
		if(e == null) { 
			throw new IllegalArgumentException("Point e cannot be null");
		}
		
		endPoints.remove(e);
	}
	
	@Override
	public void rotate() {
		this.getPath().rotateShape(this);
	}
	
	// Should we make this abstract too??
	public void move() {
		this.getPath().moveShape(this);
	}
	
	@Override 
	public boolean equals(Object o){
		if(o == null){
			return false;
		} else if(o instanceof Shape){
			Shape s = (Shape) o;
			
			if(this.getPath() != null){ 
			   if(s.getPath() == null){
				   return false;
			   } else if(!this.getPath().equals(s.getPath())){
				   return false;
			   }
			}
			
			if(this.getCenterPoint().equals(s.getCenterPoint()) &&
			   this.isRotatingClockwise() == s.isRotatingClockwise() &&
			   this.getRadiusLength() == s.getRadiusLength() &&
			   this.getRotationSpeed() == s.getRotationSpeed() &&
			   this.getShapeType() == s.getShapeType() &&
			   this.getEndPoints().size() == s.getEndPoints().size()){
				
				ArrayList<Point> endPoints = this.getEndPoints();
				ArrayList<Point> otherEndPoints = s.getEndPoints();
				
				for(int i = 0; i < endPoints.size(); i++){
					if(!endPoints.get(i).equals(otherEndPoints.get(i))){
						return false;
					}
				}
				
				return true;
			} else { 
				return false;
			}
		} else { 
			return false;	
		}
	}
}
