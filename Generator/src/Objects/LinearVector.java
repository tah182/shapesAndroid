/**
 * Class LinearVector. Used to determine direction and velocity of object
 *  
 * @author 	James Cootware
 * @version	1.0
 */
package Objects;

import java.util.ArrayList;

import android.graphics.Point;
import android.util.Log;

public class LinearVector {
	private final int MAX_X, MAX_Y;
	
	private ReflectionStatus currentStatus = ReflectionStatus.NONE;
	
	private int dpiPerSecond;
	private double directionInDegrees;
	
	public LinearVector(int _dpiPerSecond, double _directionInDegrees){
		if(_dpiPerSecond < 0) {
			throw new IllegalArgumentException("dpiPerSecond must be greater than zero");
		} else if(_directionInDegrees < 0){
			throw new IllegalArgumentException("directionInDegrees must be greater than zero");
		}
		
		this.dpiPerSecond = _dpiPerSecond;
		this.directionInDegrees = _directionInDegrees;
		this.MAX_X = 1000;
		this.MAX_Y = 1000;
	}
	
	public LinearVector(int _dpiPerSecond, double _directionInDegrees, int _maxX, int _maxY){
		if(_dpiPerSecond < 0) {
			throw new IllegalArgumentException("dpiPerSecond must be greater than zero");
		} else if(_directionInDegrees < 0){
			throw new IllegalArgumentException("directionInDegrees must be greater than zero");
		}
		
		this.dpiPerSecond = _dpiPerSecond;
		this.directionInDegrees = _directionInDegrees;
		this.MAX_X = _maxX;
		this.MAX_Y = _maxY;
	}
	
	public int getDpiPerSecond(){ return dpiPerSecond; }
	
	public double getDirectionInDegrees(){ return directionInDegrees; } 
	
	public void reflectAngleOnY(){
		currentStatus = ReflectionStatus.VERTICAL;
		
		if(directionInDegrees <= 90){
			directionInDegrees = 360 - directionInDegrees;
		} else if(directionInDegrees < 180) { 
			directionInDegrees = 180 + (180 - directionInDegrees);
		} else if(directionInDegrees <= 270) {
			directionInDegrees = 180 - (directionInDegrees - 180);
		} else {
			directionInDegrees = 360 - directionInDegrees;
		}
	}
	
	public void reflectAngleOnX(){
		currentStatus = ReflectionStatus.HORIZONTAL;
		
		if(directionInDegrees <= 180){
			directionInDegrees = 180 - directionInDegrees;
		} else if(directionInDegrees <= 270) {
			directionInDegrees = 360 - (directionInDegrees - 180);
		} else {
			directionInDegrees = 180 + (360 - directionInDegrees);
		}
	}
	
	public void createShapeEndPoints(Shape s){
		//if the first end point doesn't exist, create one with zero initial slope
		if(s.getEndPoints().size() < 1){
			int x, y;
			x = s.getCenterPoint().x + s.getRadiusLength();
			y = s.getCenterPoint().y;
			
			Point firstEndPoint = new Point(x,y);
			s.addEndPoint(firstEndPoint);
		} else { 
			int originalSize = s.getEndPoints().size();
			
			for(int i = 1; i < originalSize; i++){
				s.getEndPoints().remove(1);
			}
		}
		
		// create the angle increment based on number of points divided by 360
		// all angles are converted to radians
		double angle = Math.toRadians( 360.0 / s.getShapeType().getOuterPoints() );
		int rise = s.getEndPoints().get(0).y - s.getCenterPoint().y;
		int run = s.getEndPoints().get(0).x - s.getCenterPoint().x;
		
		double initialAngle = (1.0 * s.getEndPoints().get(0).y - s.getCenterPoint().y) / 
							  (1.0 * s.getEndPoints().get(0).x - s.getCenterPoint().x);
		
		// initial angle is created from the slope between the center point and the initial endpoint
		initialAngle = Math.atan(initialAngle);
		
		// adjusts the initial angle to the outside angle if the inside angle is in the 2nd - 4th quadrant
		if(run < 0 && rise >= 0){
			initialAngle = Math.PI - Math.abs(initialAngle);
		} else if (run < 0 && rise < 0) {
			initialAngle = (3 * Math.PI / 2) - Math.abs(initialAngle);
		} else if (run >= 0 && rise < 0) { 
			initialAngle = (2 * Math.PI) - Math.abs(initialAngle);
		}

		// loops through the remaining endpoints 
		for(int i = 1; i < s.getShapeType().getOuterPoints(); i++){
			double theta = angle * i + initialAngle;

			int y = (int)( Math.sin(theta) * s.getRadiusLength() ) + s.getCenterPoint().y;
			int x = (int)( Math.cos(theta) * s.getRadiusLength() ) + s.getCenterPoint().x;
			
			Point nextEndPoint = new Point(x,y);
			s.addEndPoint(nextEndPoint);
		}
	}
	
