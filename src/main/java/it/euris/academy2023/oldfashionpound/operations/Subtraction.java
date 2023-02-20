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
        int pences_surplus = 0;
        if (pences < 0) {
            pences = LIMIT_PENCES + pences;
            pences_surplus++;
        }

        int shillings = a1.getShillings() - a2.getShillings() - pences_surplus;
        int shillings_surplus = 0;
        if (shillings < 0) {
            shillings = LIMIT_SHILLINGS + shillings;
            shillings_surplus++;
        }

        int pounds = a1.getPounds() - a2.getPounds() - shillings_surplus;
        
        Amount result = Amount.AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();
        return OperationResult.OperationResultBuilder.builder().setResultAmount(result).build();
    }
}
