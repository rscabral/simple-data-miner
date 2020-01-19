package com.ciet.challenge.batchprocessing.core.numbertransformation;

abstract class AbstractTransformationRuleDecorator implements ITransformationRuleDecorator {
  private ITransformationRuleDecorator decorator;

  public AbstractTransformationRuleDecorator(ITransformationRuleDecorator decorator) {
    this.decorator = decorator;
  }

  @Override
  public String transform(Long currentNumber) {
    if (decorator != null) {
      return decorator.transform(currentNumber);
    }
    return "";
  }

  @Override
  public String spliterator() {
    if (decorator != null) {
      return ",";
    }
    return "";
  }
}
