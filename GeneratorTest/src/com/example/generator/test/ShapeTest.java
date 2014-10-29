package com.example.generator.test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

import android.graphics.Point;
import android.test.AndroidTestCase;
import android.test.AndroidTestRunner;
import Objects.Shape;
import Objects.ShapeType;

@RunWith(Parameterized.class)
public class ShapeTest extends TestCase {
	private int rotationSpeedParam;
	private int radiusLengthParam;
	private boolean isRotatingParam; 
	private ShapeType shapeTypeParam;
	private Point centerPointParam;
	
	public ShapeTest(){

	}
	
	@Override
	public void setUp(){
		// All parameters valid values
		this.rotationSpeedParam = 1;
		this.radiusLengthParam = 1;
		this.isRotatingParam = true; 
		this.shapeTypeParam = ShapeType.SQUARE;
		this.centerPointParam = new Point(1,1);
		
		// Negative rotation speed and radius length
//		this.rotationSpeedParam = -1;
//		this.radiusLengthParam = -1;
//		this.isRotatingParam = true; 
//		this.shapeTypeParam = ShapeType.SQUARE;
//		this.centerPointParam = new Point(1,1);
//		
		// rotation speed and radius length out of bounds
//		this.rotationSpeedParam = 51;
//		this.radiusLengthParam = 101;
//		this.isRotatingParam = true; 
//		this.shapeTypeParam = ShapeType.SQUARE;
//		this.centerPointParam = new Point(1,1);
//		
		// null ShapeType and Point
//		this.rotationSpeedParam = 1;
//		this.radiusLengthParam = 1;
//		this.isRotatingParam = true; 
//		this.shapeTypeParam = null;
//		this.centerPointParam = null;
//		
		// Negative Point location
//		this.rotationSpeedParam = 1;
//		this.radiusLengthParam = 1;
//		this.isRotatingParam = true; 
//		this.shapeTypeParam = ShapeType.SQUARE;
//		this.centerPointParam = new Point(-1,-1);
	}
	
	@Override 
	public void tearDown(){
		
	}	
	
//    @Parameters
//    public static Collection<Object[]> constructorParams() {
//        return Arrays.asList(
//			new Object[][] { 
//				
//				// All parameters valid values
//				{ 1, 1, true, ShapeType.SQUARE, new Point(0,0) },
//				
//				// Negative rotation speed and radius length
//				{ -1, -1, true, ShapeType.SQUARE, new Point(0,0) },
//				
//				// rotation speed and radius length out of bounds
//				{ 51, 101, true, ShapeType.SQUARE, new Point(0,0) },
//				
//				// null ShapeType and Point
//				{ 1, 1, true, null, null },
//				
//				// Negative Point location
//				{ 1, 1, true, ShapeType.SQUARE, new Point(0,0) }
//	
//			}
//		);
//    }
    
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
