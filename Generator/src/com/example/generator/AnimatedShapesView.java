package com.example.generator;

import java.util.ArrayList;

import Objects.LinearVector;
import Objects.Shape;
import Objects.ShapeType;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.app.*;

public class AnimatedShapesView extends View {
	private Paint paint = new Paint();
	private Shape s;
	private Path p = new Path();
	
	public AnimatedShapesView(Context context) {
		super(context);
		
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		
		Shape.setScreenWidth(metrics.widthPixels);
		Shape.setScreenHeight(metrics.heightPixels);
		
		s = new Shape(5, 100, true, ShapeType.HEXAGON);
		s.setPath(new LinearVector(25, 25, Shape.getScreenWidth(), Shape.getScreenHeight()));
    	s.getPath().createShapeEndPoints(s);
	}
	
	private void initPath(){
		p = new Path();
	}
	
    @Override
    public void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	
    	paint.setARGB(240, 50, 208, 50);
    	
    	// used for testing endpoints
    	String pointList = "";
    	
    	s.rotate();
    	s.move();
    	
    	pointList = "";
    	for(Point p : s.getEndPoints()){
    		pointList += "[" + p.x + ", " + p.y + "], ";
    	}
    	
    	//Log.i("ShapeTest", "End Points After rotateShape(): " + pointList.substring(0, pointList.length() - 2));
    	
    	ArrayList<Point> points = s.getEndPoints();
    	
    	initPath();
    	
    	for(int i = 0; i < points.size(); i++){
    		if(i == 0) { 
    			p.moveTo(points.get(i).x, points.get(i).y);
    		} else { 
    			p.lineTo(points.get(i).x, points.get(i).y);
    		}
    	}
    	
    	canvas.drawPath(p, paint);
    }
}
