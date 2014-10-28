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
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	public int getDpiPerSecond(){ return dpiPerSecond; }
	
	public double getDirectionInDegrees(){ return directionInDegrees; } 
	
	public void createShapeEndPoints(Shape s){
		if(s.getEndPoints().length < 1){
			int x, y;
			x = s.getCenterPoint().x + s.getRadiusLength();
			y = s.getCenterPoint().y;
			
			Point firstEndPoint = new Point(x,y);
			s.addEndPoint(firstEndPoint);
		}
		
		double angle = 360 / s.getShapeType().getOuterPoints();
		
		for(int i = 1; i <= s.getShapeType().getOuterPoints(); i++){
			double currentAngle = angle * i;
			double theta = currentAngle * Math.PI / 180.0;
			int y = (int)( Math.sin(theta) * s.getRadiusLength() );
			int x = (int)( Math.cos(theta) * s.getRadiusLength() );
			
			Point nextEndPoint = new Point(x,y);
			s.addEndPoint(nextEndPoint);
		}
		
	}
}
