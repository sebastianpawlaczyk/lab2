package products;

public enum Product
{
    BREAD,
    MILK,
    TEA,
    BUTTER,
    OTHER;

    public static String getString(Product product)
    {
        switch (product)
        {
            case BREAD : return "Bread";
            case MILK : return "Milk";
            case TEA : return "Tea";
            case BUTTER : return "Butter";
            default : return "Other";
        }
    }
}
