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
	private Point testPointParam;
	
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
		this.testPointParam = new Point(2,2);
		
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
    	Shape testShape = new Shape(rotationSpeedParam, 
    								radiusLengthParam, 
    								isRotatingParam, 
    								shapeTypeParam, 
    								centerPointParam);
    	
    	assertEquals(rotationSpeedParam, testShape.getRotationSpeed());
    	assertEquals(radiusLengthParam, testShape.getRadiusLength());
    	assertEquals(isRotatingParam, testShape.isRotatingClockwise());
    	assertEquals(shapeTypeParam, testShape.getShapeType());
    	assertEquals(centerPointParam, testShape.getCenterPoint());
	}
    
	@Test // need the activity and / or the application state object done first
	public void testShapeConstructorRandomCenterpoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testShapeSetCenterpoint() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
    	testShape.setCenterPoint(testPointParam);
    	
    	assertEquals(testPointParam, testShape.getCenterPoint());
	}
	
	@Test // need the activity and / or the application state object done first
	public void testShapeConstructorDefault() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetEndPoints() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
    	assertEquals(0, testShape.getEndPoints().size());
	}

	@Test
	public void testAddEndPoint() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
    	testShape.addEndPoint(testPointParam);
    	
    	assertEquals(testPointParam, testShape.getEndPoints().get(0));
	}

	@Test
	public void testRemoveEndPoint() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
    	testShape.addEndPoint(testPointParam);
    	testShape.removeEndPoint(testPointParam);
    	
    	assertFalse(testShape.getEndPoints().contains(testPointParam));
	}

	@Test
	public void testEqualsObject() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
    	Shape testShape2 = new Shape(rotationSpeedParam, 
									 radiusLengthParam, 
									 isRotatingParam, 
									 shapeTypeParam, 
									 centerPointParam);
		
		assertEquals(testShape, testShape2);
	}

	@Test
	public void testLinearVectorCreateShapeEndPoints() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
		
    	String pointList = "";
    	for(Point p : testShape.getEndPoints()){
    		pointList += "[" + p.x + ", " + p.y + "], ";
    	}
    	
    	//Log.d("ShapeTest", "End Points Before createShapeEndPoints(): " + pointList.substring(0, pointList.length() - 2));
    	
    	testShape.setPath(new LinearVector(20, 45.0));
    	testShape.getPath().createShapeEndPoints(testShape);
    	
    	pointList = "";
    	
    	for(Point p : testShape.getEndPoints()){
    		pointList += "[" + p.x + ", " + p.y + "], ";
    	}
    	
    	//Log.d("ShapeTest", "testLinearVectorCreateShapeEndPoints: End Points After createShapeEndPoints(): " + pointList.substring(0, pointList.length() - 2));
		
		assertTrue(true);
	}
	
	@Test
	public void testMoveShape() { 
    	Shape testShape = new Shape(rotationSpeedParam, 
				radiusLengthParam, 
				isRotatingParam, 
				shapeTypeParam, 
				centerPointParam);

		String pointList = "";
		for(Point p : testShape.getEndPoints()){
			pointList += "[" + p.x + ", " + p.y + "], ";	
		}
		
		//Log.d("ShapeTest", "End Points Before createShapeEndPoints(): " + pointList.substring(0, pointList.length() - 2));
		
		testShape.setPath(new LinearVector(20, 45.0));
		testShape.getPath().createShapeEndPoints(testShape);
		
		pointList = "";
		
		for(Point p : testShape.getEndPoints()){
			pointList += "[" + p.x + ", " + p.y + "], ";
		}
		
		//Log.d("ShapeTest", "testMoveShape: End Points After createShapeEndPoints(): " + pointList.substring(0, pointList.length() - 2));

		pointList = "";
		testShape.move();
		
		for(Point p : testShape.getEndPoints()){
			pointList += "[" + p.x + ", " + p.y + "], ";
		}
		
		//Log.d("ShapeTest", "testMoveShape: End Points After move(): " + pointList.substring(0, pointList.length() - 2));
		
		assertTrue(true);
	}
	
	@Test
	public void testRotateShape() { 
    	Shape testShape = new Shape(rotationSpeedParam, 
				radiusLengthParam, 
				isRotatingParam, 
				shapeTypeParam, 
				centerPointParam);

		String pointList = "";
		
		testShape.setPath(new LinearVector(20, 45.0));
		testShape.getPath().createShapeEndPoints(testShape);
		
		pointList = "";
		
		for(Point p : testShape.getEndPoints()){
			pointList += "[" + p.x + ", " + p.y + "], ";
		}
		
		Log.d("ShapeTest", "testRotateShape: End Points After createShapeEndPoints(): " + pointList.substring(0, pointList.length() - 2));
		
		pointList = "";
		testShape.rotate();
		
		for(Point p : testShape.getEndPoints()){
			pointList += "[" + p.x + ", " + p.y + "], ";
		}
		
		Log.d("ShapeTest", "testRotateShape: End Points After rotate(): " + pointList.substring(0, pointList.length() - 2));
		
		assertTrue(true);
	}
}


