package it.euris.academy2023.oldfashionpound.service;

import it.euris.academy2023.oldfashionpound.entities.ParsingResult;
import it.euris.academy2023.oldfashionpound.exceptions.ParsingExpressionException;

public class Application {

    public void run(String expression){
        AmountParser amountParser = AmountParser.getInstance();
        AmountPrinter amountPrinter = AmountPrinter.getInstance();
        try {
            ParsingResult parsingResult = amountParser.parse(expression);
            amountPrinter.printAmount(parsingResult.getFirstOperand());

        } catch (ParsingExpressionException e) {
            amountPrinter.printError(e.getMessage());
        }
    }
}
