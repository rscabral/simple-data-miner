package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

interface ITransformationRuleDecorator {
  OutputNumberDto transform(OutputNumberDto.OutputNumberDtoDtoCreator outputNumberDtoDtoCreator,
                            Long currentNumber);

  String spliterator();
}
