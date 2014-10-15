/**
 * Parent Class AbstractShape. All information regarding shapes will extend this class.
 * @author 	Tah Tatsumoto
 * @version	1.0
 */
package Objects;

public abstract class AbstractShape {
	private int rotationSpeed;
	private int radiusLength;
	private boolean rotate;
	private ShapeType shapeType;
	
	/**
	 * 
	 * @param aRotationSpeed
	 * @param aRadiusLength
	 * @param isRotating
	 * @param aShapeType
	 */
	public AbstractShape(int aRotationSpeed, int aRadiusLength, boolean isRotating, ShapeType aShapeType){
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	public int getRotationSpeed() { return rotationSpeed; } 
	public int getRadiusLength() { return radiusLength; }
	public boolean isRotating() { return rotate; }
	public ShapeType getShapeType() { return shapeType; } 
	
	public void setRotationSpeed(int aRotationSpeed){
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	public void setRadiusLength(int aRadiusLength){
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	public void setRotation(boolean isRotating){
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	public void setShapeType(ShapeType aShapeType){
		// not implemented yet for testing
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	/*
	 * Calculates new rotation points 
	 */
	public abstract void rotate();	
	
	public boolean getRotation(){
		return false;
	}
}
