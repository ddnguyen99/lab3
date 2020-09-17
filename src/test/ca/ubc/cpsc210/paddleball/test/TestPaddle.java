package ca.ubc.cpsc210.paddleball.test;

import ca.ubc.cpsc210.paddleball.model.PBG;
import ca.ubc.cpsc210.paddleball.model.Puddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Paddle class.
 */
class TestPaddle {
	private static final int XLOC = PBG.DIMENSION1 / 2;
	private Puddle p;
	
	@BeforeEach
	void runBefore() {
		p = new Puddle(XLOC);
	}
	
	@Test
	void testGetX() {
		assertEquals(XLOC, p.getX());
	}
	
	@Test
	void testUpdate() {
		final int NUM_UPDATES = 8;
		
		p.Move();
		assertEquals(XLOC + Puddle.DX, p.getX());
		
		for(int count = 1; count < NUM_UPDATES; count++) {
			p.Move();
		}
		
		assertEquals(XLOC + NUM_UPDATES * Puddle.DX, p.getX());
	}
	
	@Test
	void testFlipDirection() {
		p.Move();
		assertEquals(XLOC + Puddle.DX, p.getX());
		p.L();
		p.Move();
		assertEquals(XLOC, p.getX());
		p.R();
		p.Move();
		assertEquals(XLOC + Puddle.DX, p.getX());
	}
	
	@Test 
	void testLeftBoundary() {
		p.L();
		for(int count = 0; count < (PBG.DIMENSION1 / 2 - Puddle.DIMENSION1 / 2) / Puddle.DX + 1; count++)
			p.Move();
		assertEquals(Puddle.DIMENSION1 / 2, p.getX());
		p.Move();
		assertEquals(Puddle.DIMENSION1 / 2, p.getX());
	}
	
	@Test
	void testRightBoundary() {
		p.R();
		for(int count = 0; count < (PBG.DIMENSION1 / 2 - Puddle.DIMENSION1 / 2) / Puddle.DX + 1; count++)
			p.Move();
		assertEquals(PBG.DIMENSION1 - Puddle.DIMENSION1 / 2, p.getX());
		p.Move();
		assertEquals(PBG.DIMENSION1 - Puddle.DIMENSION1 / 2, p.getX());
	}
}
