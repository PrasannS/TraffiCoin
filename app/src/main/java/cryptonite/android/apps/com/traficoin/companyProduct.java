package cryptonite.android.apps.com.traficoin;

public class companyProduct {

    private int productPicture;
    private int productPrice;
    private String productName;

    public companyProduct(int productPicture, String productName, int productPrice) {
        this.productPicture = productPicture;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductPicture(){
        return productPicture;
    }

    public int getProductPrice(){
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }
}
