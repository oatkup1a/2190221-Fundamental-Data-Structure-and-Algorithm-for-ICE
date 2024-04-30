import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTreap {
	Treap t;
	@BeforeEach
	void setUp() throws Exception {
		t = new Treap();
	}
	
	@Test
	void testInsert01() {//1
		t.insert(4, 5);
		t.insert(2, 3);
		
		assertEquals(2, t.size);
		assertEquals(2, t.root.bstValue);
		assertEquals(4, t.root.right.bstValue);
	}

	@Test
	void testInsert02() {//1
		t.insert(4, 5);
		t.insert(8, 1);
		
		assertEquals(2, t.size);
		assertEquals(8, t.root.bstValue);
		assertEquals(4, t.root.left.bstValue);

	}
	
	@Test
	void testInsert03() {//2
		t.insert(4, 5);
		t.insert(8, 8);
		t.insert(7, 6);
		
		assertEquals(3, t.size);
		assertEquals(4, t.root.bstValue);
		assertEquals(7, t.root.right.bstValue);
		assertEquals(8, t.root.right.right.bstValue);
	}
	
	@Test
	void testInsert04() {//3
		t.insert(10, 50);
		t.insert(5, 70);
		t.insert(15, 60);
		t.insert(3, 30);
		
		assertEquals(4, t.size);
		assertEquals(3, t.root.bstValue);
		assertEquals(10, t.root.right.bstValue);
		assertEquals(15, t.root.right.right.bstValue);
		assertEquals(5, t.root.right.left.bstValue);
	}
	
	@Test
	void testInsert05() {//4
		t.insert(30, 50);
		t.insert(70, 75);
		t.insert(15, 60);
		t.insert(13, 120);
		t.insert(18, 110);
		t.insert(16, 180);
		t.insert(19, 30);
		assertEquals(7, t.size);
		
		assertEquals(19, t.root.bstValue);
		assertEquals(15, t.root.left.bstValue);
		assertEquals(30, t.root.right.bstValue);
		assertEquals(13, t.root.left.left.bstValue);
		assertEquals(18, t.root.left.right.bstValue);
		assertEquals(70, t.root.right.right.bstValue);
		assertEquals(16, t.root.left.right.left.bstValue);
	}
	

}
