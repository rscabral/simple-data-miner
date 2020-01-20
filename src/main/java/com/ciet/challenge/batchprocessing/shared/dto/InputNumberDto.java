package com.ciet.challenge.batchprocessing.shared.dto;

import java.util.Objects;

public class InputNumberDto {
  private Long number;

  public InputNumberDto(Long number) {
    this.number = number;
  }

  public Long getNumber() {
    return number;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InputNumberDto)) {
      return false;
    }
    InputNumberDto that = (InputNumberDto) o;
    return Objects.equals(number, that.number);
  }

  @Override public int hashCode() {
    return Objects.hash(number);
  }
}
