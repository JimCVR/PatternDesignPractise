package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;

import java.util.List;

public class PostPercentajeMiddleware extends Middleware{
    @Override
    public double applyDiscount(double price, List<Discount> discounts) {
        double totalDiscount = 0;
        boolean hasPercentajeDiscount = false;
        for(Discount actual: discounts){
            if(actual.getType() == DiscountType.PERCENTAJE) {
                hasPercentajeDiscount = true;
            }
            if(actual.getType() == DiscountType.FIXED && actual.isPostPercentaje()){
                totalDiscount += actual.getAmount();
            }
        }
        if(hasPercentajeDiscount) {
            double newPrice = price - totalDiscount;
            return checkNext(newPrice, discounts);
        }
        return price;
    }
}
