package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.ParsingResult;
import it.euris.academy2023.oldfashionpound.exceptions.OperationTypeException;

public class OperatorFactory {

    public Operation getOperation(ParsingResult parsingResult) throws OperationTypeException {
        switch(parsingResult.getOperator()){
            case SUM: return new Sum(parsingResult.getFirstOperand(), parsingResult.getSecondOperand());
            case SUBTRACTION: return new Subtraction(parsingResult.getFirstOperand(), parsingResult.getSecondOperand());
            case MULTIPLICATION: return new Multiplication(parsingResult.getFirstOperand(), parsingResult.getConstant());
            case DIVISION: return new Division(parsingResult.getFirstOperand(), parsingResult.getConstant());
            default: throw new OperationTypeException("Operation not recognised");
        }
    }
}
