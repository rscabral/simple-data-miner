package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
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

  public OutputNumberDto transformParsedData(Long inputNumber) {
    return transformationRuleDecorator.transform(OutputNumberDto.builder(), inputNumber);
  }
}
