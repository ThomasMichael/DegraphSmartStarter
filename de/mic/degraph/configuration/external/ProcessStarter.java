package de.mic.degraph.configuration.external;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessStarter {

	public void startProcess(final String command) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				System.out.println("Execute: " + command);
				ProcessBuilder pb = new ProcessBuilder("CMD", "/C", command);
				pb.directory(new File(File.separator));
				try {
					Process process = pb.start();

					String message = getProcessOutput(process);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	public void start(String command) {
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", command);
		pb.directory(new File(File.separator));
		try {
			Process process = pb.start();

			String message = getProcessOutput(process);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getProcessOutput(Process process) throws IOException {
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		StringBuilder output = new StringBuilder();
		int count = 0;
		while ((line = br.readLine()) != null) {
			output.append(line);
			System.out.println(count++ + " : " + line);
		}
		// searching for degraph output
		// expecting something like 'Found 252 nodes, with 0 slice edges in
		// violation of dependency constraints.'
		System.out.println("Line: " + line);
		if (output.length() != 0) {
			return output.toString();
		} else {

			return "Found nothing!";
		}
	}
}
