package com.ciet.challenge.batchprocessing.core.numbertransformation;

import org.springframework.stereotype.Service;

@Service
class TransformationRuleForEachNumberService implements ITransformationRuleService {
  private ITransformationRuleDecorator transformationRuleDecorator;

  public TransformationRuleForEachNumberService() {
    transformationRuleDecorator =
        new GetCurrentNumberTransformationDecorator(
            new GetEvenOrOddTransformationDecorator(
                new GetIntegerResultOfDivisionTransformationDecorator(
                    new GetRemainderOfDivisionTransformationDecorator(null))));

  }

  public String transformParsedData(Long inputNumber) {
    return transformationRuleDecorator.transform(inputNumber);
  }
}
