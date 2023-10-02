package chainOfResponsibility.activity.discount;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Discount {
    private double amount;
    private DiscountType type;
    private boolean postPercentaje;

    public Discount(double amount, DiscountType type, boolean postPercentaje) {
        this.amount = amount;
        this.type = type;
        this.postPercentaje = postPercentaje;
    }
}
