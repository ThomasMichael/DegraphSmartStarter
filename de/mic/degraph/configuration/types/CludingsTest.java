package de.mic.degraph.configuration.types;

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
}
