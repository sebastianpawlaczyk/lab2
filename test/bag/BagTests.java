package bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import products.Product;
import items.PurchasedItem;

class BagTests
{
    @Test
    public void createBagThenCheckThatWeightAndPriceEqualsZero()
    {
        Bag bag = new Bag();
        Assertions.assertEquals(0, bag.getTotalPrice());
        Assertions.assertEquals(0, bag.getTotalWeight());
    }

    @Test
    public void putItemToBagAndReturnTrue()
    {
        Bag bag = new Bag();
        PurchasedItem item = new PurchasedItem();

        Assertions.assertTrue(bag.putIn(item));
    }

    @Test
    public void tryToPutToManyItemsAndReturnFalse()
    {
        Bag bag = new Bag(2, 40);
        PurchasedItem item = new PurchasedItem();
        PurchasedItem item2 = new PurchasedItem();
        PurchasedItem item3 = new PurchasedItem();

        Assertions.assertTrue(bag.putIn(item));
        Assertions.assertTrue(bag.putIn(item2));
        Assertions.assertFalse(bag.putIn(item3));
    }

    @Test
    public void tryToPutArrayOfItemsAndReturnTrue()
    {
        Bag bag = new Bag(4, 40);
        PurchasedItem item1 = new PurchasedItem();
        PurchasedItem item2 = new PurchasedItem();
        PurchasedItem item3 = new PurchasedItem();
        PurchasedItem item4 = new PurchasedItem();;

        PurchasedItem[] items = {item1, item2, item3, item4};

        Assertions.assertTrue(bag.putIn(items));
    }

    @Test
    public void tryToPutToBigArrayOfItemsAndReturnFalse()
    {
        Bag bag = new Bag(4, 40);
        PurchasedItem item1 = new PurchasedItem();
        PurchasedItem item2 = new PurchasedItem();
        PurchasedItem item3 = new PurchasedItem();
        PurchasedItem item4 = new PurchasedItem();;
        PurchasedItem item5 = new PurchasedItem();;

        PurchasedItem[] items = {item1, item2, item3, item4, item5};

        Assertions.assertFalse(bag.putIn(items));
    }

    @Test
    public void tryToPutTooHeavyItemAndReturnFalse()
    {
        Bag bag = new Bag(4, 40);
        PurchasedItem item1 = new PurchasedItem(Product.BREAD, 30, 50, "item1");
        PurchasedItem item2 = new PurchasedItem(Product.MILK, 12, 50, "item2");

        Assertions.assertTrue(bag.putIn(item1));
        Assertions.assertFalse(bag.putIn(item2));
    }

    @Test
    public void fillBagAndGetProperTotalPriceAndTotalWeight()
    {
        Bag bag = new Bag(4, 40);
        PurchasedItem item1 = new PurchasedItem(Product.BREAD, 1, 50, "item1");
        PurchasedItem item2 = new PurchasedItem(Product.MILK, 2, 40, "item2");
        PurchasedItem item3 = new PurchasedItem(Product.TEA, 2, 60, "item3");

        PurchasedItem[] items = {item1, item2, item3};

        bag.putIn(items);
        Assertions.assertEquals(150, bag.getTotalPrice());
        Assertions.assertEquals(5, bag.getTotalWeight());
    }

    @Test
    public void fillWholeBagThenRemoveItemsAndTryToPutAgain()
    {
        Bag bag = new Bag(1, 40);
        PurchasedItem item1 = new PurchasedItem(Product.BREAD, 1, 50, "item1");
        PurchasedItem item2 = new PurchasedItem(Product.MILK, 2, 40, "item2");

        bag.putIn(item1);
        bag.makeEmpty();
        Assertions.assertTrue(bag.putIn(item2));
    }
}