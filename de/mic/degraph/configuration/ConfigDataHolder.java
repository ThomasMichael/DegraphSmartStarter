package de.mic.degraph.configuration;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.io.File;

import de.mic.degraph.configuration.types.ClassPathes;
import de.mic.degraph.configuration.types.Cluding;
import de.mic.degraph.configuration.types.Cludings;
import de.mic.degraph.configuration.types.Group;
import de.mic.degraph.configuration.types.Groups;
import de.mic.degraph.configuration.types.YedOutput;

/**
 * This class represents the whole date for degraph configuration.
 * 
 * 
 */
public class ConfigDataHolder {

	private YedOutput output;
	private final ClassPathes classpaths = new ClassPathes();
	private final Groups slices = new Groups();
	private final Cludings cludings = new Cludings();

	public ConfigDataHolder() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(output == null ? "noName" + CRLF : output.toString());
		sb.append(classpaths.toString());
		sb.append(cludings.toString());
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
	public void addGroup(Group slice) {
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

	/**
	 * Add include or exclude.
	 * 
	 * @param including
	 */
	public void addCluding(Cluding including) {
		cludings.addCluding(including);
	}

}
