package co.gobd.tracker.model.job.order;

/**
 * Created by fahad on 5/16/16.
 */
public class PackageList {

    private String Item;
    private Integer Quantity;
    private Double Price;
    private Double VAT;
    private Double Total;
    private Double VATAmount;
    private Double TotalPlusVAT;
    private Double Weight;

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
