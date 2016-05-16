package co.gobd.tracker.model.job.order;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 5/16/16.
 */
public class Order {

    private Location From;
    private Location To;
    private String PackageDescription;
    private OrderCart OrderCart;
    private String NoteToDeliveryMan;
    private String Name;
    private String Type;
    private String PayloadType;
    private String UserId;
    private Object OrderLocation;
    private Object ETA;
    private Double ETAMinutes;
    private String PaymentMethod;

    /**
     *
     * @return
     *     The From
     */
    public Location getFrom() {
        return From;
    }

    /**
     *
     * @param From
     *     The From
     */
    public void setFrom(Location From) {
        this.From = From;
    }

    /**
     *
     * @return
     *     The To
     */
    public Location getTo() {
        return To;
    }

    /**
     *
     * @param To
     *     The To
     */
    public void setTo(Location To) {
        this.To = To;
    }

    /**
     *
     * @return
     *     The PackageDescription
     */
    public String getPackageDescription() {
        return PackageDescription;
    }

    /**
     *
     * @param PackageDescription
     *     The PackageDescription
     */
    public void setPackageDescription(String PackageDescription) {
        this.PackageDescription = PackageDescription;
    }

    /**
     *
     * @return
     *     The OrderCart
     */
    public OrderCart getOrderCart() {
        return OrderCart;
    }

    /**
     *
     * @param OrderCart
     *     The OrderCart
     */
    public void setOrderCart(OrderCart OrderCart) {
        this.OrderCart = OrderCart;
    }

    /**
     *
     * @return
     *     The NoteToDeliveryMan
     */
    public String getNoteToDeliveryMan() {
        return NoteToDeliveryMan;
    }

    /**
     *
     * @param NoteToDeliveryMan
     *     The NoteToDeliveryMan
     */
    public void setNoteToDeliveryMan(String NoteToDeliveryMan) {
        this.NoteToDeliveryMan = NoteToDeliveryMan;
    }

    /**
     *
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     *
     * @param Type
     *     The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     *
     * @return
     *     The PayloadType
     */
    public String getPayloadType() {
        return PayloadType;
    }

    /**
     *
     * @param PayloadType
     *     The PayloadType
     */
    public void setPayloadType(String PayloadType) {
        this.PayloadType = PayloadType;
    }

    /**
     *
     * @return
     *     The UserId
     */
    public String getUserId() {
        return UserId;
    }

    /**
     *
     * @param UserId
     *     The UserId
     */
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    /**
     *
     * @return
     *     The OrderLocation
     */
    public Object getOrderLocation() {
        return OrderLocation;
    }

    /**
     *
     * @param OrderLocation
     *     The OrderLocation
     */
    public void setOrderLocation(Object OrderLocation) {
        this.OrderLocation = OrderLocation;
    }

    /**
     *
     * @return
     *     The ETA
     */
    public Object getETA() {
        return ETA;
    }

    /**
     *
     * @param ETA
     *     The ETA
     */
    public void setETA(Object ETA) {
        this.ETA = ETA;
    }

    /**
     *
     * @return
     *     The ETAMinutes
     */
    public Double getETAMinutes() {
        return ETAMinutes;
    }

    /**
     *
     * @param ETAMinutes
     *     The ETAMinutes
     */
    public void setETAMinutes(Double ETAMinutes) {
        this.ETAMinutes = ETAMinutes;
    }

    /**
     *
     * @return
     *     The PaymentMethod
     */
    public String getPaymentMethod() {
        return PaymentMethod;
    }

    /**
     *
     * @param PaymentMethod
     *     The PaymentMethod
     */
    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

}

