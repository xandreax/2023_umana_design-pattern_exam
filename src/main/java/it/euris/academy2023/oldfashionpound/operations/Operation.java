package it.euris.academy2023.oldfashionpound.operations;

import it.euris.academy2023.oldfashionpound.entities.OperationResult;

public interface Operation {

    static final int LIMIT_PENCES = 12;
    static final int LIMIT_SHILLINGS = 20;

    OperationResult calculate();
}
