package chainOfResponsibility.activity.middleware;

import chainOfResponsibility.activity.discount.Discount;

import java.util.List;

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain){
        Middleware head = first;
        for(Middleware nextInChain: chain){
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract double applyDiscount(double price, List <Discount> discounts);

    protected double checkNext(double price, List <Discount> discounts){
        if (next == null) {
            return price;
        }
        return next.applyDiscount(price, discounts);
    }

}
