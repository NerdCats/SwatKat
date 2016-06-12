package co.gobd.tracker.model.job.order;

import android.os.Parcel;
import android.os.Parcelable;
import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 5/16/16.
 */
public class Order implements Parcelable {

    private Location From;
    private Location To;
    private String Description;
    private OrderCart OrderCart;
    private String NoteToDeliveryMan;
    private String Name;
    private String Type;
    private String PayloadType;
    private String UserId;
    private Location OrderLocation;
    private String ETA;
    private Double ETAMinutes;
    private String PaymentMethod;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeParcelable(From, flags);
        dest.writeParcelable(To, flags);
        dest.writeString(Description);
        dest.writeParcelable(OrderCart, flags);
        dest.writeString(NoteToDeliveryMan);
        dest.writeString(Name);
        dest.writeString(Type);
        dest.writeString(PayloadType);
        dest.writeString(UserId);
        dest.writeParcelable(OrderLocation, flags);
        dest.writeString(ETA);
        dest.writeDouble(ETAMinutes);
        dest.writeString(PaymentMethod);

    }

    private Order(Parcel in){
        From = in.readParcelable(Location.class.getClassLoader());
        To = in.readParcelable(Location.class.getClassLoader());
        Description = in.readString();
        OrderCart = in.readParcelable(OrderCart.class.getClassLoader());
        NoteToDeliveryMan = in.readString();
        Name = in.readString();
        Type = in.readString();
        PayloadType = in.readString();
        UserId = in.readString();
        OrderLocation = in.readParcelable(Location.class.getClassLoader());
        ETA = in.readString();
        ETAMinutes = in.readDouble();
        PaymentMethod = in.readString();
    }

    public static final Parcelable.Creator<Order> CREATOR
            = new Parcelable.Creator<Order>(){
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public Order(Location from, Location to, String description, OrderCart orderCart,
                 String noteToDeliveryMan, String name, String type,
                 String payloadType, String userId, Location orderLocation,
                 String ETA, Double ETAMinutes, String paymentMethod) {

        From = from;
        To = to;
        Description = description;
        OrderCart = orderCart;
        NoteToDeliveryMan = noteToDeliveryMan;
        Name = name;
        Type = type;
        PayloadType = payloadType;
        UserId = userId;
        OrderLocation = orderLocation;
        this.ETA = ETA;
        this.ETAMinutes = ETAMinutes;
        PaymentMethod = paymentMethod;
    }

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
    public String getDescription() {
        return Description;
    }

    /**
     *
     * @param Description
     *     The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
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
    public void setOrderLocation(Location OrderLocation) {
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
    public void setETA(String ETA) {
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

