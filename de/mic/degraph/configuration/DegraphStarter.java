package de.mic.degraph.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DegraphStarter {

	public void start(File pathToDegraph, File configFile) {

		// Start degraph
		String degraphStartCommand = pathToDegraph.getAbsolutePath() + " -f "
				+ configFile.getAbsolutePath();
		System.out.println("Execute: " + degraphStartCommand);
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", degraphStartCommand);
		pb.directory(new File(File.separator));
		// pb.redirectOutput(new File(File.separator + "tmp.log"));
		try {
			// Runtime.getRuntime().exec(degraphStartCommand);
			Process process = pb.start();

			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fertig!");
	}
}
