package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

class GetEvenOrOddTransformationDecorator extends AbstractTransformationRuleDecorator {

  public GetEvenOrOddTransformationDecorator(ITransformationRuleDecorator decorator) {
    super(decorator);
  }

  @Override
  public OutputNumberDto transform(
      OutputNumberDto.OutputNumberDtoDtoCreator outputNumberDtoDtoCreator, Long currentNumber) {
    outputNumberDtoDtoCreator.setEvenOrOdd(getEvenOrOddTextOfCurrentNumber(currentNumber));
    return super.transform(outputNumberDtoDtoCreator, currentNumber);
  }

  private String getEvenOrOddTextOfCurrentNumber(Long currentNumber) {
    return currentNumber % 2 == 0 ? "PAR" : "IMPAR";
  }
}
