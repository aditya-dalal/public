package temp;

/**
 * Created by aditya.dalal on 28/05/15.
 */
public class Product {
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int rank;

    public String getProductScore() {
        return productScore;
    }

    public void setProductScore(String productScore) {
        this.productScore = productScore;
    }

    public String productScore;

    public Product(int rank, String productScore) {
        this.rank = rank;
        this.productScore = productScore;
    }
}
