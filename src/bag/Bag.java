package bag;

import java.util.Arrays;

import items.PurchasedItem;

public class Bag
{
    private int maxItemNo_; // maximal number of items
    private double maxWeight_;
    private int counter_;
    private PurchasedItem items_[];

    private void setDefaultItemNo()
    {
        maxItemNo_ = 10;
    }

    private void setDefaultMaxWeight()
    {
        maxWeight_ = 50.0;
    }

    private void setCounter()
    {
        counter_ = 0;
    }

    private double calculateWeightOfItems(PurchasedItem items[])
    {
        double currentWeight = 0;
        for (int i = 0; i < counter_; i++)
        {
            currentWeight = currentWeight + items[i].getWeight();
        }
        return currentWeight;
    }

    private <T> int indexOf(T[] arr, T val)
    {
        return Arrays.asList(arr).indexOf(val);
    }

    public Bag()
    {
        setDefaultItemNo();
        setDefaultMaxWeight();
        setCounter();
        items_ = new PurchasedItem[maxItemNo_];
    }

    public Bag(int maxItemNo, double maxWeight)
    {
        maxItemNo_ = maxItemNo;
        maxWeight_ = maxWeight;
        setCounter();
        items_ = new PurchasedItem[maxItemNo_];
    }

    public boolean putIn(PurchasedItem item)
    {
        double weightOfCurrentItems = calculateWeightOfItems(items_);

        if (maxItemNo_ == counter_ || maxWeight_ < weightOfCurrentItems + item.getWeight())
        {
            return false;
        }

        items_[counter_] = item;
        counter_++;
        return true;
    }

    public boolean putIn(PurchasedItem items[])
    {
        double weightOfNewItems = calculateWeightOfItems(items);
        double weightOfCurrentItems = calculateWeightOfItems(items_);

        if (maxItemNo_ < (counter_ + items.length) || maxWeight_ < weightOfCurrentItems + weightOfNewItems)
        {
            return false;
        }

        for (int i = 0; i < items.length; i++)
        {
            items_[counter_] = items[i];
            counter_++;
        }
        return true;
    }

    public void makeEmpty()
    {
        items_ = null;
        items_ = new PurchasedItem[maxItemNo_];
        counter_ = 0;
    }

    public double getTotalPrice()
    {
        double totalPrice = 0;
        for (int i = 0; i < counter_; i++)
        {
            totalPrice = totalPrice + items_[i].getPrice();
        }
        return totalPrice;
    }

    public double getTotalWeight()
    {
        double totalWeight = 0;
        for (int i = 0; i < counter_; i++)
        {
            totalWeight = totalWeight + items_[i].getWeight();
        }
        return totalWeight;
    }

    public int getProductNo(PurchasedItem item)
    {
        return indexOf(items_, item);
    }

    public double getProductWeight(PurchasedItem item)
    {
        return item.getWeight();
    }
}
