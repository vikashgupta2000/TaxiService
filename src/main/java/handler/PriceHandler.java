package handler;

/**
 * Assumption INR 2 per distance and an extra of INR 10 for pinkTaxi
 */
public enum PriceHandler {
    BANGALORE {
        public long calculatePrice(long distance, boolean isPink) {
            long amount = distance * 2;
            if(isPink) amount += 10;
            return amount;
        }
    };

    public abstract long calculatePrice(long distance, boolean isPink);
}
