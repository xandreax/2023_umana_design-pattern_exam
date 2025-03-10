package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.Amount;
import it.euris.academy2023.oldfashionpound.entities.OperationResult;

public class Subtraction implements Operation {

    private final Amount a1;
    private final Amount a2;

    public Subtraction(Amount firstOperand, Amount secondOperand) {
        this.a1 = firstOperand;
        this.a2 = secondOperand;
    }

    @Override
    public OperationResult calculate() {
        int pences = a1.getPences() - a2.getPences();
        int pences_rest = pences;
        int pences_surplus = 0;
        if (pences < 0) {
            pences = LIMIT_PENCES + pences;
            pences_surplus++;
        }

        int shillings = a1.getShillings() - a2.getShillings() - pences_surplus;
        int shilling_rest = shillings;
        int shillings_surplus = 0;
        if (shillings < 0) {
            shillings = LIMIT_SHILLINGS + shillings;
            shillings_surplus++;
        }

        int pounds = a1.getPounds() - a2.getPounds() - shillings_surplus;

        OperationResult.OperationResultBuilder builder = OperationResult.OperationResultBuilder.builder();
        if (pounds < 0) {
            Amount rest = Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shilling_rest).setPences(pences_rest).build();
            pounds = 0;
            shillings = 0;
            pences = 0;
            builder.setRest(rest);
        }
        Amount result = Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();

        return builder.setResultAmount(result).build();
    }
}
