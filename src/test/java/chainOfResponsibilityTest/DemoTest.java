package chainOfResponsibilityTest;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;
import chainOfResponsibility.activity.middleware.FixedMiddleware;
import chainOfResponsibility.activity.middleware.Middleware;
import chainOfResponsibility.activity.middleware.PercentajeMiddleware;
import chainOfResponsibility.activity.middleware.PostPercentajeMiddleware;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {

    private Discount fixedDiscount1 = new Discount(5, DiscountType.FIXED,false);
    private Discount fixedDiscount2 = new Discount(10,DiscountType.FIXED,false);
    private Discount percentajeDiscount = new Discount(10,DiscountType.PERCENTAJE,false);
    private Discount postPercentajeDiscount = new Discount(3,DiscountType.FIXED,true);
    private List<Discount> discountList = new ArrayList();
    private double price = 100.0;

    @Test
    public void chainOfResponnsiblityTestWhenAllDiscounts() {
        discountList.add(fixedDiscount1);
        discountList.add(fixedDiscount2);
        discountList.add(percentajeDiscount);
        discountList.add(postPercentajeDiscount);



        Middleware middleware = Middleware.link(
                new FixedMiddleware(),
                new PercentajeMiddleware(),
                new PostPercentajeMiddleware()
        );
        double finalAmount = middleware.applyDiscount(price,discountList);
        assertEquals(73.5,finalAmount);
    }


    @Test
    public void chainOfResponnsiblityTestWhenNoPercentaje() {
        discountList.add(fixedDiscount1);
        discountList.add(fixedDiscount2);
        discountList.add(postPercentajeDiscount);



        Middleware middleware = Middleware.link(
                new FixedMiddleware(),
                new PercentajeMiddleware(),
                new PostPercentajeMiddleware()
        );
        double finalAmount = middleware.applyDiscount(price,discountList);
        assertEquals(85,finalAmount);
    }
}
