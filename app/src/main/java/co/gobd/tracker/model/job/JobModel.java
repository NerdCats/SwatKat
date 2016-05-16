package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.model.job.order.Order;
import co.gobd.tracker.model.job.task.JobTask;

/**
 * Created by fahad on 4/25/16.
 */
public class JobModel implements Parcelable {

    public static final Parcelable.Creator<JobModel> CREATOR = new Parcelable.Creator<JobModel>(){

        @Override
        public JobModel createFromParcel(Parcel source) {
            return new JobModel(source);
        }

        @Override
        public JobModel[] newArray(int size) {
            return new JobModel[size];
        }
    };
    private String Name;
    private String State;
    private Order Order;
    private User User;
    private String CreateTime;
    private String ModifiedTime;
    private String PreferredDeliveryTime;
    private String InvoiceId;
    private String PaymentMethod;
    private Boolean Deleted;
    private String PaymentStatus;
    private String HRID;
    private String Id;


    /*public JobModel(String name, String state, List<JobTask> tasks) {
        super();
        Name = name;
        State = state;
        Tasks = tasks;
    }*/
    private List<JobTask> Tasks;

    public JobModel(List<JobTask> tasks, String id, String HRID, String paymentStatus, Boolean deleted, String paymentMethod, String invoiceId, String preferredDeliveryTime, String modifiedTime, String createTime, co.gobd.tracker.model.job.User user, co.gobd.tracker.model.job.order.Order order, String state, String name) {
        Tasks = tasks;
        Id = id;
        this.HRID = HRID;
        PaymentStatus = paymentStatus;
        Deleted = deleted;
        PaymentMethod = paymentMethod;
        InvoiceId = invoiceId;
        PreferredDeliveryTime = preferredDeliveryTime;
        ModifiedTime = modifiedTime;
        CreateTime = createTime;
        User = user;
        Order = order;
        State = state;
        Name = name;
    }


    protected JobModel(Parcel in){
        super();
        this.Name = in.readString();
        this.setTasks(new ArrayList<JobTask>());
        in.readTypedList(getTasks(), JobTask.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(getName());
        dest.writeTypedList(getTasks());
    }

    public String getName(){
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState(){
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public List<JobTask> getTasks(){
        return Tasks;
    }

    public void setTasks(List<JobTask> Tasks){
        this.Tasks = Tasks;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHRID() {
        return HRID;
    }

    public void setHRID(String HRID) {
        this.HRID = HRID;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public Boolean getDeleted() {
        return Deleted;
    }

    public void setDeleted(Boolean deleted) {
        Deleted = deleted;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        InvoiceId = invoiceId;
    }

    public String getPreferredDeliveryTime() {
        return PreferredDeliveryTime;
    }

    public void setPreferredDeliveryTime(String preferredDeliveryTime) {
        PreferredDeliveryTime = preferredDeliveryTime;
    }

    public String getModifiedTime() {
        return ModifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        ModifiedTime = modifiedTime;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public co.gobd.tracker.model.job.User getUser() {
        return User;
    }

    public void setUser(co.gobd.tracker.model.job.User user) {
        User = user;
    }

    public co.gobd.tracker.model.job.order.Order getOrder() {
        return Order;
    }

    public void setOrder(co.gobd.tracker.model.job.order.Order order) {
        Order = order;
    }

    @Override
    public String toString() {
        return "JobModel{" +
                "Name='" + Name + '\'' +
                ", State='" + State + '\'' +
                ", Tasks=" + Tasks +
                '}';
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

}
