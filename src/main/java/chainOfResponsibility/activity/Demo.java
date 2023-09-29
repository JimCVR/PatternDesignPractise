package chainOfResponsibility.activity;

import chainOfResponsibility.activity.discount.Discount;
import chainOfResponsibility.activity.discount.DiscountType;
import chainOfResponsibility.activity.middleware.FixedMiddleware;
import chainOfResponsibility.activity.middleware.Middleware;
import chainOfResponsibility.activity.middleware.PercentajeMiddleware;
import chainOfResponsibility.activity.middleware.PostPercentajeMiddleware;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Discount> dis = new ArrayList<>();
        dis.add(new Discount(10,DiscountType.FIXED,true));
        dis.add(new Discount(4.5, DiscountType.FIXED,false));
        dis.add(new Discount(2,DiscountType.FIXED,false));
        dis.add(new Discount(15,DiscountType.PERCENTAJE,true));
        dis.add(new Discount(5.5,DiscountType.FIXED,true));

        Middleware middleware = Middleware.link(
                new FixedMiddleware(),
                new PercentajeMiddleware(),
                new PostPercentajeMiddleware()
        );

        double finalAmount = middleware.applyDiscount(100,dis);
        System.out.println(finalAmount);

    }
}
