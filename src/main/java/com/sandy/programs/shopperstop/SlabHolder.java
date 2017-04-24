package com.sandy.programs.shopperstop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gondals on 18/09/16.
 */
public class SlabHolder {

    private List<RangeDiscount> rangeDiscounts = new ArrayList<>();

    public void add(final double range, final double discount) {
        RangeDiscount rangeDiscount = new RangeDiscount(range, discount);
        updateOldRangeDiscount(range);
        rangeDiscounts.add(rangeDiscount);
    }

    private void updateOldRangeDiscount(final double range) {
        if (rangeDiscounts.size() == 0)
            return;
        RangeDiscount rangeDiscount = rangeDiscounts.get(rangeDiscounts.size() - 1);
        rangeDiscount.setEnd(range - 1);
    }

    public double getDiscountAmount(final double amount) {
        return rangeDiscounts.stream()
                .mapToDouble(rd -> {
                    if (considerRangeForAmount(amount, rd)) {
                        double discountMultiplier = 1 - (rd.getDiscount() / 100);
                        double slabAmount = getSlabAmount(amount, rd);
                        return slabAmount * discountMultiplier;
                    } else {
                        return 0.0;
                    }
                })
                .sum();
    }

    private double getSlabAmount(final double amount, final RangeDiscount rd) {
        final double slabAmount;
        if (amount < rd.getEnd())
            slabAmount = amount - rd.getStart();
        else
            slabAmount = rd.getEnd() - rd.getStart();
        return slabAmount + 1;
    }

    private boolean considerRangeForAmount(final double amount, final RangeDiscount rd) {
        return amount > rd.start;
    }

    private class RangeDiscount {
        private double start;
        private double end;
        private double discount;

        public RangeDiscount(final double start, final double discount) {
            this.start = start;
            this.end = Double.MAX_VALUE;
            this.discount = discount;
        }

        public double getStart() {
            return start;
        }

        public void setStart(final double start) {
            this.start = start;
        }

        public double getEnd() {
            return end;
        }

        public void setEnd(final double end) {
            this.end = end;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(final double discount) {
            this.discount = discount;
        }

        @Override
        public String toString() {
            return "RangeDiscount{" +
                    "start=" + start +
                    ", end=" + end +
                    ", discount=" + discount +
                    '}';
        }
    }
}
