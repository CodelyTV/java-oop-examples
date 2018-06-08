package tv.codely.oop_recap.example_01_visibility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

final class ChildShould {
	@Test
	void only_override_the_behaviour_of_the_public_and_protected_methods() {
		Child child = new Child();

		String expectedPrivateResult = "Parent#privateMethod";
		String expectedProtectedResult = "Child#protectedMethod";
		String expectedPublicResult = "Child#publicMethod";

		String expectedFullResult = expectedPrivateResult + " " + expectedProtectedResult + " " + expectedPublicResult;

		assertEquals(expectedFullResult, child.visibilityTest());
	}
}
