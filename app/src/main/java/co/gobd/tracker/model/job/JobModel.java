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

    public static final Parcelable.Creator<JobModel> CREATOR
            = new Parcelable.Creator<JobModel>() {
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
    private User JobServedBy;
    private List<JobTask> Tasks;
    private String CreateTime;
    private String ModifiedTime;
    private Boolean ETAFailed;
    private String CompletionTime;
    private String InitiatinTime;
    private String Duration;
    private String PreferredDeliveryTime;
    private String InvoiceId;
    private String PaymentMethod;
    private String CancellationReason;
    private Boolean Deleted;
    private String PaymentStatus;
    private String HRID;
    private String Id;

    public JobModel(){

    }

    private JobModel(Parcel in) {
        Name = in.readString();
        State = in.readString();
        Order = in.readParcelable(Location.class.getClassLoader());
        User = in.readParcelable(User.class.getClassLoader());
        JobServedBy = in.readParcelable(User.class.getClassLoader());
        Tasks = new ArrayList<>();
        in.readTypedList(Tasks, JobTask.CREATOR);
        CreateTime = in.readString();
        ModifiedTime = in.readString();
        ETAFailed = (Boolean) in.readValue(Boolean.class.getClassLoader());
        CompletionTime = in.readString();
        InitiatinTime = in.readString();
        Duration = in.readString();
        PreferredDeliveryTime = in.readString();
        InvoiceId = in.readString();
        PaymentMethod = in.readString();
        CancellationReason = in.readString();
        Deleted = (Boolean) in.readValue(Boolean.class.getClassLoader());
        PaymentStatus = in.readString();
        HRID = in.readString();
        Id = in.readString();
    }

    public JobModel(String name, String state, Order order,
                    User user, User jobServedBy, List<JobTask> tasks,
                    String createTime, String modifiedTime, Boolean etaFailed, String completionTime,
                    String initiatinTime, String duration, String preferredDeliveryTime,
                    String invoiceId, String paymentMethod, String cancellationReason, Boolean deleted, String paymentStatus,
                    String HRID, String id) {

        Name = name;
        State = state;
        Order = order;
        User = user;
        JobServedBy = jobServedBy;
        Tasks = tasks;
        CreateTime = createTime;
        ModifiedTime = modifiedTime;
        ETAFailed = etaFailed;
        CompletionTime = completionTime;
        InitiatinTime = initiatinTime;
        Duration = duration;
        PreferredDeliveryTime = preferredDeliveryTime;
        InvoiceId = invoiceId;
        PaymentMethod = paymentMethod;
        CancellationReason = cancellationReason;
        Deleted = deleted;
        PaymentStatus = paymentStatus;
        this.HRID = HRID;
        Id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(State);
        dest.writeParcelable(Order, flags);
        dest.writeParcelable(User, flags);
        dest.writeParcelable(JobServedBy, flags);
        dest.writeTypedList(Tasks);
        dest.writeString(CreateTime);
        dest.writeString(ModifiedTime);
        dest.writeValue(ETAFailed);
        dest.writeString(CompletionTime);
        dest.writeString(InitiatinTime);
        dest.writeString(Duration);
        dest.writeString(PreferredDeliveryTime);
        dest.writeString(InvoiceId);
        dest.writeString(PaymentMethod);
        dest.writeString(CancellationReason);
        dest.writeValue(Deleted);
        dest.writeString(PaymentStatus);
        dest.writeString(HRID);
        dest.writeString(Id);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public User getJobServedBy() {
        return JobServedBy;
    }

    public void setJobServedBy(User jobServedBy) {
        JobServedBy = jobServedBy;
    }

    public List<JobTask> getTasks() {
        return Tasks;
    }

    public void setTasks(List<JobTask> Tasks) {
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

    public Boolean getETAFailed(){
        return ETAFailed;
    }

    void setETAFailed(Boolean etaFailed){
        ETAFailed = etaFailed;
    }

    public String getCompletionTime() {
        return CompletionTime;
    }

    public void setCompletionTime(String completionTime) {
        CompletionTime = completionTime;
    }

    public String getInitiatinTime() {
        return InitiatinTime;
    }

    public void setInitiatinTime(String initiatinTime) {
        InitiatinTime = initiatinTime;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getCancellationReason() {
        return CancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        CancellationReason = cancellationReason;
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

}
