package it.euris.academy2023.oldfashionpound.entities;

import it.euris.academy2023.oldfashionpound.operations.OperationType;

public class ParsingResult {
    private Amount firstOperand;
    private OperationType operator;
    private Amount secondOperand;
    private int constant;

    public OperationType getOperator() {
        return operator;
    }

    public Amount getFirstOperand() {
        return firstOperand;
    }

    public Amount getSecondOperand() {
        return secondOperand;
    }

    public int getConstant() {
        return constant;
    }

    public static class ParsingResultBuilder{
        private final ParsingResult result;

        private ParsingResultBuilder(){
            this.result = new ParsingResult();
        }

        public static ParsingResultBuilder builder(){
            return new ParsingResultBuilder();
        }

        public ParsingResultBuilder setFirst(Amount first){
            this.result.firstOperand = first;
            return this;
        }

        public ParsingResultBuilder setOperator(OperationType operator){
            this.result.operator = operator;
            return this;
        }

        public ParsingResultBuilder setSecond (Amount second){
            this.result.secondOperand = second;
            return this;
        }

        public ParsingResultBuilder setConstant (int constant){
            this.result.constant = constant;
            return this;
        }

        public ParsingResult build(){
            return this.result;
        }
    }
}
