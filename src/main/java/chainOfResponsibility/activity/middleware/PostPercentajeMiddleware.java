package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;

import java.util.List;

public class PostPercentajeMiddleware extends Middleware {
    @Override
    public double applyDiscount(double price, List<Discount> discounts) {
        double totalDiscount = discounts
                .stream()
                .filter(Discount::isPostPercentaje)
                .mapToDouble(Discount::getAmount)
                .sum();
        double newPrice = price - totalDiscount;
        return checkNext(newPrice, discounts);
    }
}
