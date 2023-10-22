package exception;

public class ReadFromFileException extends Exception {
  public ReadFromFileException() {

  }

  public ReadFromFileException(String message, Throwable cause) {
    super(message, cause);
  }

  public ReadFromFileException(String message) {
    super(message);
  }

  public ReadFromFileException(Throwable cause) {
    super(cause);
  }
}
