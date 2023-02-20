package it.euris.academy2023.oldfashionpound.service;

import it.euris.academy2023.oldfashionpound.entities.Amount;
import it.euris.academy2023.oldfashionpound.entities.ParsingResult;
import it.euris.academy2023.oldfashionpound.entities.ParsingResult.ParsingResultBuilder;
import it.euris.academy2023.oldfashionpound.exceptions.ParsingExpressionException;
import it.euris.academy2023.oldfashionpound.operations.OperationType;

public class AmountParser {

    private static AmountParser instance;

    private AmountParser() {
    }

    public static AmountParser getInstance() {
        if (instance == null) {
            instance = new AmountParser();
        }
        return instance;
    }

    public ParsingResult parse(String expression) throws ParsingExpressionException {
        OperationType operationType = parseOperator(expression);
        String[] operands = expression.split(operationType.getOperator());
        Amount firstOperand = parseAmount(operands[0].replaceAll(" ", ""));
        ParsingResultBuilder builder = ParsingResultBuilder.builder().setFirst(firstOperand).setOperator(operationType);
        if (operationType == OperationType.MULTIPLICATION || operationType == OperationType.DIVISION) {
            try {
                int constant = Integer.parseInt(operands[1].replaceAll(" ", ""));
                builder.setConstant(constant);
            } catch (NumberFormatException e) {
                throw new ParsingExpressionException("Error in the second operands: please use a integer in multiplication and division as second operand");
            }
        } else {
            Amount secondOperator = parseAmount(operands[1].replaceAll(" ", ""));
            builder.setSecond(secondOperator);
        }
        return builder.build();
    }

    private Amount parseAmount(String operand) {
        int pounds = 0;
        int shillings = 0;
        int pences = 0;
        if (operand.contains("p")) {
            String poundsString = operand.substring(0, operand.indexOf("p"));
            pounds = Integer.parseInt(poundsString);
        }
        if (operand.contains("s")) {
            String shillingsString = operand.substring(operand.indexOf("p") + 1, operand.indexOf("s"));
            shillings = Integer.parseInt(shillingsString);
        }
        String pencesString = operand.substring(operand.indexOf("s") + 1, operand.indexOf("d"));
        pences = Integer.parseInt(pencesString);
        return Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();
    }

    private OperationType parseOperator(String expression) throws ParsingExpressionException {
        if (expression.contains("+")) {
            return OperationType.SUM;
        } else if (expression.contains(OperationType.SUBTRACTION.getOperator())) {
            return OperationType.SUBTRACTION;
        } else if (expression.contains("*")) {
            return OperationType.MULTIPLICATION;
        } else if (expression.contains(OperationType.DIVISION.getOperator())) {
            return OperationType.DIVISION;
        } else {
            throw new ParsingExpressionException("No operators in this expression");
        }
    }
}
