package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;

interface ITransformationRuleService {
  OutputNumberDto transformParsedData(Long currentNumber);
}
