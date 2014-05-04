package de.mic.degraph.configuration.types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CludingsTest {

	@Test
	public void opticalTest() {
		Excluding java = new Excluding("java.*");
		Excluding javax = new Excluding("javax.*");
		Including mic = new Including("de.mic.*");
		Cludings cludings = new Cludings();
		cludings.addCluding(java);
		cludings.addCluding(javax);
		cludings.addCluding(mic);

		System.out.println(cludings.toString());

	}

	@Test
	public void shouldGetOneExlude() throws Exception {
		Cludings cludings = new Cludings();
		cludings.addCluding(new Excluding("java.*"));
		cludings.addCluding(new Including("de.schauderhaft.*"));
		cludings.addCluding(new Including("de.mic.*"));

		assertEquals(1, cludings.getCluding(Excluding.class).size());

	}

	@Test
	public void shouldGetTwoInclude() throws Exception {
		Cludings cludings = getTestdata();

		assertEquals(2, cludings.getCluding(Including.class).size());

	}

	private Cludings getTestdata() {
		Cludings cludings = new Cludings();
		cludings.addCluding(new Excluding("java.*"));
		cludings.addCluding(new Including("de.schauderhaft.*"));
		cludings.addCluding(new Including("de.mic.*"));
		return cludings;
	}
}
