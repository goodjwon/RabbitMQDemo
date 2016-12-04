import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KW100201 on 2016-11-28.
 */
public class Item implements Serializable {


    private String productKey;
    private String productName;
    private String productExt;

    private String regDate;
    private String uptDate;


    public Item(String productKey, String productName, String productExt) {
        this.productKey = productKey;
        this.productName = productName;
        this.productExt = productExt;
    }

    public String getProductKey() {
        return productKey;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductExt() {
        return productExt;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getUptDate() {
        return uptDate;
    }

    public String setRegDate(){
        return  this.regDate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public String setUptDate(){
        return  this.uptDate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    @Override
    public String toString() {
        return "Item{" +
                "productKey='" + productKey + '\'' +
                ", productName='" + productName + '\'' +
                ", productExt='" + productExt + '\'' +
                ", regDate='" + regDate + '\'' +
                ", uptDate='" + uptDate + '\'' +
                '}';
    }
}
