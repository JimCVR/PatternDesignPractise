package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;

import java.util.ArrayList;
import java.util.List;

public class PercentajeMiddleware extends Middleware {

    @Override
    public double applyDiscount(double price, List <Discount> discounts) {
        double totalDiscount = discounts
                .stream()
                .filter(it -> it.getType() == DiscountType.PERCENTAJE)
                .mapToDouble(Discount::getAmount)
                .sum();
        double newPrice = price * (1 - totalDiscount/100);
        return checkNext(newPrice, discounts);
    }
}
