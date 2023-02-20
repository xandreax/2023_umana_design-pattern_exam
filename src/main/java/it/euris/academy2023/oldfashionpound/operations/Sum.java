package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.Amount;
import it.euris.academy2023.oldfashionpound.entities.Amount.AmountBuilder;

public class Sum implements Operation {

    private final Amount a1;
    private final Amount a2;

    public Sum(Amount firstOperand, Amount secondOperand) {
        this.a1 = firstOperand;
        this.a2 = secondOperand;
    }

    @Override
    public Amount calculate() {

        int pences = a1.getPences() + a2.getPences();
        int pences_surplus = 0;
        if (pences > LIMIT_PENCES) {
            pences = pences - LIMIT_PENCES;
            pences_surplus++;
        }

        int shillings = a1.getShillings() + a2.getShillings() + pences_surplus;
        int shillings_surplus = 0;
        if (shillings > LIMIT_SHILLINGS) {
            shillings = shillings - LIMIT_SHILLINGS;
            shillings_surplus++;
        }

        int pounds = a1.getPounds() + a2.getPounds() + shillings_surplus;

        return AmountBuilder.builder().setPounds(pounds).setShillings(shillings).setPences(pences).build();
    }
}
