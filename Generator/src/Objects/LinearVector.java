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
		}
		
		// create the angle increment based on number of points divided by 360
		// all angles are converted to radians
		double angle = Math.toRadians( 360.0 / s.getShapeType().getOuterPoints() );
		double initialAngle = (1.0 * s.getEndPoints().get(0).y - s.getCenterPoint().y) / 
							  (1.0 * s.getEndPoints().get(0).x - s.getCenterPoint().x);
		
		// initial angle is created from the slope between the center point and the initial endpoint
		initialAngle = Math.atan(Math.toRadians(initialAngle));
		
		// loops through the remaining endpoints 
		for(int i = 2; i <= s.getShapeType().getOuterPoints(); i++){
			double theta = angle * i + initialAngle;
			
			int y = (int)( Math.sin(theta) * s.getRadiusLength() ) + s.getCenterPoint().y;
			int x = (int)( Math.cos(theta) * s.getRadiusLength() ) + s.getCenterPoint().x;
			
			Point nextEndPoint = new Point(x,y);
			s.addEndPoint(nextEndPoint);
		}
		
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
