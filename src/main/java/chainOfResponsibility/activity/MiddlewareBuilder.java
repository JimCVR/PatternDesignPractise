package chainOfResponsibility.activity;

import chainOfResponsibility.activity.middleware.FixedMiddleware;
import chainOfResponsibility.activity.middleware.Middleware;
import chainOfResponsibility.activity.middleware.PercentajeMiddleware;
import chainOfResponsibility.activity.middleware.PostPercentajeMiddleware;

import java.util.stream.Stream;

public class MiddlewareBuilder {
    private static Middleware middleware;

    public static Middleware buildDiscountType1 (){
        middleware = Middleware.link(
                new FixedMiddleware(),
                new PercentajeMiddleware(),
                new PostPercentajeMiddleware());
        return middleware;
    }
    public static Middleware buildDiscountType2 (){
        middleware = Middleware.link(
                new PercentajeMiddleware(),
                new PostPercentajeMiddleware(),
                new FixedMiddleware());
        return middleware;
    }
}
