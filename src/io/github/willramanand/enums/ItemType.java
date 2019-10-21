package io.github.willramanand.enums;

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIOMOBILE("AM"),
  VISUALMOBILE("VM");

  private final String code;

  ItemType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
