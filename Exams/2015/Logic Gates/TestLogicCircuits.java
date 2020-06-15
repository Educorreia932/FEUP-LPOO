import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

/*
 * A combinatorial circuit comprises a set of logic gates (such as AND, OR and NOT gates) 
 * that 'compute' output variables as a function of input variables.
 * we also use internal variables.
 */

public class TestLogicCircuits {
	// Auxiliary method used by some test methods (no need to understand the code!).
	private void fieldsArePrivateOrProtected(Class<?> ... classes) {
		for (Class<?> c: classes)
			for (Field f : c.getDeclaredFields())
				assertTrue(Modifier.isPrivate(f.getModifiers()) 
						|| Modifier.isProtected(f.getModifiers()));
	}
	
	// Auxiliary method used by some test methods (no need to understand the code!).	
	private void classIsAbstract(Class<?> c) {
		assertTrue(Modifier.isAbstract(c.getModifiers()));
	}
		
	@Test
	public void testLogicVariable() {
		LogicVariable x1 = new LogicVariable("x1", false);
		assertEquals("x1", x1.getName());
		assertEquals(false, x1.getValue());
		x1.setValue(true);
		assertEquals(true, x1.getValue());
		fieldsArePrivateOrProtected(LogicVariable.class);	
	}
	
	@Test
	public void testEquals() {
		LogicVariable a = new LogicVariable("y1"); 
		LogicVariable b = new LogicVariable("y1");
		assertTrue(a.equals(b)); // same name
		assertTrue(a.equals((Object)b));		
	}	

	@Test
	public void testLogicGates() throws Exception {
		LogicVariable x1 = new LogicVariable("x1", false); // input variable
		LogicVariable x2 = new LogicVariable("x2", false); // input variable
		LogicVariable x3 = new LogicVariable("x3", false); // input variable
		LogicVariable w1 = new LogicVariable("w1"); // 'internal' variable
		LogicVariable w2 = new LogicVariable("w2"); // 'internal' variable
		LogicVariable y1 = new LogicVariable("y1"); // output variable
		
		LogicGate p1 = new GateAnd(w1, x1, x2);
		assertSame(w1, p1.getOutput());
		assertTrue(Arrays.equals(new LogicVariable[]{x1, x2}, p1.getInputs()));
		
		LogicGate p2 = new GateOr(w2, w1, x3);
		assertSame(w2, p2.getOutput());
		assertTrue(Arrays.equals(new LogicVariable[]{w1, x3}, p2.getInputs()));
		
		LogicGate p3 = new GateNot(y1, w2);
		assertSame(y1, p3.getOutput());
		assertTrue(Arrays.equals(new LogicVariable[]{w2}, p3.getInputs()));	
		
		fieldsArePrivateOrProtected(LogicGate.class, GateAnd.class, GateOr.class, GateNot.class);
		classIsAbstract(LogicGate.class);
	}

	@Test
	public void testSymbols() throws Exception {
		LogicVariable x1 = new LogicVariable("x1", false);
		LogicVariable x2 = new LogicVariable("x2", false);
		LogicVariable x3 = new LogicVariable("x3", false);
		LogicVariable w1 = new LogicVariable("w1");
		LogicVariable w2 = new LogicVariable("w2");
		LogicVariable y1 = new LogicVariable("y1");
		
		LogicGate p1 = new GateAnd(w1, x1, x2);
		assertEquals("AND", p1.getSymbol());
		
		LogicGate p2 = new GateOr(w2, w1, x3);
		assertEquals("OR", p2.getSymbol());
		
		LogicGate p3 = new GateNot(y1, w2);
		assertEquals("NOT", p3.getSymbol());
		
		fieldsArePrivateOrProtected(LogicGate.class, GateAnd.class, GateOr.class, GateNot.class);
		classIsAbstract(LogicGate.class);
	}

	@Test
	public void testCalculatedBy() throws Exception {
		LogicVariable x1 = new LogicVariable("x1", false);
		LogicVariable x2 = new LogicVariable("x2", false);
		LogicVariable y1 = new LogicVariable("y1");

		LogicGate p1 = new GateAnd(y1, x1, x2);

		assertSame(p1, y1.getCalculatedBy());
		assertSame(null, x1.getCalculatedBy());
		assertSame(null, x2.getCalculatedBy());
	}

	// A variable cannot be calculated by multiple gates
	@Test(expected = ColisionException.class)
	public void testColision() throws Exception {
		LogicVariable x1 = new LogicVariable("x1", false);
		LogicVariable x2 = new LogicVariable("x2", false);
		LogicVariable x3 = new LogicVariable("x3", false);
		LogicVariable x4 = new LogicVariable("x4", false);
		LogicVariable y1 = new LogicVariable("y1");

		LogicGate p1 = new GateAnd(y1, x1, x2);
		LogicGate p2 = new GateOr(y1, x3, x4);
	}
		
	@Test
	public void testFormulas() throws Exception {
		LogicVariable x1 = new LogicVariable("x1", false);
		LogicVariable x2 = new LogicVariable("x2", false);
		LogicVariable x3 = new LogicVariable("x3", false);
		LogicVariable w1 = new LogicVariable("w1");
		LogicVariable w2 = new LogicVariable("w2");
		LogicVariable y1 = new LogicVariable("y1");
		
		LogicGate p1 = new GateAnd(w1, x1, x2);
		LogicGate p2 = new GateOr(w2, w1, x3);
		LogicGate p3 = new GateNot(y1, w2);
		
		assertEquals("x1", x1.getFormula());
		assertEquals("NOT(OR(AND(x1,x2),x3))", y1.getFormula());
		assertEquals("NOT(OR(AND(x1,x2),x3))", p3.getFormula());
	}

	@Test
	public void testValues() throws Exception {
		LogicVariable x1 = new LogicVariable("x1", false);
		LogicVariable x2 = new LogicVariable("x2", true);
		LogicVariable x3 = new LogicVariable("x3", true);
		LogicVariable w1 = new LogicVariable("w1");
		LogicVariable w2 = new LogicVariable("w2");
		LogicVariable y1 = new LogicVariable("y1");
		
		LogicGate p1 = new GateAnd(w1, x1, x2);
		LogicGate p2 = new GateOr(w2, w1, x3);
		LogicGate p3 = new GateNot(y1, w2);
		
		assertEquals(false, x1.getValue());
		assertEquals(true, x2.getValue());
		assertEquals(true, x3.getValue());
		assertEquals(false, w1.getValue());
		assertEquals(true, w2.getValue());
		assertEquals(false, y1.getValue());
		
		x3.setValue(false);
		assertEquals(true, y1.getValue());
	}
	
	// Circular dependencies are not allowed
	@Test(expected = CycleException.class)
	public void testCycles() throws Exception {
		LogicVariable w1 = new LogicVariable("w1");
		LogicVariable w2 = new LogicVariable("w2");
		LogicVariable w3 = new LogicVariable("w3");
		
		LogicGate p1 = new GateAnd(w3, w2, w1);
		LogicGate p2 = new GateNot(w2, w3);		
	}

	@Test
	public void testCombinatorialCircuit() {
		CombinatorialCircuit c = new CombinatorialCircuit();
		LogicVariable a = new LogicVariable("x1");
		LogicVariable b = new LogicVariable("x1");
		assertEquals(true, c.addVariable(a));
		assertEquals(false, c.addVariable(b)); // duplicate names are not allowed
		assertSame(a, c.getVariableByName("x1"));
		assertSame(null, c.getVariableByName("x2"));
	}
}