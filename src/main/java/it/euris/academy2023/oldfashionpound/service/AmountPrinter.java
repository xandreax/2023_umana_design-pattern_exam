package it.euris.academy2023.oldfashionpound.service;

import it.euris.academy2023.oldfashionpound.entities.Amount;

public class AmountPrinter {

    private static AmountPrinter instance;

    private AmountPrinter() {
    }

    public static AmountPrinter getInstance() {
        if (instance == null) {
            instance = new AmountPrinter();
        }
        return instance;
    }

    public void printError(String error) {
        System.out.println("Error: " + error);
    }

    public void printAmount(Amount amount) {
        System.out.printf("Result: %dp %ds %dd", amount.getPounds(), amount.getShillings(), amount.getPences());
    }
}
