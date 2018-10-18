package items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import products.Product;

class PurchasedItemTests
{
    @Test
    public void createDefaultItemAndReturnWeightEqualsOne()
    {
        PurchasedItem item = new PurchasedItem();
        Assertions.assertEquals(1, item.getWeight());
    }

    @Test
    public void createDefaultItemAndReturnPriceEqualsOneHundred()
    {
        PurchasedItem item = new PurchasedItem();
        Assertions.assertEquals(100, item.getPrice());
    }

    @Test
    public void createItemWithProperValues()
    {
        PurchasedItem item = new PurchasedItem(Product.BREAD, 50, 200, "item");
        Assertions.assertEquals(50, item.getWeight());
        Assertions.assertEquals(200, item.getPrice());
    }

    @Test
    public void tryToCreateItemWithNotProperWeightAndSetDefaultWeight()
    {
        PurchasedItem item = new PurchasedItem(Product.BREAD, 400, 200, "item");
        Assertions.assertEquals(1, item.getWeight());
    }

    @Test
    public void tryToCreateItemWithNotProperPriceAndSetDefaultPrice()
    {
        PurchasedItem item = new PurchasedItem(Product.BREAD, 400, -3, "item");
        Assertions.assertEquals(100, item.getPrice());
    }
}