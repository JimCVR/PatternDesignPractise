package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;

import java.util.ArrayList;
import java.util.List;

public class PercentajeMiddleware extends Middleware {

    @Override
    public double applyDiscount(double price, List <Discount> discounts) {
        double totalDiscount = 0.0;
        for(Discount actual: discounts){
            if(actual.getType() == DiscountType.PERCENTAJE){
                totalDiscount+= actual.getAmount();
            }
        }
        double newPrice = price * (1 - totalDiscount/100);
        if(totalDiscount == 0.0)
            return price;
        else
            return checkNext(newPrice, discounts);
    }
}
