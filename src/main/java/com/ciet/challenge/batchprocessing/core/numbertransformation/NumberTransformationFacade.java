package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

public class NumberTransformationFacade {

  private ITransformationRuleService
      transformationRuleForEachNumberService;

  public NumberTransformationFacade(
      ITransformationRuleService
          transformationRuleForEachNumberService) {
    this.transformationRuleForEachNumberService =
        transformationRuleForEachNumberService;
  }

  public OutputNumberDto transformData(Long number) {
    return transformationRuleForEachNumberService.transformParsedData(number);
  }
}
