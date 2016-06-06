package co.gobd.tracker.model.job.order;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahad on 5/16/16.
 */
public class OrderCart implements Parcelable {

    private List<PackageList> ListofPackageList = new ArrayList<>();
    private Double TotalVATAmount;
    private Double SubTotal;
    private Double ServiceCharge;
    private Double TotalWeight;
    private Double TotalToPay;

    public OrderCart(List<PackageList> packageList, Double totalVATAmount, Double subTotal,
                     Double serviceCharge, Double totalWeight, Double totalToPay) {
        ListofPackageList = packageList;
        TotalVATAmount = totalVATAmount;
        SubTotal = subTotal;
        ServiceCharge = serviceCharge;
        TotalWeight = totalWeight;
        TotalToPay = totalToPay;
    }

    private OrderCart(Parcel in){
        in.readTypedList(ListofPackageList, PackageList.CREATOR);
        TotalVATAmount = in.readDouble();
        SubTotal = in.readDouble();
        ServiceCharge = in.readDouble();
        TotalWeight = in.readDouble();
        TotalToPay = in.readDouble();
    }

    public static final Parcelable.Creator<OrderCart> CREATOR
            = new Parcelable.Creator<OrderCart>(){

        @Override
        public OrderCart createFromParcel(Parcel source) {
            return new OrderCart(source);
        }

        @Override
        public OrderCart[] newArray(int size) {
            return new OrderCart[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeTypedList(ListofPackageList);
        dest.writeDouble(TotalVATAmount);
        dest.writeDouble(SubTotal);
        dest.writeDouble(ServiceCharge);
        dest.writeDouble(TotalWeight);
        dest.writeDouble(TotalToPay);

    }


    /**
     *
     * @return
     *     The ListofPackageList
     */
    public List<PackageList> getListofPackageList() {
        return ListofPackageList;
    }

    /**
     *
     * @param PackageList
     *     The ListofPackageList
     */
    public void setListofPackageList(List<PackageList> PackageList) {
        this.ListofPackageList = PackageList;
    }

    /**
     *
     * @return
     *     The TotalVATAmount
     */
    public Double getTotalVATAmount() {
        return TotalVATAmount;
    }

    /**
     *
     * @param TotalVATAmount
     *     The TotalVATAmount
     */
    public void setTotalVATAmount(Double TotalVATAmount) {
        this.TotalVATAmount = TotalVATAmount;
    }

    /**
     *
     * @return
     *     The SubTotal
     */
    public Double getSubTotal() {
        return SubTotal;
    }

    /**
     *
     * @param SubTotal
     *     The SubTotal
     */
    public void setSubTotal(Double SubTotal) {
        this.SubTotal = SubTotal;
    }

    /**
     *
     * @return
     *     The ServiceCharge
     */
    public Double getServiceCharge() {
        return ServiceCharge;
    }

    /**
     *
     * @param ServiceCharge
     *     The ServiceCharge
     */
    public void setServiceCharge(Double ServiceCharge) {
        this.ServiceCharge = ServiceCharge;
    }

    /**
     *
     * @return
     *     The TotalWeight
     */
    public Double getTotalWeight() {
        return TotalWeight;
    }

    /**
     *
     * @param TotalWeight
     *     The TotalWeight
     */
    public void setTotalWeight(Double TotalWeight) {
        this.TotalWeight = TotalWeight;
    }

    /**
     *
     * @return
     *     The TotalToPay
     */
    public Double getTotalToPay() {
        return TotalToPay;
    }

    /**
     *
     * @param TotalToPay
     *     The TotalToPay
     */
    public void setTotalToPay(Double TotalToPay) {
        this.TotalToPay = TotalToPay;
    }


}

