package org.acme.demo.exceptions;

public class FileStorageException extends IllegalArgumentException {
  public FileStorageException(String message) {
    super(message);
  }

  public FileStorageException(String message, Throwable cause) {
      super(message, cause);
  }
}
