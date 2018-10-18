package items;

import products.Product;

public class PurchasedItem
{
    private Product type_;
    private double weight_;
    private double price_;
    private String comment_;

    private void setDefaultWeight()
    {
        weight_ = 1.00;
    }

    private void setDefaultPrice()
    {
        price_ = 100.00;
    }

    private void setDefaultComment()
    {
        comment_ = "";
    }

    private void setDefaultType()
    {
        type_ = Product.OTHER;
    }

    public PurchasedItem()
    {
        setDefaultType();
        setDefaultWeight();
        setDefaultPrice();
        setDefaultComment();
    }

    public PurchasedItem(Product product, double weight, double price, String comment)
    {
        type_ = product;

        setDefaultWeight();
        if (weight >= 0.01 && weight <= 100.00)
        {
            weight_ = weight;
        }

        setDefaultPrice();
        if (price >= 1.00 && price <= 10000.00)
        {
            price_ = price;
        }

        setDefaultComment();
        if (comment instanceof String)
        {
            comment_ = comment;
        }
    }

    public double getWeight()
    {
        return weight_;
    }

    public double getPrice()
    {
        return price_;
    }

    public String toString()
    {
        return Product.getString(type_) + " " + String.valueOf(weight_)
                + " " + String.valueOf(price_) + " " + comment_;
    }
}
