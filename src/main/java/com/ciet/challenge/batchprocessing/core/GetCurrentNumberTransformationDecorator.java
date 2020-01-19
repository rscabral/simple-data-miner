package com.ciet.challenge.batchprocessing.core;

class GetCurrentNumberTransformationDecorator extends AbstractTransformationRuleDecorator{

    public GetCurrentNumberTransformationDecorator(ITransformationRuleDecorator decorator) {
        super(decorator);
    }

    @Override
    public String transform(Long currentNumber) {
        return currentNumber.toString().concat(spliterator()).concat(super.transform(currentNumber));
    }
}
