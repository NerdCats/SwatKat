package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public abstract class JobTask {

    private String Type;
    private String Name;

    public JobTask(String type, String name) {
        Type = type;
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public String getName() {
        return Name;
    }

    public abstract Location getLocation();

    @Override
    public String toString() {
        return "JobTask{" +
                "Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
