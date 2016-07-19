package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fahad on 4/25/16.
 */
public class Location implements Parcelable {

    public static final Parcelable.Creator<Location> CREATOR
            = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    private Point point;
    private String Address;
    private String locality;

    public Location(Point point, String address, String locality) {
        this.point = point;
        Address = address;
        this.locality = locality;
    }

    private Location(Parcel in) {
        point = in.readParcelable(Point.class.getClassLoader());
        Address = in.readString();
        locality = in.readString();
    }

    public co.gobd.tracker.model.job.Point getPoint() {
        return point;
    }

    public void setPoint(co.gobd.tracker.model.job.Point point) {
        this.point = point;
    }

    public String getAddress() {
        return Address;
    }

    public String getLocality(){
        return locality;
    }

    public void setLocality(String locality){
        this.locality = locality;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "point=" + point +
                ", Address='" + Address + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeParcelable(point, flags);
        dest.writeString(Address);
        dest.writeString(locality);
    }
}
