public class companyProduct {

    private int productPicture;
    private String productPrice;
    private String productName;

    public companyProduct(int productPicture, String productName, String productPrice) {
        this.productPicture = productPicture;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductPicture(){
        return productPicture;
    }

    public String getProductPrice(){
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }
}
