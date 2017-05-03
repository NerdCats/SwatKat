package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public abstract class JobTask{

    public static final int CLASS_TYPE_FETCH_DELIVERY_MAN_TASK = 1;
    public static final int CLASS_TYPE_PACKAGE_PICKUP_TASK = 2;
    public static final int CLASS_TYPE_DELIVERY_TASK = 3;
    public static final int CLASS_TYPE_SECURE_DELIVERY = 4;

    private String Type;
    private String Name;

    public JobTask(String type, String name) {
        Name = name;
        Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public abstract Location getLocation();
    public abstract String getId();
    public abstract String getAssetRefId();

    @Override
    public String toString() {
        return "JobTask{" +
                "Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
