package com.example.generator.test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
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
public class ShapeTestBadObjects extends TestCase {
	private int rotationSpeedParam;
	private int radiusLengthParam;
	private boolean isRotatingParam; 
	private ShapeType shapeTypeParam;
	private Point centerPointParam;
	private ShapeType shapeTypeGood;
	private Point centerPointGood;
	private Point goodPointParam;
	private Point badPointParam;
	
	public ShapeTestBadObjects(){

	}
	
	@Override
	public void setUp(){
		//null ShapeType and Point
		this.rotationSpeedParam = 1;
		this.radiusLengthParam = 1;
		this.isRotatingParam = true; 
		this.shapeTypeParam = null;
		this.centerPointParam = null;
		this.shapeTypeGood = ShapeType.HEXAGON;
		this.centerPointGood = new Point(10,10);;
		this.goodPointParam = new Point(2,2);
		this.badPointParam = null;
		
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
    
    @Test // Test for the AbstractShape and Shape constructors
	public void testAbstractShape() {
    	try{
	    	Shape testShape = new Shape(rotationSpeedParam, 
	    								radiusLengthParam, 
	    								isRotatingParam, 
	    								shapeTypeParam, 
	    								centerPointParam);
	    	
	    	fail("IllegalArgumentException should have been throw, but wasn't");
    	} catch(IllegalArgumentException iae){
    		//success
    	}
	}
    
	@Test // need the activity and / or the application state object done first
	public void testShapeConstructorRandomCenterpoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testShapeSetCenterpoint() {
		try{
	    	Shape testShape = new Shape(rotationSpeedParam, 
										radiusLengthParam, 
										isRotatingParam, 
										shapeTypeGood, 
										centerPointGood);
	    	
	    	testShape.setCenterPoint(badPointParam);
	    	
	    	fail("IllegalArgumentException should have been throw, but wasn't");
		} catch(IllegalArgumentException iae) { 
			// success
		}
    	
	}
	
	@Test // need the activity and / or the application state object done first
	public void testShapeConstructorDefault() {
		fail("Not yet implemented");
	}
	

	@Test
	public void testAddEndPoint() {
		try {
	    	Shape testShape = new Shape(rotationSpeedParam, 
										radiusLengthParam, 
										isRotatingParam, 
										shapeTypeGood, 
										centerPointGood);
	    	
	    	testShape.addEndPoint(badPointParam);
	    	
	    	fail("IllegalArgumentException should have been thrown, but wasn't");
		} catch (IllegalArgumentException iae){
			//success
		}
	}

	@Test
	public void testRemoveEndPoint() {
		try{ 
	    	Shape testShape = new Shape(rotationSpeedParam, 
										radiusLengthParam, 
										isRotatingParam, 
										shapeTypeGood, 
										centerPointGood);
	    	
	    	testShape.addEndPoint(goodPointParam);
	    	testShape.removeEndPoint(badPointParam);
		} catch (IllegalArgumentException iae) { 
			// success
		}
	}
}


