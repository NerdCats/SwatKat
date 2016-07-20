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
    private Point Point;
    private String Address;
    private String Locality;

    public Location(Point point, String address, String locality) {
        this.Point = point;
        Address = address;
        this.Locality = locality;
    }

    private Location(Parcel in) {
        Point = in.readParcelable(Point.class.getClassLoader());
        Address = in.readString();
        Locality = in.readString();
    }

    public co.gobd.tracker.model.job.Point getPoint() {
        return Point;
    }

    public void setPoint(co.gobd.tracker.model.job.Point point) {
        this.Point = point;
    }

    public String getAddress() {
        return Address;
    }

    public String getLocality(){
        return Locality;
    }

    public void setLocality(String locality){
        this.Locality = locality;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "point=" + Point +
                ", Address='" + Address + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeParcelable(Point, flags);
        dest.writeString(Address);
        dest.writeString(Locality);
    }
}
