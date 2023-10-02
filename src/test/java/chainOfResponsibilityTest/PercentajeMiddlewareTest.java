package chainOfResponsibilityTest;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;
import chainOfResponsibility.activity.middleware.FixedMiddleware;
import chainOfResponsibility.activity.middleware.PercentajeMiddleware;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PercentajeMiddlewareTest {
        private PercentajeMiddleware percentajeMiddleware = new PercentajeMiddleware();
        private Discount fixedDiscount1 = new Discount(5, DiscountType.FIXED,false);
        private Discount fixedDiscount2 = new Discount(10,DiscountType.FIXED,false);
        private Discount percentajeDiscount1 = new Discount(10,DiscountType.PERCENTAJE,false);
        private Discount percentajeDiscount2 = new Discount(10,DiscountType.PERCENTAJE,false);
        private Discount postPercentajeDiscount = new Discount(3,DiscountType.FIXED,true);
        private List<Discount> discountList = new ArrayList();
        private double price = 24560;

        @Test
        public void applyDiscountWhenPercentajeDiscountAvailable (){
            discountList.add(fixedDiscount1);
            discountList.add(percentajeDiscount1);
            discountList.add(postPercentajeDiscount);
            double discountPrice = percentajeMiddleware.applyDiscount(price, discountList);
            assertEquals(22104,discountPrice);
        }
        @Test
        public void applyDiscountWhenPercentajeDiscountNotAvailable (){

            discountList.add(postPercentajeDiscount);
            double discountPrice = percentajeMiddleware.applyDiscount(price, discountList);
            assertEquals(24560,discountPrice);
        }
        @Test
        public void applyDiscountWhenMultiplePercentajeDiscounts (){
            discountList.add(fixedDiscount1);
            discountList.add(fixedDiscount2);
            discountList.add(percentajeDiscount1);
            discountList.add(percentajeDiscount2);
            discountList.add(postPercentajeDiscount);
            double discountPrice = percentajeMiddleware.applyDiscount(price, discountList);
            assertEquals(19648,discountPrice);
        }

}