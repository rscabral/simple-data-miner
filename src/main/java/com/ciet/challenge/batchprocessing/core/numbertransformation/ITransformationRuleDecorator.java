package com.ciet.challenge.batchprocessing.core.numbertransformation;

interface ITransformationRuleDecorator {
  String transform(Long currentNumber);

  String spliterator();
}
