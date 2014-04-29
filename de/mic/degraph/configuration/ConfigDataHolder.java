package de.mic.degraph.configuration;

import java.io.File;

import de.mic.degraph.configuration.types.ClassPathes;
import de.mic.degraph.configuration.types.Slice;
import de.mic.degraph.configuration.types.Slices;
import de.mic.degraph.configuration.types.YedOutput;

/**
 * This class represents the whole date for degraph configuration.
 * 
 * 
 */
public class ConfigDataHolder {

	private YedOutput output;
	private final ClassPathes classpaths = new ClassPathes();
	private final Slices slices = new Slices();

	public ConfigDataHolder() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(output.toString());
		sb.append(classpaths.toString());
		sb.append(slices.toString());
		return sb.toString();
	}

	public YedOutput getOutput() {
		return output;
	}

	public void setOutput(YedOutput output) {
		this.output = output;
	}

	/**
	 * Adds a Slice.
	 * 
	 * @param slice
	 */
	public void addGroup(Slice slice) {
		this.slices.addSlice(slice);

	}

	/**
	 * Adds a classpath.
	 * 
	 * @param classPath
	 */
	public void addClassPath(File classPath) {
		this.classpaths.addClasspath(classPath);
	}

}
