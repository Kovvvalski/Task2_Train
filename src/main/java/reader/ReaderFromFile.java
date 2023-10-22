package reader;

import exception.ReadFromFileException;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static main.Main.log;

public class ReaderFromFile {
  public String readFromFile(String path, Charset encoding) throws ReadFromFileException {
    byte[] encoded;
    try {
      encoded = Files.readAllBytes(Paths.get(path));
    } catch (IOException e) {
      log.log(Level.FATAL, "Error opening the file " + path);
      throw new ReadFromFileException("Problems with opening the file " + path, e);
    }
    return new String(encoded, encoding);
  }
}
