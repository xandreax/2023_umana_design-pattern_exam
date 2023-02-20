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
        int pounds = operand.getPounds() / constant;
        int shillings_surplus = (operand.getPounds() % constant) * LIMIT_SHILLINGS;

        int shillings = (operand.getShillings() + shillings_surplus) / constant;
        int pences_surplus = ((operand.getShillings() + shillings_surplus) % constant) * LIMIT_PENCES;

        int pences = (operand.getPences() + pences_surplus) / constant;

        return Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();
    }
}
