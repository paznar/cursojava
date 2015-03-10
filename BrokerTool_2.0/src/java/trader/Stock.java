package trader;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Stock implements Serializable {

    @Id @Column 
    private String symbol;
    @Column 
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    // Methods to return the private values of this object
    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public String toString() {
        return "Stock:  " + symbol + "  " + price;
    }
}
