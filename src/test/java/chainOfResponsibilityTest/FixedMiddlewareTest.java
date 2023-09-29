package chainOfResponsibilityTest;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;
import chainOfResponsibility.activity.middleware.FixedMiddleware;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedMiddlewareTest {

    private FixedMiddleware fixedMiddleware = new FixedMiddleware();
    private Discount fixedDiscount1 = new Discount(5,DiscountType.FIXED,false);
    private Discount fixedDiscount2 = new Discount(10,DiscountType.FIXED,false);
    private Discount percentajeDiscount = new Discount(10,DiscountType.PERCENTAJE,false);
    private Discount postPercentajeDiscount = new Discount(3,DiscountType.FIXED,true);
    private List<Discount> discountList = new ArrayList();
    private double price = 100;

    @Test
    public void applyDiscountWhenFixedDiscountAvailable (){
        discountList.add(fixedDiscount1);
        discountList.add(percentajeDiscount);
        discountList.add(postPercentajeDiscount);
        double discountPrice = fixedMiddleware.applyDiscount(price, discountList);
        assertEquals(95,discountPrice);
    }
    @Test
    public void applyDiscountWhenFixedDiscountNotAvailable (){
        discountList.add(percentajeDiscount);
        discountList.add(postPercentajeDiscount);
        double discountPrice = fixedMiddleware.applyDiscount(price, discountList);
        assertEquals(100,discountPrice);
    }
    @Test
    public void applyDiscountWhenMultipleFixedDiscounts (){
        discountList.add(fixedDiscount1);
        discountList.add(fixedDiscount2);
        discountList.add(percentajeDiscount);
        discountList.add(postPercentajeDiscount);
        double discountPrice = fixedMiddleware.applyDiscount(price, discountList);
        assertEquals(85,discountPrice);
    }

}
