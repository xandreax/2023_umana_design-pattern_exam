package it.euris.academy2023.oldfashionpound.operations;

public enum OperationType {
    SUM("\\+"),
    SUBTRACTION("-"),
    MULTIPLICATION("\\*"),
    DIVISION("/");

    private final String operator;

    OperationType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
