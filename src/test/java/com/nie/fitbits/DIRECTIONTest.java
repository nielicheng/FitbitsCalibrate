package com.nie.fitbits;

import static org.junit.Assert.*;

import org.junit.Test;

public class DIRECTIONTest {

	@Test
	public void testGetLeft() {
		assertEquals(DIRECTION.N, DIRECTION.E.getLeft());
		assertEquals(DIRECTION.W, DIRECTION.N.getLeft());
		assertEquals(DIRECTION.S, DIRECTION.W.getLeft());
		assertEquals(DIRECTION.E, DIRECTION.S.getLeft());
	}

	@Test
	public void testGetRight() {
		assertEquals(DIRECTION.S, DIRECTION.E.getRight());
		assertEquals(DIRECTION.E, DIRECTION.N.getRight());
		assertEquals(DIRECTION.N, DIRECTION.W.getRight());
		assertEquals(DIRECTION.W, DIRECTION.S.getRight());
	}

}
