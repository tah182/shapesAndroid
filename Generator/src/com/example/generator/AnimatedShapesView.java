package com.example.generator;

import java.util.concurrent.ConcurrentLinkedQueue;
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
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
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
	private Path p = new Path();
	private ConcurrentLinkedQueue<Shape> shapeQueue = new ConcurrentLinkedQueue<Shape>();
	private Context contextReference;
	
	private final int RADIUS_LENGTH = 100;
	private final int ROTATION_SPEED = 8;
	private final int DPI_PER_SECOND = 30;
	private final int MAX_SHAPES_DISPLAYED = 10;
	
	public AnimatedShapesView(Context context) {
		super(context);
		
		this.setOnTouchListener(touchHandler);
		
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		
		Shape.setScreenWidth(metrics.widthPixels);
		Shape.setScreenHeight(metrics.heightPixels);
	}
	
	private void initPath(){
		p = new Path();
	}
	
    @Override
    public void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	
    	paint.setARGB(240, 50, 208, 50);
    	
    	for(Shape s : shapeQueue){
    		drawShape(canvas, s);
    	}
    }
    
    private void drawShape(Canvas canvas, Shape s){
    	if(s.getShapeType() != ShapeType.CIRCLE){
    		s.rotate();
    	}
    	
    	s.move();
    	
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

    private final OnTouchListener touchHandler = new OnTouchListener(){ 
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			ShapeType st = ShapeType.getRandomShapeType();
			Point p = new Point((int)(event.getXPrecision() * event.getX()),  
								(int)(event.getYPrecision() * event.getY()));
			
			Shape s = new Shape(ROTATION_SPEED, 
								RADIUS_LENGTH,
								true,
								st,
								p);

			s.setPath(new LinearVector(DPI_PER_SECOND, 
									   Shape.getRandomInt(360), 
									   Shape.getScreenWidth(), 
									   Shape.getScreenHeight()));
			
	    	s.getPath().createShapeEndPoints(s);
			
			if(shapeQueue.size() >= MAX_SHAPES_DISPLAYED){
				shapeQueue.remove();
			}
			
			shapeQueue.add(s);
			
			return false;
		}
    };
}
