package com.ciet.challenge.batchprocessing.core;

class GetIntegerResultOfDivisionTransformationDecorator extends AbstractTransformationRuleDecorator{

    // get from property file
    private Long divisor = 17L;

    public GetIntegerResultOfDivisionTransformationDecorator(ITransformationRuleDecorator decorator) {
        super(decorator);
    }

    @Override
    public String transform(Long currentNumber) {
        return getIntegerResultOfDivision(currentNumber, divisor)
                .concat(spliterator())
                .concat(super.transform(currentNumber));
    }

    private String getIntegerResultOfDivision(Long currentNumber, Long x) {
        return Long.toString(currentNumber / x);
    }
}
