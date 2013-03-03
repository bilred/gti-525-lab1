package ca.etsmtl.gti525.exceptions;

import java.io.Serializable;

public class PanierException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = 1L;
  // champs privés
  private int code = 0;

  // constructeurs
  public PanierException() {
    super();
  }

  public PanierException(String message) {
    super(message);
  }

  public PanierException(String message, Throwable cause) {
    super(message, cause);
  }

  public PanierException(Throwable cause) {
    super(cause);
  }

  public PanierException(String message, int code) {
    super(message);
    this.setCode(code);
  }

  public PanierException(Throwable cause, int code) {
    super(cause);
    this.setCode(code);
  }

  public PanierException(String message, Throwable cause, int code) {
    super(message, cause);
    this.setCode(code);
  }

  // getters - setters
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
