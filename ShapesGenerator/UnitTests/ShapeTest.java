import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class ShapeTest {
    @Parameters
    public static Collection<Object[]> constructorParams() {
        return Arrays.asList(new Object[][] { { 3, 1, 2 }, { 5, 2, 3 }, { 7, 3, 4 }, { 9, 4, 5 }, });
    }

	@Test
	public void testRotate() {
		fail("Not yet implemented");
	}

	@Test
	public void testShapeIntIntBooleanShapeType() {
		fail("Not yet implemented");
	}

	@Test
	public void testShapeIntIntBooleanShapeTypePoint() {
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
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbstractShape() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRotationSpeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRadiusLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsRotating() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShapeType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRotationSpeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRadiusLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRotation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetShapeType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRotation() {
		fail("Not yet implemented");
	}

}
