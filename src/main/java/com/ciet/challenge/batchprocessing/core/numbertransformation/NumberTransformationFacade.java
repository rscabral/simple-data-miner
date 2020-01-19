package com.ciet.challenge.batchprocessing.core.numbertransformation;

public class NumberTransformationFacade {

  private ITransformationRuleService
      transformationRuleForEachNumberService;

  public NumberTransformationFacade(
      ITransformationRuleService
          transformationRuleForEachNumberService) {
    this.transformationRuleForEachNumberService =
        transformationRuleForEachNumberService;
  }

  public String transformData(Long number) {
    return transformationRuleForEachNumberService.transformParsedData(number);
  }
}
