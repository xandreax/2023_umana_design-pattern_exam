package it.euris.academy2023.oldfashionpound.service;

import it.euris.academy2023.oldfashionpound.entities.ParsingResult;
import it.euris.academy2023.oldfashionpound.exceptions.OperationTypeException;
import it.euris.academy2023.oldfashionpound.exceptions.ParsingExpressionException;
import it.euris.academy2023.oldfashionpound.operations.Operation;
import it.euris.academy2023.oldfashionpound.operations.OperatorFactory;

public class Application {

    public void run(String expression) {
        AmountParser amountParser = AmountParser.getInstance();
        AmountPrinter amountPrinter = AmountPrinter.getInstance();
        try {
            ParsingResult parsingResult = amountParser.parse(expression);
            Operation operation = OperatorFactory.getInstance().getOperation(parsingResult);
            amountPrinter.printOperationResult(operation.calculate());
        } catch (ParsingExpressionException | OperationTypeException e) {
            amountPrinter.printError(e.getMessage());
        }
    }
}
