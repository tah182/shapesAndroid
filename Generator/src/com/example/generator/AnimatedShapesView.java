package com.example.generator;

import java.util.ArrayList;

import Objects.LinearVector;
import Objects.Shape;
import Objects.ShapeType;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class AnimatedShapesView extends View {
	private Paint paint = new Paint();
	
	public AnimatedShapesView(Context context) {
		super(context);
		
	}

    @Override
    public void onDraw(Canvas canvas) {
    	paint.setColor(Color.BLUE);
    	
    	Shape s = new Shape(30, 50, true, ShapeType.HEXAGON, new Point(1000, 1000));
    	
    	s.setPath(new LinearVector(10, 45));
    	s.getPath().createShapeEndPoints(s);
    	
    	Path p = new Path();
    	
    	ArrayList<Point> points = s.getEndPoints();
    	
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
