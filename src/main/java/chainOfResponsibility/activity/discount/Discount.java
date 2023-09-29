package chainOfResponsibility.activity.discount;

import chainOfResponsibility.activity.middleware.Middleware;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class Discount {
    private double amount;
    private DiscountType type;
    private boolean postPercentaje;

    public Discount(double amount,DiscountType type, boolean postPercentaje) {
        this.amount = amount;
        this.type = type;
        this.postPercentaje = postPercentaje;
    }
}
