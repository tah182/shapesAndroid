/**
 * Class LinearVector. Used to determine direction and velocity of object
 *  
 * @author 	James Cootware
 * @version	1.0
 */
package Objects;

import android.graphics.Point;

public class LinearVector {
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
	}
	
	public int getDpiPerSecond(){ return dpiPerSecond; }
	
	public double getDirectionInDegrees(){ return directionInDegrees; } 
	
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
		double initialAngle = (1.0 * s.getEndPoints().get(0).y - s.getCenterPoint().y) / 
							  (1.0 * s.getEndPoints().get(0).x - s.getCenterPoint().x);
		
		// initial angle is created from the slope between the center point and the initial endpoint
		initialAngle = Math.atan(initialAngle);

		// loops through the remaining endpoints 
		for(int i = 1; i < s.getShapeType().getOuterPoints(); i++){
			double theta = angle * i + initialAngle;
			
			int y = (int)( Math.sin(theta) * s.getRadiusLength() ) + s.getCenterPoint().y;
			int x = (int)( Math.cos(theta) * s.getRadiusLength() ) + s.getCenterPoint().x;
			
			Point nextEndPoint = new Point(x,y);
			s.addEndPoint(nextEndPoint);
		}
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
		y = (int)( Math.sin(theta) * dpiPerSecond );
		
		s.setCenterPoint(new Point(x + s.getCenterPoint().x, 
								   y + s.getCenterPoint().y)
		);
		
		s.getEndPoints().set(0, new Point(x + s.getEndPoints().get(0).x, 
									      y + s.getEndPoints().get(0).y)
		);
		
		createShapeEndPoints(s);
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
