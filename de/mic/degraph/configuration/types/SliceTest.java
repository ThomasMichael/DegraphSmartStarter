package de.mic.degraph.configuration.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SliceTest {

	@Test
	public void shouldStartWithSlicename() {

		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		assertTrue(slice.toString().startsWith("part"));

	}

	@Test
	public void shouldContainEndCloseCurlyBracket() {

		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		assertTrue(slice.toString().contains("}"));

	}

	@Test
	public void shouldHaveOpenCurlyBracketBracket() {

		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		assertTrue(slice.toString().contains("{"));

	}

	@Test
	public void equalsToSignShouldHaveEmptySpaceBefore() {

		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		int indexOfEqualSign = slice.toString().indexOf('=');
		assertEquals(
				" ",
				slice.toString().substring(indexOfEqualSign - 1,
						indexOfEqualSign));

	}

	@Test
	public void equalsToSignShouldHaveEmptySpaceAfter() {

		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		int indexOfEqualSign = slice.toString().indexOf('=');
		assertEquals(
				" ",
				slice.toString().substring(indexOfEqualSign + 1,
						indexOfEqualSign + 2));

	}

	public void openCurlyIsBeforeCloseCurly() throws Exception {
		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		int openCurly = slice.toString().indexOf('{');
		int closeCurly = slice.toString().indexOf('}');
		assertTrue(openCurly < closeCurly);
	}

	@Test
	public void equalsToSignIsBeforeCurlys() {
		Slice slice = new Slice("part", "de.schauderhaft.*.(*).**");
		int indexOfEqualSign = slice.toString().indexOf('=');
		int openCurly = slice.toString().indexOf('{');
		assertTrue(indexOfEqualSign < openCurly);
	}
}
