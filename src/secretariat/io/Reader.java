package secretariat.io;

import java.io.File;

/**
 * 
 * Interface de lecture
 *
 * @param <T>
 */
public interface Reader<T> {

	public abstract T read(File file);

}
