package com.ciet.challenge.batchprocessing.core.numbertransformation;

class GetEvenOrOddTransformationDecorator extends AbstractTransformationRuleDecorator {

  public GetEvenOrOddTransformationDecorator(ITransformationRuleDecorator decorator) {
    super(decorator);
  }

  @Override
  public String transform(Long currentNumber) {
    return getEvenOrOddTextOfCurrentNumber(currentNumber)
        .concat(spliterator())
        .concat(super.transform(currentNumber));
  }

  private String getEvenOrOddTextOfCurrentNumber(Long currentNumber) {
    return currentNumber % 2 == 0 ? "PAR" : "IMPAR";
  }
}
