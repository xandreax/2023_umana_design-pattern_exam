package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.Amount;

public class Division implements Operation {

    private Amount operand;
    private int constant;

    public Division(Amount firstOperand, int constant) {
        this.operand = firstOperand;
        this.constant = constant;
    }


    @Override
    public Amount calculate() {
        return null;
    }
}
