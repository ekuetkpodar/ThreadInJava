package Thread.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.elevator;

public class PrintMethod {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void testInvalidElement() {
		elevator element = new elevator();
		ArrayList<Integer> number = null;

		this.expected.expect(IllegalArgumentException.class);
		element.printArrayList(number);

	}

	@Test
	public void testIsValid() {
		elevator element = new elevator();
		ArrayList<Integer> number = new ArrayList<Integer>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);

		assertEquals(element.printArrayList(number), true);

	}

}
