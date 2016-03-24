package co.gobd.tracker.model.tracker;



/**
 * Created by tonmoy on 23-Feb-16.
 */
public class TrackerLocation {
    private Location location;
    private String name;
    private String user_id;

    public TrackerLocation(Location location, String name, String user_id) {
        this.location = location;
        this.name = name;
        this.user_id = user_id;

    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "TrackerLocation [location = " + location + ", name = " + name + ", user_id = " + user_id + "]";
    }
}
