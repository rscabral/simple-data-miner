package com.ciet.challenge.batchprocessing.shared.dto;

import java.util.Objects;

/**
 * The class Output number dto.
 * Created at 19 de jan de 2020 18:50:56
 */
public class OutputNumberDto {
  /**
   * The Number.
   */
  private Long number;
  /**
   * The Even or odd.
   */
  private String evenOrOdd;
  /**
   * The Int result of division.
   */
  private Long intResultOfDivision;
  /**
   * The Int result of mod.
   */
  private Long intResultOfMod;

  public static OutputNumberDtoDtoCreator builder() {
    return new OutputNumberDtoDtoCreator();
  }

  /**
   * Gets number.
   * Created at 19 de jan de 2020 18:50:56
   *
   * @return the number
   */
  public Long getNumber() {
    return number;
  }

  /**
   * Gets even or odd.
   * Created at 19 de jan de 2020 18:50:56
   *
   * @return the even or odd
   */
  public String getEvenOrOdd() {
    return evenOrOdd;
  }

  /**
   * Gets int result of division.
   * Created at 19 de jan de 2020 18:50:56
   *
   * @return the int result of division
   */
  public Long getIntResultOfDivision() {
    return intResultOfDivision;
  }

  /**
   * Gets int result of mod.
   * Created at 19 de jan de 2020 18:50:56
   *
   * @return the int result of mod
   */
  public Long getIntResultOfMod() {
    return intResultOfMod;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OutputNumberDto)) {
      return false;
    }
    OutputNumberDto that = (OutputNumberDto) o;
    return Objects.equals(number, that.number) &&
        Objects.equals(evenOrOdd, that.evenOrOdd) &&
        Objects.equals(intResultOfDivision, that.intResultOfDivision) &&
        Objects.equals(intResultOfMod, that.intResultOfMod);
  }

  @Override public int hashCode() {
    return Objects.hash(number, evenOrOdd, intResultOfDivision, intResultOfMod);
  }

  public static class OutputNumberDtoDtoCreator {
    private OutputNumberDto outputNumberDto;

    protected OutputNumberDtoDtoCreator() {
      this.outputNumberDto = new OutputNumberDto();
    }

    public OutputNumberDtoDtoCreator setNumber(Long number) {
      this.outputNumberDto.number = number;
      return this;
    }

    public OutputNumberDtoDtoCreator setEvenOrOdd(String evenOrOdd) {
      this.outputNumberDto.evenOrOdd = evenOrOdd;
      return this;
    }

    public OutputNumberDtoDtoCreator setIntResultOfDivision(Long intResultOfDivision) {
      this.outputNumberDto.intResultOfDivision = intResultOfDivision;
      return this;
    }

    public OutputNumberDtoDtoCreator setIntResultOfMod(Long intResultOfMod) {
      this.outputNumberDto.intResultOfMod = intResultOfMod;
      return this;
    }

    public OutputNumberDto build() {
      return this.outputNumberDto;
    }
  }

}
