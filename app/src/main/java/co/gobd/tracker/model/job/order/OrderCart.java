package co.gobd.tracker.model.job.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahad on 5/16/16.
 */
public class OrderCart {

    private List<PackageList> PackageList = new ArrayList<PackageList>();
    private Double TotalVATAmount;
    private Double SubTotal;
    private Double ServiceCharge;
    private Double TotalWeight;
    private Double TotalToPay;

    public OrderCart(List<PackageList> packageList, Double totalVATAmount, Double subTotal,
                     Double serviceCharge, Double totalWeight, Double totalToPay) {
        PackageList = packageList;
        TotalVATAmount = totalVATAmount;
        SubTotal = subTotal;
        ServiceCharge = serviceCharge;
        TotalWeight = totalWeight;
        TotalToPay = totalToPay;
    }

    /**
     *
     * @return
     *     The PackageList
     */
    public List<PackageList> getPackageList() {
        return PackageList;
    }

    /**
     *
     * @param PackageList
     *     The PackageList
     */
    public void setPackageList(List<PackageList> PackageList) {
        this.PackageList = PackageList;
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

