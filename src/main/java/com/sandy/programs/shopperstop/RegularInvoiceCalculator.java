package com.sandy.programs.shopperstop;

/**
 * Created by gondals on 18/09/16.
 */
public class RegularInvoiceCalculator implements InvoiceCalculator {

    private static final SlabHolder SLAB_HOLDER = new SlabHolder();

    static {
        SLAB_HOLDER.add(1, 0);
        SLAB_HOLDER.add(5001, 10);
        SLAB_HOLDER.add(10001, 20);
    }

    public static RegularInvoiceCalculator getInstance() {
        return new RegularInvoiceCalculator();
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
