package Objects;

import java.util.List;

public class ShapeRing extends AbstractShape {
	private final int duration;
	private List<Shape> shapeList;
	
	public ShapeRing(final int _rotationSpeed, 
					 final int _radiusLength,
					 final boolean _clockwiseRotation, 
					 final ShapeType _shapeType) {
		
		super(_rotationSpeed, _radiusLength, _clockwiseRotation, _shapeType);
		
		if (_shapeType != ShapeType.CIRCLE)
			throw new IllegalArgumentException ("Invalid Object Type. Only CIRCLE allowed for Shape Ring.");
		
		this.duration = (int)Math.random() * 1000;
	}
	
	public ShapeRing(final int _rotationSpeed, 
					 final int _radiusLength,
					 final boolean _clockwiseRotation,
					 final ShapeType _shapeType,
					 final int _duration) {
		
		super(_rotationSpeed, _radiusLength, _clockwiseRotation, _shapeType);
		
		if (_shapeType != ShapeType.CIRCLE)
			throw new IllegalArgumentException ("Invalid Object Type. Only CIRCLE allowed for Shape Ring.");
		
		this.duration = _duration;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

}
