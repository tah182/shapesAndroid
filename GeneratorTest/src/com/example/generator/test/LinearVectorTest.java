package com.example.generator.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;

import android.graphics.Point;
import android.util.Log;
import Objects.LinearVector;
import Objects.Shape;
import Objects.ShapeType;

@RunWith(Parameterized.class)
public class LinearVectorTest extends TestCase {
	// Shape params
	private int rotationSpeedParam;
	private int radiusLengthParam;
	private boolean isRotatingParam; 
	private ShapeType shapeTypeParam;
	private Point centerPointParam;
	
	// Invalid LinearVector params
	private int invalidDpiPerSecond;
	private double invalidDirectionInDegrees;
	
	// Valid LinearVector params
	private int validDpiPerSecond;
	private double validDirectionInDegrees;
	
	//valid endpoints after LinearVector.createEndPoints()
	private ArrayList<Point> validAfterCreate = new ArrayList<Point>(10);
	
	//valid endpoints after LinearVector.moveShape()
	private ArrayList<Point> validAfterMove = new ArrayList<Point>(10);
	
	//valid endpoints after LinearVector.rotateShape()
	private ArrayList<Point> validAfterRotate = new ArrayList<Point>(10);
	
	//angles for reflection
	private double q1;
	private double q2;
	private double q3;
	private double q4;
	
	private double q1XResult;
	private double q2XResult;
	private double q3XResult;
	private double q4XResult;
	
	private double q1YResult;
	private double q2YResult;
	private double q3YResult;
	private double q4YResult;
	
	public LinearVectorTest(){

	}
	
	@Override
	public void setUp(){
		// Valid Shape Params
		this.rotationSpeedParam = 15;
		this.radiusLengthParam = 10;
		this.isRotatingParam = true; 
		this.shapeTypeParam = ShapeType.HEXAGON;
		this.centerPointParam = new Point(50,50);
		
		// Invalid LinearVector Params
		this.invalidDirectionInDegrees = -45.0;
		this.invalidDpiPerSecond = -20;
		
		// Valid LinearVector Params
		this.validDirectionInDegrees = 45.0;
		this.validDpiPerSecond = 20;
		
		//Valid endpoints after createEndPoints()
		this.validAfterCreate.add(new Point(60, 50));
		this.validAfterCreate.add(new Point(55, 58));
		this.validAfterCreate.add(new Point(46, 58));
		this.validAfterCreate.add(new Point(40, 50));
		this.validAfterCreate.add(new Point(45, 42));
		this.validAfterCreate.add(new Point(54, 42));
		
		// Valid endpoints after move()
		this.validAfterMove.add(new Point(74, 64));
		this.validAfterMove.add(new Point(69, 72));
		this.validAfterMove.add(new Point(60, 72));
		this.validAfterMove.add(new Point(54, 64));
		this.validAfterMove.add(new Point(59, 56));
		this.validAfterMove.add(new Point(68, 56));
		
		// Valid endpoints after rotate()
		this.validAfterRotate.add(new Point(59, 52));
		this.validAfterRotate.add(new Point(53, 59));
		this.validAfterRotate.add(new Point(44, 57));
		this.validAfterRotate.add(new Point(41, 48));
		this.validAfterRotate.add(new Point(47, 41));
		this.validAfterRotate.add(new Point(56, 43));
		
		// Starting angles before reflectAngleOnX() and reflectAngleOnY()
		q1 = 27.0;
		q2 = 107.0;
		q3 = 207.0;
		q4 = 297.0;
		
		// Valid angles after reflectAngleOnX()
		q1XResult = 333.0;
		q2XResult = 253.0;
		q3XResult = 153.0;
		q4XResult = 63.0;
		
		// Valid angles after reflectAngleOnY()
		q1YResult = 153.0;
		q2YResult = 73.0;
		q3YResult = 333.0;
		q4YResult = 243.0;
	}
	
	@Override 
	public void tearDown(){
		
	}	

