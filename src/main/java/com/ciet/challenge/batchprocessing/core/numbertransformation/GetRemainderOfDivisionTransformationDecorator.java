package com.ciet.challenge.batchprocessing.core.numbertransformation;

class GetRemainderOfDivisionTransformationDecorator extends AbstractTransformationRuleDecorator {

  // get from property file
  private Long divisor = 17L;

  public GetRemainderOfDivisionTransformationDecorator(ITransformationRuleDecorator decorator) {
    super(decorator);
  }

  @Override
  public String transform(Long currentNumber) {
    return getRemainderOfDivision(currentNumber, divisor)
        .concat(spliterator())
        .concat(super.transform(currentNumber));
  }

  private String getRemainderOfDivision(Long currentNumber, Long x) {
    return Long.toString(currentNumber % x);
  }
}
