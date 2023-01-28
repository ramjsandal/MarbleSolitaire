import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Readable that throws an IOException for testing purposes.
 */
public class BadReadable implements Readable {
  /**
   * Throws an IOException whenever called.
   *
   * @param cb the buffer to read characters into
   * @return nothing
   * @throws IOException whenever called
   */
  @Override
  public int read(CharBuffer cb) throws IOException {
    throw new IOException("I THROW EXCEPTIONS ITS ALL I DO");
  }
}
