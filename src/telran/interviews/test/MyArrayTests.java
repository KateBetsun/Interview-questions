package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyArray;

class MyArrayTests {
	MyArray<Integer> myArray;
	int size = 5;

	@BeforeEach
	void setUp() {
		myArray = new MyArray<>(size);
		myArray.setAll(100);
	}

	@Test
	void testSetAll() {
		for (int i = 0; i < size; i++) {
			assertEquals(100, myArray.get(i));
		}
	}

	@Test
	void testSet() {
		myArray.set(1, 200);
		assertEquals(200, myArray.get(1));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(6));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(-5));
	}

	@Test
	void testGet() {
		assertEquals(100, myArray.get(3));
		myArray.set(4, 555);
		assertEquals(555, myArray.get(4));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(6));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(-1));
	}

}