	public boolean validateBounds(Shape s){
		ArrayList<Point> ep = s.getEndPoints();

		int xDistance = 0, yDistance = 0;
		
		for(Point p : ep){
			int xTempD= 0, yTempD = 0;
			
			if(p.x <= 0) { 
				xTempD = Math.abs(p.x);
			} else if (p.x >= MAX_X) {
				xTempD = p.x - MAX_X;
			}
			
			xDistance = xDistance < xTempD ? xTempD : xDistance;
			
			if (p.y <= 0) { 
				yTempD = Math.abs(p.y);
			} else if (p.y >= MAX_Y) {
				yTempD = p.y - MAX_Y;
			}
			
			yDistance = yDistance < yTempD ? yTempD : yDistance;
		}
		
		if(xDistance > 0 || yDistance > 0){
			if(xDistance > yDistance){ 
				if(currentStatus != ReflectionStatus.HORIZONTAL){
					reflectAngleOnX();
				}
			} else { 
				if(currentStatus != ReflectionStatus.VERTICAL){
					reflectAngleOnY();
				}
			}
			
			return false;
		}
		
		currentStatus = ReflectionStatus.NONE;
		
		return true;
	}
	
	public void moveShape(Shape s){
		if(s.getEndPoints().size() < 1) { 
			throw new IllegalStateException("The shape does not have any endpoints");			
		} else if(s.getEndPoints().size() != s.getShapeType().getOuterPoints()){
			throw new IllegalStateException("The shape doesn't have the correct number of endpoints for it's ShapeType");
		}
		
		Point newEndPoint;
		Point newCenterPoint;
		int x, y;
		
		double theta = Math.toRadians(directionInDegrees);
		x = (int)( Math.cos(theta) * dpiPerSecond );
		y = (int)( Math.sin(theta) * dpiPerSecond ) * -1;
		
		s.setCenterPoint(new Point(x + s.getCenterPoint().x, 
								   y + s.getCenterPoint().y)
		);
		
		s.getEndPoints().set(0, new Point(x + s.getEndPoints().get(0).x, 
									      y + s.getEndPoints().get(0).y)
		);
		
		createShapeEndPoints(s);
		
		if(!validateBounds(s)){			
			moveShape(s);
		}
	}
	
	public void rotateShape(Shape s) {
		if(s.getEndPoints().size() < 1) { 
			throw new IllegalStateException("The shape does not have any endpoints");			
		} else if(s.getEndPoints().size() != s.getShapeType().getOuterPoints()){
			throw new IllegalStateException("The shape doesn't have the correct number of endpoints for it's ShapeType");
		}
		
		double initialAngle = (1.0 * s.getEndPoints().get(0).y - s.getCenterPoint().y) / 
				  			  (1.0 * s.getEndPoints().get(0).x - s.getCenterPoint().x);

		initialAngle = Math.atan(initialAngle);
		initialAngle += ( s.isRotatingClockwise() ? Math.toRadians(s.getRotationSpeed()) : 
													-1 * Math.toRadians(s.getRotationSpeed()));
		
		int y = (int)( Math.sin(initialAngle) * s.getRadiusLength() ) + s.getCenterPoint().y;
		int x = (int)( Math.cos(initialAngle) * s.getRadiusLength() ) + s.getCenterPoint().x;
		
		s.getEndPoints().set(0, new Point(x,y));
		
		createShapeEndPoints(s);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null){
			return false;
		} else if(o instanceof LinearVector){
			LinearVector lv = (LinearVector) o;
			
			return this.getDirectionInDegrees() == lv.getDirectionInDegrees() &&
				   this.getDpiPerSecond() == lv.getDpiPerSecond();
		} else { 
			return false;
		}
	}
}