	@Test
	public void testLinearVector() {
		try{
			LinearVector lv = new LinearVector(validDpiPerSecond, validDirectionInDegrees);
			
			assertEquals(validDirectionInDegrees, lv.getDirectionInDegrees());
			assertEquals(validDpiPerSecond, lv.getDpiPerSecond());
		} catch (IllegalArgumentException iae){	
			fail("IllegalArgumentException should not have been thrown");
		}
	}
	
	@Test
	public void testLinearVectorCreateShapeEndPoints() {
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
		
    	
    	
    	testShape.setPath(new LinearVector(validDpiPerSecond, validDirectionInDegrees));
    	testShape.getPath().createShapeEndPoints(testShape);
    	
		ArrayList<Point> list = testShape.getEndPoints();
		
		for(int i = 0; i < list.size(); i++){
			assertEquals(validAfterCreate.get(i), list.get(i));
		}
    	
//    	// used for testing endpoints
//    	String pointList = "";
//    	
//    	for(Point p : testShape.getEndPoints()){
//    		pointList += "[" + p.x + ", " + p.y + "], ";
//    	}
//    	
//    	Log.d("ShapeTest", "testLinearVectorCreateShapeEndPoints: End Points After createShapeEndPoints(): " + pointList.substring(0, pointList.length() - 2));
	}
	
	@Test
	public void testMoveShape() { 
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
    	
		testShape.setPath(new LinearVector(validDpiPerSecond, validDirectionInDegrees));
		testShape.getPath().createShapeEndPoints(testShape);
		
		try {
			testShape.move();
			
			ArrayList<Point> list = testShape.getEndPoints();
			
			for(int i = 0; i < list.size(); i++){
				assertEquals(validAfterMove.get(i), list.get(i));
			}
			
		} catch(IllegalStateException ise) {
			fail("IllegalStateException should not have been thrown");
		}
	}
	
	@Test
	public void testRotateShape() { 
    	Shape testShape = new Shape(rotationSpeedParam, 
									radiusLengthParam, 
									isRotatingParam, 
									shapeTypeParam, 
									centerPointParam);
		
		testShape.setPath(new LinearVector(validDpiPerSecond, validDirectionInDegrees));
		testShape.getPath().createShapeEndPoints(testShape);
		
		try {
			testShape.rotate();
			
			ArrayList<Point> list = testShape.getEndPoints();
			
			for(int i = 0; i < list.size(); i++){
				assertEquals(validAfterRotate.get(i), list.get(i));
			}
			
		} catch(IllegalStateException ise) {
			fail("IllegalStateException should not have been thrown");
		}
	
	}
	
	@Test
	public void testReflectAngleOnX(){
    	Shape testShape = new Shape(rotationSpeedParam, 
				radiusLengthParam, 
				isRotatingParam, 
				shapeTypeParam, 
				centerPointParam);

    	// Starting angle in 1st quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q1));
    	testShape.getPath().reflectAngleOnX();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q1XResult);
    	
    	// Starting angle in 2nd quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q2));
    	testShape.getPath().reflectAngleOnX();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q2XResult);
    	
    	// Starting angle in 3rd quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q3));
    	testShape.getPath().reflectAngleOnX();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q3XResult);
    	
    	// Starting angle in 4th quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q4));
    	testShape.getPath().reflectAngleOnX();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q4XResult);
	}
	
	@Test
	public void testReflectAngleOnY(){
    	Shape testShape = new Shape(rotationSpeedParam, 
				radiusLengthParam, 
				isRotatingParam, 
				shapeTypeParam, 
				centerPointParam);

    	// Starting angle in 1st quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q1));
    	testShape.getPath().reflectAngleOnY();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q1YResult);
    	
    	// Starting angle in 2nd quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q2));
    	testShape.getPath().reflectAngleOnY();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q2YResult);
    	
    	// Starting angle in 3rd quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q3));
    	testShape.getPath().reflectAngleOnY();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q3YResult);
    	
    	// Starting angle in 4th quadrant 
    	testShape.setPath(new LinearVector(validDpiPerSecond, q4));
    	testShape.getPath().reflectAngleOnY();
    	
    	assertEquals(testShape.getPath().getDirectionInDegrees(), q4YResult);
	}
}


