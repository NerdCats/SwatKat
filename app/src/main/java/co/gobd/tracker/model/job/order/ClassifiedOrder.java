package co.gobd.tracker.model.job.order;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 10/25/16.
 */

public class ClassifiedOrder extends Order {

    private SellerInfo sellerInfo;
    private BuyerInfo buyerInfo;

    public ClassifiedOrder(Location from, Location to, String description,
                           OrderCart orderCart, String noteToDeliveryMan, String type,
                           String variant, String userId, Double RequiredChangeFor,
                           String paymentMethod, SellerInfo sellerInfo,
                           BuyerInfo buyerInfo) {

        super(from, to, description, orderCart, noteToDeliveryMan, type, variant, userId, RequiredChangeFor, paymentMethod);
        this.sellerInfo = sellerInfo;
        this.buyerInfo = buyerInfo;
    }

    public SellerInfo getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(SellerInfo sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public BuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    public void setBuyerInfo(BuyerInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
    }
}
