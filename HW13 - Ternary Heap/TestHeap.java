import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHeap {
	TernaryHeap h;

	@BeforeEach
	void setUp() throws Exception {
		h = new TernaryHeap();
	}

	@Test
	void testAdd01() { //1
		h.add(5);
		h.add(9);
		h.add(8);
		h.add(6);
		h.add(4);

		assertEquals(5, h.size);
		assertEquals(4, h.mData[0]);
		assertEquals(5, h.mData[1]);
		assertEquals(8, h.mData[2]);
		assertEquals(6, h.mData[3]);
		assertEquals(9, h.mData[4]);

	}

	@Test
	void testAdd2() { //1
		h.mData[0] = 4;
		h.mData[1] = 5;
		h.mData[2] = 8;
		h.mData[3] = 6;
		h.mData[4] = 9;
		h.mData[5] = 10;
		h.mData[6] = 15;
		h.mData[7] = 20;
		h.size = 8;

		h.add(7);
		assertEquals(9, h.size);
		assertEquals(4, h.mData[0]);
		assertEquals(5, h.mData[1]);
		assertEquals(7, h.mData[2]);
		assertEquals(6, h.mData[3]);
		assertEquals(9, h.mData[4]);
		assertEquals(10, h.mData[5]);
		assertEquals(15, h.mData[6]);
		assertEquals(20, h.mData[7]);
		assertEquals(8, h.mData[8]);
	}

	@Test
	void testAdd3() { //1
		h.mData[0] = 4;
		h.mData[1] = 5;
		h.mData[2] = 7;
		h.mData[3] = 6;
		h.mData[4] = 9;
		h.mData[5] = 10;
		h.mData[6] = 15;
		h.mData[7] = 20;
		h.mData[8] = 8;
		h.mData[9] = 13;
		h.mData[10] = 12;
		h.mData[11] = 18;
		h.size = 12;
		
		h.add(3);
		assertEquals(13, h.size);
		assertEquals(3, h.mData[0]);
		assertEquals(5, h.mData[1]);
		assertEquals(7, h.mData[2]);
		assertEquals(4, h.mData[3]);
		assertEquals(9, h.mData[4]);
		
		assertEquals(10, h.mData[5]);
		assertEquals(15, h.mData[6]);
		assertEquals(20, h.mData[7]);
		assertEquals(8, h.mData[8]);
		assertEquals(13, h.mData[9]);
		
		assertEquals(12, h.mData[10]);
		assertEquals(18, h.mData[11]);
		assertEquals(6, h.mData[12]);

	}

	@Test
	void testPop01() throws Exception { //2
		h.mData[0] = 3;
		h.mData[1] = 5;
		h.mData[2] = 7;
		h.mData[3] = 4;
		h.mData[4] = 9;
		h.mData[5] = 10;
		h.mData[6] = 15;
		h.mData[7] = 20;
		h.mData[8] = 8;
		h.mData[9] = 13;
		h.mData[10] = 18;
		h.mData[11] = 12;
		h.mData[12] = 25;
		h.size = 13;
		
		h.pop();
		
		assertEquals(12, h.size);
		assertEquals(4, h.mData[0]);
		assertEquals(5, h.mData[1]);
		assertEquals(7, h.mData[2]);
		assertEquals(12, h.mData[3]);
		assertEquals(9, h.mData[4]);
		assertEquals(10, h.mData[5]);
		assertEquals(15, h.mData[6]);
		assertEquals(20, h.mData[7]);
		assertEquals(8, h.mData[8]);
		assertEquals(13, h.mData[9]);
		assertEquals(18, h.mData[10]);
		assertEquals(25, h.mData[11]);

	}
	
	@Test
	void testPop02() throws Exception { //2
		h.mData[0] = 4;
		h.mData[1] = 5;
		h.mData[2] = 7;
		h.mData[3] = 6;
		h.mData[4] = 10;
		h.mData[5] = 9;
		h.mData[6] = 15;
		h.mData[7] = 20;
		h.mData[8] = 8;
		h.mData[9] = 13;
		h.mData[10] = 12;
		h.mData[11] = 18;
		h.size = 12;
		
		h.pop();
		
		assertEquals(11, h.size);
		assertEquals(5, h.mData[0]);
		assertEquals(9, h.mData[1]);
		assertEquals(7, h.mData[2]);
		assertEquals(6, h.mData[3]);
		assertEquals(10, h.mData[4]);
		assertEquals(18, h.mData[5]);
		assertEquals(15, h.mData[6]);
		assertEquals(20, h.mData[7]);
		assertEquals(8, h.mData[8]);
		assertEquals(13, h.mData[9]);
		assertEquals(12, h.mData[10]);


	}
	
	@Test
	void testPop03() throws Exception { //2
		h.mData[0] = 5;
		h.mData[1] = 9;
		h.mData[2] = 6;
		h.mData[3] = 7;
		h.mData[4] = 10;
		h.mData[5] = 18;
		h.mData[6] = 15;
		h.mData[7] = 20;
		h.mData[8] = 13;
		h.mData[9] = 8;
		h.mData[10] = 12;
		h.size = 11;
		
		h.pop();
		
		assertEquals(10, h.size);
		assertEquals(6, h.mData[0]);
		assertEquals(9, h.mData[1]);
		assertEquals(8, h.mData[2]);
		assertEquals(7, h.mData[3]);
		assertEquals(10, h.mData[4]);
		assertEquals(18, h.mData[5]);
		assertEquals(15, h.mData[6]);
		assertEquals(20, h.mData[7]);
		assertEquals(13, h.mData[8]);
		assertEquals(12, h.mData[9]);
		
	}
	
	@Test
	void testPop04() throws Exception { //2 
		h.mData[0] = 3;
		h.mData[1] = 5;
		h.mData[2] = 7;
		h.mData[3] = 4;
		h.mData[4] = 9;
		h.mData[5] = 10;
		h.mData[6] = 15;
		h.mData[7] = 20;
		h.mData[8] = 8;
		h.mData[9] = 13;
		h.mData[10] = 12;
		h.mData[11] = 18;
		h.mData[12] = 25;
		h.size = 13;
		
		h.pop();
		
		assertEquals(12, h.size);
		assertEquals(4, h.mData[0]);
		assertEquals(5, h.mData[1]);
		assertEquals(7, h.mData[2]);
		assertEquals(12, h.mData[3]);
		assertEquals(9, h.mData[4]);
		assertEquals(10, h.mData[5]);
		assertEquals(15, h.mData[6]);
		assertEquals(20, h.mData[7]);
		assertEquals(8, h.mData[8]);
		assertEquals(13, h.mData[9]);
		assertEquals(25, h.mData[10]);
		assertEquals(18, h.mData[11]);

	}


}
