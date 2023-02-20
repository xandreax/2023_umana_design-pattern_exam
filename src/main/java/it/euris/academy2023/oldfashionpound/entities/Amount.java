package it.euris.academy2023.oldfashionpound.entities;

public class Amount {
    private int pounds;
    private int shillings;
    private int pences;

    private static final int LIMIT_PENCES = 12;
    private static final int LIMIT_SHILLINGS = 20;

    public int getPounds() {
        return pounds;
    }

    public int getShillings() {
        return shillings;
    }

    public int getPences() {
        return pences;
    }

    public static class AmountBuilder{
        private final Amount amount;

        private AmountBuilder(){
            this.amount = new Amount();
        }

        public static AmountBuilder builder(){
            return new AmountBuilder();
        }

        public AmountBuilder setPences(int pences){
            this.amount.pences = pences;
            return this;
        }

        public AmountBuilder setShillings(int shillings){
            this.amount.shillings = shillings;
            return this;
        }

        public AmountBuilder setPounds(int pounds){
            this.amount.pounds = pounds;
            return this;
        }

        public Amount build(){
            return this.amount;
        }
    }
}
