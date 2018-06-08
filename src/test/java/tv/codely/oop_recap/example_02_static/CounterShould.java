package tv.codely.oop_recap.example_02_static;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class CounterShould {
	@Test
	void increase_the_total_value_at_class_level() {
		Counter counterA = new Counter();
		Counter counterB = new Counter();
		Counter counterC = new Counter();

		counterA.increaseTotal();
		counterA.increaseTotal();
		counterA.increaseTotal();

		counterB.increaseTotal();
		counterB.increaseTotal();

		counterC.increaseTotal();

        Integer expectedTotal = 6;

        assertEquals(expectedTotal, counterA.getTotal());
		assertEquals(expectedTotal, counterB.getTotal());
		assertEquals(expectedTotal, counterC.getTotal());
	}
}
