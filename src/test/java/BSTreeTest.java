import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BSTreeTest {

	BSTree tree = new BSTree();
	BSTree otherTree = new BSTree();
	BSTree neTree = new BSTree();
	BSTree eTree = new BSTree();
	BSTree t1 = new BSTree();
	BSTree t2 = new BSTree();
	BSTree t3 = new BSTree();
	BSTree t4 = new BSTree();
	
	@Test
	void isEmptyTest() {
		assertEquals(0, tree.getSize());
		tree.insert(1);
		assertFalse(tree.isEmpty());
	}
	
	@Test 
	void insertAndRetrieveTest()
	{
		tree.insert(5);
		assertEquals(5, tree.retrieve(5));
		tree.insert(32);
		assertEquals(32, tree.retrieve(32));
		assertEquals(null, tree.retrieve(21));
	}
	
	@Test
	void sizeTest() 
	{
		assertEquals(tree.getSize(),0);
		assertTrue(tree.isEmpty());
		tree.insert(6);
		tree.insert(7);
		assertEquals(tree.getSize(),2);
	}

	@Test
	void depthTest() 
	{
		assertEquals(0,tree.retrieveDepth(9));
		tree.insert(8);
		tree.insert(10);
		tree.insert(3);
		tree.insert(4);
		tree.insert(11);
		assertEquals(tree.retrieveDepth(8), 0);
		assertEquals(tree.retrieveDepth(10), 1);
		assertEquals(tree.retrieveDepth(3), 1);
		assertEquals(tree.retrieveDepth(4), 2);
		assertEquals(tree.retrieveDepth(11), 2);
		assertEquals(tree.retrieveDepth(12), 3);
		assertEquals(2,tree.retrieveDepth(2));
		
	}
	
	@Test
	void largestTest()
	{
		assertEquals(null, tree.largest());
		tree.insert(8);
		tree.insert(3);
		tree.insert(10);
		
		assertEquals(tree.largest(), 10);
		tree.insert(11);
		assertEquals(tree.largest(),11);
		
		tree.insert(12);
		tree.insert(100);
		tree.insert(16);
		tree.insert(2);
		tree.insert(7);
		tree.insert(55);
		tree.insert(31);
		assertEquals(tree.largest(),100);
		
	}
	
	@Test
	void toListTest() 
	{
		tree.insert(8);
		tree.insert(3);
		tree.insert(10);
		tree.insert(4);
		tree.insert(9);
		tree.insert(11);
		List<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(4);
		a.add(8);
		a.add(9);
		a.add(10);
		a.add(11);
		assertEquals(tree.toList(), a);
		t1.insert(3);
		t1.insert(4);
		t1.insert(5);
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(4);
		b.add(5);
		assertEquals(t1.toList(), b);
	}
	
	@Test
	void sumTest()
	{
		tree.insert(8);
		tree.insert(3);
		tree.insert(10);
		tree.insert(4);
		tree.insert(9);
		tree.insert(11);
		tree.insert(12);
		tree.insert(100);
		tree.insert(16);
		tree.insert(2);
		tree.insert(7);
		tree.insert(55);
		tree.insert(31);
		assertEquals(tree.sum(), 268);
		assertEquals(t1.sum(),0);
	}
	
	@Test
	void isEqualsTest() 
	{
		BSTree x = new BSTree();
		BSTree y = new BSTree();
		assertTrue(x.isEmpty());
		assertTrue(y.isEmpty());
		
		
		assertEquals(x.isEmpty(),y.isEmpty());
		assertTrue(x.myEquals(y));
		assertTrue(y.myEquals(x));
		
		assertTrue(tree.isEmpty());
		assertTrue(t1.isEmpty());
		assertTrue(t2.isEmpty());
		assertTrue(tree.myEquals(t1));
		assertTrue(tree.myEquals(t2));
		assertTrue(t1.myEquals(t2));
		
		
		tree.insert(8);
		assertFalse(tree.myEquals(t1));
		assertFalse(t1.myEquals(tree));
		assertFalse(tree.myEquals(t2));
		
		t1.insert(8);
		assertTrue(tree.myEquals(t1));
		assertFalse(tree.isEmpty());
		assertFalse(t1.isEmpty());
		assertFalse(t1.myEquals(t2));
		
		assertFalse(x.myEquals(t1));
		assertFalse(y.myEquals(tree));
		
		
		t2.insert(8);
		assertTrue(tree.myEquals(t2));
		assertTrue(t1.myEquals(t2));
		
		t1.insert(7);
		assertFalse(t1.myEquals(tree));
		assertFalse(t1.myEquals(t2));
		
		tree.insert(7);
		assertTrue(tree.myEquals(t1));
		
		t2.insert(1);
		assertFalse(t2.myEquals(tree));
		assertFalse(t2.myEquals(t1));
		
		tree.insert(1);
		assertFalse(tree.myEquals(t2));
		assertFalse(tree.myEquals(t1));
		
		t2.insert(6);
		assertFalse(tree.myEquals(t2));
		assertFalse(t1.myEquals(t2));
		
		t3.insert(8);
		t3.insert(7);
		t3.insert(1);
		assertTrue(tree.myEquals(t3));
		t1.insert(1);
		assertTrue(tree.myEquals(t1));
		assertFalse(t1.myEquals(t2));
		assertFalse(t3.myEquals(t2));
		
		tree.insert(11);
		t2.insert(11);
		assertFalse(tree.myEquals(t2));
		assertFalse(tree.myEquals(t1));
		t1.insert(11);
		assertTrue(tree.myEquals(t1));
		assertFalse(t1.myEquals(t2));
		
		t1.insert(10);
		t2.insert(10);
		assertFalse(t1.myEquals(t2));
		assertFalse(t1.myEquals(tree));
		tree.insert(10);
		assertTrue(tree.myEquals(t1));
		assertFalse(tree.myEquals(t2));
		
		tree.insert(45);
		tree.insert(33);
		
		assertFalse(t1.myEquals(tree));
		assertFalse(tree.myEquals(t1));
		assertFalse(tree.myEquals(t2));
		
		t1.insert(45);
		t1.insert(33);
		assertTrue(t1.myEquals(tree));
		assertTrue(tree.myEquals(t1));
		assertFalse(t1.myEquals(t2));
		t2.insert(89);
		t2.insert(99);
		t1.insert(99);
		assertFalse(t1.myEquals(tree));
		assertFalse(t1.myEquals(t2));
		tree.insert(99);
		assertTrue(tree.myEquals(t1));
		assertFalse(tree.myEquals(t2));
		t2.insert(50);
		assertFalse(t2.myEquals(tree));
		assertFalse(t2.myEquals(t1));
		
		t1.insert(88);
		tree.insert(88);
		t2.insert(23);
		assertTrue(tree.myEquals(t1));
		assertFalse(t1.myEquals(t2));
		assertFalse(tree.myEquals(t2));
		
		tree.insert(38);
		t2.insert(38);
		t1.insert(38);
		assertTrue(tree.myEquals(t1));
		assertFalse(t1.myEquals(t2));
		assertFalse(tree.myEquals(t2));
		
		t1.insert(34);
		tree.insert(34);
		t2.insert(123);
		assertTrue(tree.myEquals(t1));
		assertFalse(t1.myEquals(t2));
		assertFalse(tree.myEquals(t2));

		
		t2.insert(2);
		assertFalse(t1.myEquals(t2));
		assertFalse(tree.myEquals(t2));
		assertEquals(t1.getSize(),tree.getSize());
		assertEquals(tree.largest(), t1.largest());
		assertEquals(tree.sum(), t1.sum());
		assertNotEquals(tree.getSize(),t2.getSize());
		assertNotEquals(tree.sum(),t2.sum());
		assertNotEquals(tree.largest(),t2.largest());
		t1.insert(22);
		tree.insert(37);
		assertFalse(tree.myEquals(t1));
		assertFalse(t1.myEquals(tree));
		t1.insert(135);
		assertNotEquals(tree.getSize(),t1.getSize());
		assertNotEquals(tree.largest(), t1.largest());
		assertNotEquals(tree.sum(),t1.sum());
		assertFalse(tree.myEquals(t2));
		BSTree a = new BSTree();
		BSTree b = new BSTree();
		assertTrue(a.myEquals(b));
		assertFalse(b.myEquals(t1));
		
		t4.insert(8);
		t4.insert(7);
		t4.insert(1);
		t4.insert(11);
		t4.insert(10);
		t4.insert(45);
		t4.insert(33);
		t4.insert(99);
		t4.insert(88);
		t4.insert(38);
		t4.insert(34);
		t4.insert(37);
		assertTrue(tree.myEquals(t4));
		
		
	}
}
