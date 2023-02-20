package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.Amount;
import it.euris.academy2023.oldfashionpound.entities.OperationResult;

public class Division implements Operation {

    private Amount operand;
    private int constant;

    public Division(Amount firstOperand, int constant) {
        this.operand = firstOperand;
        this.constant = constant;
    }


    @Override
    public OperationResult calculate() {
        int pounds = operand.getPounds() / constant;
        int pounds_rest = operand.getPounds() % constant;
        int shillings_surplus = pounds_rest * LIMIT_SHILLINGS;

        int shillings = (operand.getShillings() + shillings_surplus) / constant;
        int shillings_rest = (operand.getShillings() + shillings_surplus) % constant;
        int pences_surplus = shillings_rest * LIMIT_PENCES;

        int pences = (operand.getPences() + pences_surplus) / constant;
        int pences_rest = (operand.getPences() + pences_surplus) % constant;

        Amount result = Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();
        Amount rest = Amount.AmountBuilder.builder().setShillings(shillings_rest).setPences(pences_rest).build();
        return OperationResult.OperationResultBuilder.builder().setResultAmount(result).setRest(rest).build();
    }
}
