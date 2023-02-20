package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.Amount;

public class Sum implements Operation {

    private Amount a1;
    private Amount a2;

    public Sum(Amount firstOperand, Amount secondOperand) {
        this.a1 = firstOperand;
        this.a2 = secondOperand;
    }

    @Override
    public Amount calculate() {
        return null;
    }
}
