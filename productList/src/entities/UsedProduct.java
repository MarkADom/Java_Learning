package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date manufactureDate;

    public UsedProduct(String name, Double price, Date manufacturedDate) {
        super(name, price);
        this.manufactureDate = manufacturedDate;
    }

    public Date getManufacturedDate() {
        return manufactureDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        this.manufactureDate = manufacturedDate;
    }

    @Override
    public String priceTag() {
        return getName()
                + " (used) $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + sdf.format(manufactureDate)
                + ")";
    }
}
