/**
 * Parent Class AbstractShape. All information regarding shapes will extend this class.
 * @author 	Tah Tatsumoto
 * @version	1.0
 */
package Objects;

public abstract class AbstractShape {
	private final int rotationSpeed;
	private final int radiusLength;
	private final boolean clockwiseRotation;
	private final ShapeType shapeType;
	
	private LinearVector path;
	
	public AbstractShape(final int _rotationSpeed, 
						final int _radiusLength, 
						final boolean _clockwiseRotation, 
						final ShapeType _shapeType) {
		
		if (_rotationSpeed > 100 || _rotationSpeed < 0)
			throw new IndexOutOfBoundsException ("Rotation must be between 0 and 100");
		
		this.rotationSpeed = _rotationSpeed;
		this.radiusLength = _radiusLength;
		this.clockwiseRotation = _clockwiseRotation;
		this.shapeType = _shapeType;
	}
	
	public boolean getRotation(){
		return false;
	}
	public int getRotationSpeed() {
		return rotationSpeed; 
	}
	public int getRadiusLength() {
		return radiusLength; 
	}
	public boolean isRotatingClockwise() { 
		return clockwiseRotation; 
	}
	public ShapeType getShapeType() {
		return shapeType; 
	}
	public LinearVector getPath() {
		return path; 
	}
	
	// Deprechated, these properties will be immutable
//	public void setRotationSpeed(int _rotationSpeed){
//		// not implemented yet for testing
//		throw new UnsupportedOperationException("not yet implemented");
//	}
//	
//	public void setRadiusLength(int _radiusLength){
//		// not implemented yet for testing
//		throw new UnsupportedOperationException("not yet implemented");
//	}
//	
//	public void setRotation(boolean isRotating){
//		// not implemented yet for testing
//		throw new UnsupportedOperationException("not yet implemented");
//	}
//	
//	public void setShapeType(ShapeType _shapeType){
//		// not implemented yet for testing
//		throw new UnsupportedOperationException("not yet implemented");
//	}
//	
//	public void setPath(LinearVector _path){
//		// not implemented yet for testing
//		throw new UnsupportedOperationException("not yet implemented");		
//	}
	
	/**
	 * Calculates new rotation points 
	 */
	public abstract void rotate();	
	
}
