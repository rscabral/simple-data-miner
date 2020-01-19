package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

class GetCurrentNumberTransformationDecorator extends AbstractTransformationRuleDecorator {

  public GetCurrentNumberTransformationDecorator(ITransformationRuleDecorator decorator) {
    super(decorator);
  }

  @Override
  public OutputNumberDto transform(
      OutputNumberDto.OutputNumberDtoDtoCreator outputNumberDtoDtoCreator, Long currentNumber) {
    outputNumberDtoDtoCreator.setNumber(currentNumber);
    return super.transform(outputNumberDtoDtoCreator, currentNumber);
  }
}
