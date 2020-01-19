package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

abstract class AbstractTransformationRuleDecorator implements ITransformationRuleDecorator {
  private ITransformationRuleDecorator decorator;

  public AbstractTransformationRuleDecorator(ITransformationRuleDecorator decorator) {
    this.decorator = decorator;
  }

  @Override
  public OutputNumberDto transform(
      OutputNumberDto.OutputNumberDtoDtoCreator outputNumberDtoDtoCreator, Long currentNumber) {
    if (decorator != null) {
      return decorator.transform(outputNumberDtoDtoCreator, currentNumber);
    }
    return outputNumberDtoDtoCreator.build();
  }

  @Override
  public String spliterator() {
    if (decorator != null) {
      return ",";
    }
    return "";
  }
}
