package de.mic.degraph.configuration.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GroupTest {

	@Test
	public void shouldStartWithgroupname() {

		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		assertTrue(group.toString().startsWith("part"));

	}

	@Test
	public void shouldContainEndCloseCurlyBracket() {

		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		assertTrue(group.toString().contains("}"));

	}

	@Test
	public void shouldHaveOpenCurlyBracketBracket() {

		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		assertTrue(group.toString().contains("{"));

	}

	@Test
	public void equalsToSignShouldHaveEmptySpaceBefore() {

		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		int indexOfEqualSign = group.toString().indexOf('=');
		assertEquals(
				" ",
				group.toString().substring(indexOfEqualSign - 1,
						indexOfEqualSign));

	}

	@Test
	public void equalsToSignShouldHaveEmptySpaceAfter() {

		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		int indexOfEqualSign = group.toString().indexOf('=');
		assertEquals(
				" ",
				group.toString().substring(indexOfEqualSign + 1,
						indexOfEqualSign + 2));

	}

	public void openCurlyIsBeforeCloseCurly() throws Exception {
		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		int openCurly = group.toString().indexOf('{');
		int closeCurly = group.toString().indexOf('}');
		assertTrue(openCurly < closeCurly);
	}

	@Test
	public void equalsToSignIsBeforeCurlys() {
		Group group = new Group("part", "de.schauderhaft.*.(*).**");
		int indexOfEqualSign = group.toString().indexOf('=');
		int openCurly = group.toString().indexOf('{');
		assertTrue(indexOfEqualSign < openCurly);
	}
}
