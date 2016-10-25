package co.gobd.tracker.model.job;

import java.util.List;

import co.gobd.tracker.model.job.order.Order;
import co.gobd.tracker.model.job.task.JobTask;

/**
 * Created by fahad on 4/25/16.
 */
public class JobModel{

    private String Name;
    private String State;
    private Order Order;
    private User User;
    private List<JobTask> Tasks;
    private String PaymentMethod;
    private String PaymentStatus;
    private String HRID;
    private String Id;

    public JobModel(String name, String state, Order order,
                    User user, List<JobTask> tasks,
                    String paymentMethod, String paymentStatus,
                    String HRID, String id) {

        Name = name;
        State = state;
        Order = order;
        User = user;
        Tasks = tasks;
        PaymentMethod = paymentMethod;
        PaymentStatus = paymentStatus;
        this.HRID = HRID;
        Id = id;
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

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
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
