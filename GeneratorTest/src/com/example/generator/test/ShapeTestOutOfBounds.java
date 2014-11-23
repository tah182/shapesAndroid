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
import android.util.Log;
import Objects.LinearVector;
import Objects.Shape;
import Objects.ShapeType;

@RunWith(Parameterized.class)
public class ShapeTestOutOfBounds extends TestCase {
	private int rotationSpeedParam;
	private int radiusLengthParam;
	private boolean isRotatingParam; 
	private ShapeType shapeTypeParam;
	private Point centerPointParam;
	
	
	public ShapeTestOutOfBounds(){

	}
	
	@Override
	public void setUp(){
		// Negative rotation speed and radius length
		this.rotationSpeedParam = -1;
		this.radiusLengthParam = -1;
		this.isRotatingParam = true; 
		this.shapeTypeParam = ShapeType.SQUARE;
		this.centerPointParam = new Point(1,1);
		
		// rotation speed and radius length out of bounds
//		this.rotationSpeedParam = 51;
//		this.radiusLengthParam = 101;
//		this.isRotatingParam = true; 
//		this.shapeTypeParam = ShapeType.SQUARE;
//		this.centerPointParam = new Point(1,1);

	}
	
	@Override 
	public void tearDown(){
		
	}	
    
    @Test // Test for the AbstractShape and Shape constructors
	public void testAbstractShapeException() {
    	try { 
	    	Shape testShape = new Shape(rotationSpeedParam, 
	    								radiusLengthParam, 
	    								isRotatingParam, 
	    								shapeTypeParam, 
	    								centerPointParam);
	    	
	    	fail("IllegalArgumentException should have been throw, but wasn't");
    	} catch (IllegalArgumentException iae){
    		// success
    	}
	}
    
	@Test // need the activity and / or the application state object done first
	public void testShapeConstructorRandomCenterpoint() {
		fail("Not yet implemented");
	}
	
	@Test // need the activity and / or the application state object done first
	public void testShapeConstructorDefault() {
		fail("Not yet implemented");
	}

	@Test
	public void testLinearVectorException() {
		try{
			LinearVector lv = new LinearVector(20, 45.0);
			
			fail("IllegalArgumentException should have been throw, but wasn't");
		} catch (IllegalArgumentException iae){	
			// success
		}
	}
	
	@Test
	public void testMoveShapeMissingEndPoints() { 
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
		testShape.setPath(new LinearVector(20, 45.0));
		
		try {
			testShape.move();
			
			fail("IllegalStateException should have been thrown, but wasn't");
		} catch(IllegalStateException ise) {
			// success
		}
	}
	
	@Test
	public void testRotateShapeMissingEndpoints() { 
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
		
		testShape.setPath(new LinearVector(20, 45.0));

		try {
			testShape.rotate();
			
			fail("IllegalStateException should have been thrown, but wasn't");
		} catch(IllegalStateException ise) {
			// success
		}
	
	}
}


