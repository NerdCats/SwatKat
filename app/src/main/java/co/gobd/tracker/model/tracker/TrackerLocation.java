package co.gobd.tracker.model.tracker;


import com.google.gson.Gson;

/**
 * Created by tonmoy on 23-Feb-16.
 */
public class TrackerLocation {

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

    private Location point;
    private String asset_id;

    public TrackerLocation(Location location, String asset_id) {
        this.point = location;
        this.asset_id = asset_id;

    }




    @Override
    public String toString() {

        Gson iamgonnakilltareq = new Gson();

        String killtareq = iamgonnakilltareq.toJson(this);

        return killtareq;
    }
}
