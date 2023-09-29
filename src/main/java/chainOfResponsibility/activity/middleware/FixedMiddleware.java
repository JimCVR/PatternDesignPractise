package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;
import java.util.List;

public class FixedMiddleware extends Middleware{
    @Override
    public double applyDiscount(double price, List <Discount> discounts) {
        double totalDiscount = 0;
        for(Discount actual: discounts){
            if(actual.getType() == DiscountType.FIXED && actual.isPostPercentaje() == false){
                totalDiscount += actual.getAmount();
            }
        }
        double newPrice = price - totalDiscount;
        return checkNext(newPrice, discounts);
    }
}
