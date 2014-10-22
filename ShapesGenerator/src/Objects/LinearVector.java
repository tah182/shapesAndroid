/**
 * Class LinearVector. Used to determine direction and velocity of object
 *  
 * @author 	James Cootware
 * @version	1.0
 */
package Objects;

public class LinearVector {
	private int dpiPerSecond;
	private double directionInDegrees;
	
	public LinearVector(int _dpiPerSecond, double _directionInDegrees){
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	public int getDpiPerSecond(){ return dpiPerSecond; }
	
	public double getDirectionInDegrees(){ return directionInDegrees; } 
}
