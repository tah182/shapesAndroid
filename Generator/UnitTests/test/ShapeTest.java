package test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestSuite;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

import android.graphics.Point;
import Objects.Shape;
import Objects.ShapeType;

@RunWith(Parameterized.class)
public class ShapeTest extends TestSuite {
	private int rotationSpeedParam;
	private int radiusLengthParam;
	private boolean isRotatingParam; 
	private ShapeType shapeTypeParam;
	private Point centerPointParam;
	
	public ShapeTest(int _rotationSpeed, 
					 int _radiusLength, 
					 boolean _isRotating, 
					 ShapeType _shapeType,
					 Point _centerPoint){
		this.rotationSpeedParam = _rotationSpeed;
		this.radiusLengthParam = _radiusLength;
		this.isRotatingParam = _isRotating; 
		this.shapeTypeParam = _shapeType;
		this.centerPointParam = _centerPoint;
	}
	
    @Parameters
    public static Collection<Object[]> constructorParams() {
        return Arrays.asList(
			new Object[][] { 
				
				// All parameters valid values
				{ 1, 1, true, ShapeType.SQUARE, new Point(0,0) },
				
				// Negative rotation speed and radius length
				{ -1, -1, true, ShapeType.SQUARE, new Point(0,0) },
				
				// rotation speed and radius length out of bounds
				{ 51, 101, true, ShapeType.SQUARE, new Point(0,0) },
				
				// null ShapeType and Point
				{ 1, 1, true, null, null },
				
				// Negative Point location
				{ 1, 1, true, ShapeType.SQUARE, new Point(0,0) }
	
			}
		);
    }
    
    @Test
	public void testAbstractShape() {
    	Shape testShape = new Shape(rotationSpeedParam, 
    								radiusLengthParam, 
    								isRotatingParam, 
    								shapeTypeParam, 
    								centerPointParam);
    	
    	assertEquals(rotationSpeedParam, testShape.getRotationSpeed());
    	assertEquals(radiusLengthParam, testShape.getRadiusLength());
    	assertEquals(isRotatingParam, testShape.isRotatingClockwise());
    	assertEquals(shapeTypeParam, testShape.getShapeType());
	}
    
	@Test
	public void testShapeConstructorRandomCenterpoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testShapeConstructorSetCenterpoint() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testShapeConstructorDefault() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetCenterPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEndPoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCenterPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEndPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEndPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotate() {
		fail("Not yet implemented");
	}

	//TODO figure out how to test the LinearVector path in AbstractShape
}
