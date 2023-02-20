package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.Amount;

public class Multiplication implements Operation {

    private final Amount operand;
    private final int constant;

    public Multiplication(Amount firstOperand, int constant) {
        this.operand = firstOperand;
        this.constant = constant;
    }

    @Override
    public Amount calculate() {
        int pences = operand.getPences() * constant;
        int pences_surplus = 0;
        if (pences > LIMIT_PENCES) {
            pences_surplus = pences / LIMIT_PENCES;
            pences = pences % LIMIT_PENCES;
        }

        int shillings = (operand.getShillings() * constant) + pences_surplus;
        int shillings_surplus = 0;
        if (shillings > LIMIT_SHILLINGS) {
            shillings_surplus = shillings / LIMIT_SHILLINGS;
            shillings = shillings % LIMIT_SHILLINGS;
        }

        int pounds = (operand.getPounds() * constant) + shillings_surplus;

        return Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();
    }
}
