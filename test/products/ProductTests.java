package products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTests
{
    @Test
    public void getProperString()
    {
        Assertions.assertEquals("Bread", Product.getString(Product.BREAD));
        Assertions.assertEquals("Milk", Product.getString(Product.MILK));
    }

}