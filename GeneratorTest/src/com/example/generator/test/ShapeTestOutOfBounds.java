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
	private int rotationSpeedGood;
	private int radiusLengthGood;
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
		this.rotationSpeedGood = 1;
		this.radiusLengthGood = 1;
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
}


