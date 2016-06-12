package co.gobd.tracker.model.job.order;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fahad on 5/16/16.
 */
public class PackageList implements Parcelable {

    private String Item;
    private Integer Quantity;
    private Double Price;
    private Double VAT;
    private Double Total;
    private Double VATAmount;
    private Double TotalPlusVAT;
    private Double Weight;

    public PackageList(String item, Integer quantity, Double price, Double VAT, Double total, Double VATAmount, Double totalPlusVAT, Double weight) {
        Item = item;
        Quantity = quantity;
        Price = price;
        this.VAT = VAT;
        Total = total;
        this.VATAmount = VATAmount;
        TotalPlusVAT = totalPlusVAT;
        Weight = weight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(Item);
        dest.writeInt(Quantity);
        dest.writeDouble(Price);
        dest.writeDouble(VAT);
        dest.writeDouble(Total);
        dest.writeDouble(VATAmount);
        dest.writeDouble(TotalPlusVAT);
        dest.writeDouble(Weight);
    }

    private PackageList(Parcel in){
        Item = in.readString();
        Quantity = in.readInt();
        Price = in.readDouble();
        VAT = in.readDouble();
        Total = in.readDouble();
        VATAmount = in.readDouble();
        TotalPlusVAT = in.readDouble();
        Weight = in.readDouble();
    }

    public static final Parcelable.Creator<PackageList> CREATOR
            = new Parcelable.Creator<PackageList>(){

        @Override
        public PackageList createFromParcel(Parcel source) {
            return new PackageList(source);
        }

        @Override
        public PackageList[] newArray(int size) {
            return new PackageList[size];
        }
    };

    /**
     *
     * @return
     *     The Item
     */
    public String getItem() {
        return Item;
    }

    /**
     *
     * @param Item
     *     The Item
     */
    public void setItem(String Item) {
        this.Item = Item;
    }

    /**
     *
     * @return
     *     The Quantity
     */
    public Integer getQuantity() {
        return Quantity;
    }

    /**
     *
     * @param Quantity
     *     The Quantity
     */
    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    /**
     *
     * @return
     *     The Price
     */
    public Double getPrice() {
        return Price;
    }

    /**
     *
     * @param Price
     *     The Price
     */
    public void setPrice(Double Price) {
        this.Price = Price;
    }

    /**
     *
     * @return
     *     The VAT
     */
    public Double getVAT() {
        return VAT;
    }

    /**
     *
     * @param VAT
     *     The VAT
     */
    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    /**
     *
     * @return
     *     The Total
     */
    public Double getTotal() {
        return Total;
    }

    /**
     *
     * @param Total
     *     The Total
     */
    public void setTotal(Double Total) {
        this.Total = Total;
    }

    /**
     *
     * @return
     *     The VATAmount
     */
    public Double getVATAmount() {
        return VATAmount;
    }

    /**
     *
     * @param VATAmount
     *     The VATAmount
     */
    public void setVATAmount(Double VATAmount) {
        this.VATAmount = VATAmount;
    }

    /**
     *
     * @return
     *     The TotalPlusVAT
     */
    public Double getTotalPlusVAT() {
        return TotalPlusVAT;
    }

    /**
     *
     * @param TotalPlusVAT
     *     The TotalPlusVAT
     */
    public void setTotalPlusVAT(Double TotalPlusVAT) {
        this.TotalPlusVAT = TotalPlusVAT;
    }

    /**
     *
     * @return
     *     The Weight
     */
    public Double getWeight() {
        return Weight;
    }

    /**
     *
     * @param Weight
     *     The Weight
     */
    public void setWeight(Double Weight) {
        this.Weight = Weight;
    }

}
