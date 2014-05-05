package de.mic.degraph.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class starts Degraph with the configfile.
 * 
 */
public class DegraphStarter {

	public void start(final DegraphMessage degraphMessage,
			final File pathToDegraph, final File configFile) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// Start degraph
				String degraphStartCommand = pathToDegraph.getAbsolutePath()
						+ " -f " + configFile.getAbsolutePath();
				System.out.println("Execute: " + degraphStartCommand);
				ProcessBuilder pb = new ProcessBuilder("CMD", "/C",
						degraphStartCommand);
				pb.directory(new File(File.separator));
				String message = "no Message";
				try {
					Process process = pb.start();

					message = getDegraphOutput(process);

				} catch (IOException e) {
					e.printStackTrace();
				}
				degraphMessage.setText(message);
			}
		};

		new Thread(runnable).start();
	}

	private String getDegraphOutput(Process process) throws IOException {
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		StringBuilder degraphOutput = new StringBuilder();
		int count = 0;
		while ((line = br.readLine()) != null) {
			degraphOutput.append(line);
			System.out.println(count++ + " : " + line);
		}
		// searching for degraph output
		// expecting something like 'Found 252 nodes, with 0 slice edges in
		// violation of dependency constraints.'
		System.out.println("Line: " + line);
		if (degraphOutput.length() != 0) {
			return degraphOutput.toString();
		} else {

			return "Degraph found nothing!";
		}
	}
}
