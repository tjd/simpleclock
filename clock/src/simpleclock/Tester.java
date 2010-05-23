package simpleclock;

import java.util.Arrays;
import java.util.Random;

// Some helper functions for testing and timing code. 

public class Tester {

	//
	// Assertions.
	//

	// This functions does nothing if b is true, but fails with an
	// AssertionError if b is false. It is quite handy for testing.
	public void assertTrue(boolean b, String msg) {
		if (!b) {
			throw new AssertionError(msg);
		}
	}

	// This functions does nothing if b is false, but fails with an
	// AssertionError if b is true. It is quite handy for testing.
	public void assertFalse(boolean b, String msg) {
		if (b) {
			throw new AssertionError(msg);
		}
	}

	// This functions does nothing if b is true, but fails with an
	// AssertionError if b is false. It is quite handy for testing.
	public void assertTrue(boolean b) {
		if (!b) {
			throw new AssertionError("");
		}
	}

	// This functions does nothing if b is false, but fails with an
	// AssertionError if b is true. It is quite handy for testing.
	public void assertFalse(boolean b) {
		if (b) {
			throw new AssertionError("");
		}
	}

	public void assertEqual(int x, int y, String msg) {
		assertTrue(x == y, msg);
	}

	public void assertEqual(int x, int y) {
		assertEqual(x, y, "");
	}

	public void assertNotNull(Object x) {
		assertFalse(x == null);
	}

	public void assertNull(Object x) {
		assertTrue(x == null);
	}

	// fail on purpose
	public void error(String msg) {
		throw new RuntimeException(msg);
	}

	// 
	// Get the current time in milliseconds.
	//
	public long nowMillis() {
		return System.currentTimeMillis();
	}

	//
	// Simplified int, string, and array printing.
	//

	public void println() {
		System.out.println();
	}

	public void print(int n) {
		System.out.print(n);
	}

	public void println(int n) {
		System.out.println(n);
	}

	public void print(String s) {
		System.out.print(s);
	}

	public void println(String s) {
		System.out.println(s);
	}

	public void print(int[] arr) {
		print(Arrays.toString(arr));
	}

	public void println(int[] arr) {
		println(Arrays.toString(arr));
	}

	//
	// Code for creating random arrays.
	//
	public static Random rnd = new Random();

	// Return a random number in the range [lo, hi]
	public int rand(int lo, int hi) {
		return lo + rnd.nextInt(hi - lo + 1);
	}

	// Return an array of n ints each in the range [lo, hi].
	public int[] randArray(int n, int lo, int hi) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = rand(lo, hi);
		}
		return arr;
	}

	// Return an array of n elements each in the range 0 to 9999.
	public int[] randArray(int n) {
		return randArray(n, 0, 9999);
	}

	// Returns a new array {0, 1, 2, ..., n-1}
	public int[] range(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = i;
		}
		return arr;
	}

	// Randomly shuffle the elements of an array.
	// Based on the Java example from
	// http://en.wikipedia.org/wiki/Fisher–Yates_shuffle
	public void shuffle(int[] arr) {
		// n is the number of items remaining to be shuffled.
		for (int n = arr.length; n > 1; n--) {
			// Pick a random element to swap with the nth element.
			int k = rnd.nextInt(n); // 0 <= k <= n-1
			// swap arr[k], arr[n-1]
			int temp = arr[k];
			arr[k] = arr[n - 1];
			arr[n - 1] = temp;
		}
	}

	// Return a new array contain the ints 0, ..., n-1 in random order.
	public int[] shuffledArray(int n) {
		int[] arr = range(n);
		shuffle(arr);
		return arr;
	}

	// Returns the current working directory.
	public String cwd() {
		return System.getProperty("user.dir");
	}

	// Returns a String consisting of the character ch repeated n times
	public String fill(int n, char ch) {
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; ++i) {
			sb.append(ch);
		}
		return sb.toString();
	}

	// Returns a of n spaces
	public String spaces(int n) {
		return fill(n, ' ');
	}

	// Returns a new array {arr[begin], arr[begin+1], ..., arr[end-1]}
	public int[] slice(int[] arr, int begin, int end) {
		int n = end - begin;
		int[] result = new int[n];
		for (int i = begin; i < end; ++i) {
			result[i - begin] = arr[i];
		}
		return result;
	}

	// Returns a copy of arr.
	public int[] slice(int[] arr) {
		return slice(arr, 0, arr.length);
	}

	// Returns a copy of arr.
	public int[] copy(int[] arr) {
		return slice(arr, 0, arr.length);
	}

	// Returns a copy of arr with the first element removed.
	// Note that it's inefficient to use rest in, say, recursive
	// algorithms that use it to traverse each element of an array.
	public int[] rest(int[] arr) {
		return slice(arr, 1, arr.length);
	}
}
