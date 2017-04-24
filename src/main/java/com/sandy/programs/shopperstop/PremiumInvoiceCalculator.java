package com.sandy.programs.shopperstop;

/**
 * Created by gondals on 18/09/16.
 */
public class PremiumInvoiceCalculator implements InvoiceCalculator {

    private static final SlabHolder SLAB_HOLDER = new SlabHolder();

    static {
        SLAB_HOLDER.add(1, 10);
        SLAB_HOLDER.add(4001, 15);
        SLAB_HOLDER.add(8001, 20);
        SLAB_HOLDER.add(12001, 30);
    }

    public static PremiumInvoiceCalculator getInstance() {
        return new PremiumInvoiceCalculator();
    }

    @Override
    public double generate(final double amount) {
        validate(amount);
        return SLAB_HOLDER.getDiscountAmount(amount);
    }

    private void validate(final double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid amount specified");
    }
}
