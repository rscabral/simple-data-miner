package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

class GetRemainderOfDivisionTransformationDecorator extends AbstractTransformationRuleDecorator {

  // get from property file
  private Long divisor = 17L;

  public GetRemainderOfDivisionTransformationDecorator(ITransformationRuleDecorator decorator) {
    super(decorator);
  }

  @Override
  public OutputNumberDto transform(
      OutputNumberDto.OutputNumberDtoDtoCreator outputNumberDtoDtoCreator, Long currentNumber) {
    outputNumberDtoDtoCreator.setIntResultOfMod(getRemainderOfDivision(currentNumber, divisor));
    return super.transform(outputNumberDtoDtoCreator, currentNumber);
  }

  private Long getRemainderOfDivision(Long currentNumber, Long x) {
    return currentNumber % x;
  }
}
