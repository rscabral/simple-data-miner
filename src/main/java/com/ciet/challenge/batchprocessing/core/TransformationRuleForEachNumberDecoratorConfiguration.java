package com.ciet.challenge.batchprocessing.core;

class TransformationRuleForEachNumberDecoratorConfiguration {
    private ITransformationRuleDecorator transformationRuleDecorator;

    public TransformationRuleForEachNumberDecoratorConfiguration() {
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
