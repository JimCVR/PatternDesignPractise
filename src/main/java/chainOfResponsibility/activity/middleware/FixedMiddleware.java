package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;

import java.util.List;

public class FixedMiddleware extends Middleware {
    @Override
    public double applyDiscount(double price, List<Discount> discounts) {
        double totalDiscount = discounts
                .stream()
                .filter(it -> it.getType() == DiscountType.FIXED && !it.isPostPercentaje())
                .mapToDouble(Discount::getAmount)
                .sum();
        double newPrice = price - totalDiscount;
        return checkNext(newPrice, discounts);
    }
}
