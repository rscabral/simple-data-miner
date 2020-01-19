package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

class GetIntegerResultOfDivisionTransformationDecorator
    extends AbstractTransformationRuleDecorator {

  // get from property file
  private Long divisor = 17L;

  public GetIntegerResultOfDivisionTransformationDecorator(ITransformationRuleDecorator decorator) {
    super(decorator);
  }

  @Override
  public OutputNumberDto transform(
      OutputNumberDto.OutputNumberDtoDtoCreator outputNumberDtoDtoCreator, Long currentNumber) {
    outputNumberDtoDtoCreator.setIntResultOfDivision(getIntegerResultOfDivision(currentNumber,
        divisor));
    return super.transform(outputNumberDtoDtoCreator, currentNumber);
  }

  private Long getIntegerResultOfDivision(Long currentNumber, Long x) {
    return currentNumber / x;
  }
}
