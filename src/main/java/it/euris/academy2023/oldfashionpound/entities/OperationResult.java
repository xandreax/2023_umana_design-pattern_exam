package it.euris.academy2023.oldfashionpound.entities;

public class OperationResult {

    private Amount result;
    private Amount rest;

    public Amount getResult() {
        return result;
    }

    public Amount getRest() {
        return rest;
    }

    public static class OperationResultBuilder {
        private final OperationResult operationResult;

        private OperationResultBuilder() {
            this.operationResult = new OperationResult();
        }

        public static OperationResultBuilder builder() {
            return new OperationResultBuilder();
        }

        public OperationResultBuilder setResultAmount(Amount resultAmount) {
            this.operationResult.result = resultAmount;
            return this;
        }

        public OperationResultBuilder setRest(Amount rest) {
            this.operationResult.rest = rest;
            return this;
        }

        public OperationResult build() {
            return this.operationResult;
        }
    }
}
