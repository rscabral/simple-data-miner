package com.ciet.challenge.batchprocessing.core.numbertransformation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class NumberTransformationConfiguration {

  @Bean
  NumberTransformationFacade numberTransformationFacade(
      ITransformationRuleService transformationRuleService) {
    return createNumberTransformationFacade(transformationRuleService);
  }

  private NumberTransformationFacade createNumberTransformationFacade(
      ITransformationRuleService transformationRuleService) {
    return new NumberTransformationFacade(transformationRuleService);
  }
}
