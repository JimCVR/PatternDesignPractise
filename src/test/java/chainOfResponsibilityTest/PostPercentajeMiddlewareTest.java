package chainOfResponsibilityTest;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;
import chainOfResponsibility.activity.middleware.FixedMiddleware;
import chainOfResponsibility.activity.middleware.PostPercentajeMiddleware;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostPercentajeMiddlewareTest {
        private PostPercentajeMiddleware postPercentajeMiddleware = new PostPercentajeMiddleware();
        private Discount fixedDiscount1 = new Discount(5, DiscountType.FIXED,false);
        private Discount fixedDiscount2 = new Discount(10,DiscountType.FIXED,false);
        private Discount percentajeDiscount = new Discount(10,DiscountType.PERCENTAJE,false);
        private Discount postPercentajeDiscount1 = new Discount(3,DiscountType.FIXED,true);
        private Discount postPercentajeDiscount2 = new Discount(8,DiscountType.FIXED,true);
        private List<Discount> discountList = new ArrayList();
        private double price = 100;

        @Test
        public void applyDiscountWhenPostPercentajeDiscountAvailable (){
            discountList.add(fixedDiscount1);
            discountList.add(percentajeDiscount);
            discountList.add(postPercentajeDiscount1);
            double discountPrice = postPercentajeMiddleware.applyDiscount(price, discountList);
            assertEquals(97,discountPrice);
        }
        @Test
        public void applyDiscountWhenPostPercentajeDiscountNotAvailable(){
            discountList.add(percentajeDiscount);

            double discountPrice = postPercentajeMiddleware.applyDiscount(price, discountList);
            assertEquals(100,discountPrice);
        }
        @Test
        public void applyDiscountWhenMultiplePostPercentajeDiscounts(){
            discountList.add(postPercentajeDiscount1);
            discountList.add(postPercentajeDiscount2);
            double discountPrice = postPercentajeMiddleware.applyDiscount(price, discountList);
            assertEquals(89,discountPrice);
        }

    @Test
    public void applyDiscountWhenPercentajeDiscountsNotAvailable(){
        discountList.add(fixedDiscount1);
        discountList.add(postPercentajeDiscount1);
        double discountPrice = postPercentajeMiddleware.applyDiscount(price, discountList);
        assertEquals(100,discountPrice);
    }
}
