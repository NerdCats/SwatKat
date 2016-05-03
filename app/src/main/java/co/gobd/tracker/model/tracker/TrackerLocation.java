package co.gobd.tracker.model.tracker;


/**
 * Created by tonmoy on 23-Feb-16.
 */
public class TrackerLocation {

    private Location point;
    private String asset_id;
    private String name;

    public TrackerLocation(Location location, String asset_id, String name) {
        this.point = location;
        this.asset_id = asset_id;
        this.name = name;

    }

    public Location getPoint() {
        return point;
    }

    public void setPoint(Location point) {
        this.point = point;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
