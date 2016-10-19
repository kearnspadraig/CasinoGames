package TestingSuite;

import Files.Outcome;
import org.junit.Test;

import static org.junit.Assert.*;



public class OutcomeTest {

	private Outcome o1 = new Outcome("even", 2);
    private Outcome o2 = new Outcome("Any Craps", 8);
    private Outcome o3 = new Outcome("even",2);

	@Test 
	public void type() throws Exception {
		assertNotNull(Outcome.class);
	}

	@Test 
	public void instantiation() throws Exception {
		String n = "test";
		int o = 0;
		Outcome target = new Outcome(n, o);
		assertNotNull(target);
	}

	@Test
    public void testEqualityPass() throws Exception{
        assertTrue(o1 == o3);
        assertTrue(o1.equals(o3));
		assertFalse(o1.equals(o2));
	}

	@Test 
	public void winAmount_A$int() throws Exception {
		String n = "Test";
		int o = 0;
		Outcome target = new Outcome(n, o);
		int amount = 0;
		int actual = target.winAmount(amount);
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test 
	public void equals_A$Object() throws Exception {
		String n = "test";
		int o = 0;
		Outcome target = new Outcome(n, o);
		Object other = new Outcome("one",28);
		boolean actual = target.equals(other);
		assertEquals(false, actual);
	}

	@Test 
	public void toString_A$() throws Exception {
		String n = "odd";
		int o = 0;
		Outcome target = new Outcome(n, o);
		String actual = target.toString();
		String expected = "odd (0:1)";
		assertEquals(expected, actual);
	}

}
