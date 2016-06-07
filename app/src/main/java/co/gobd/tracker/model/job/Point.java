package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by fahad on 4/25/16.
 */
public class Point implements Parcelable {

    private String type;
    private String[] coordinates = new String[2];

    public Point(String type, String[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    private Point(Parcel in){
        type = in.readString();
        coordinates[0] = in.readString();
        coordinates[1] = in.readString();

    }

    public String getType() {
        return type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public String getLongitude(){
        return coordinates[0];
    }

    public String getLatitude(){
        return coordinates[1];
    }

    @Override
    public String toString() {
        return "Point [type = " + type + ", coordinates = " + Arrays.toString(coordinates) + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(type);
        dest.writeString(getLongitude());
        dest.writeString(getLatitude());

    }

    public static final Parcelable.Creator<Point> CREATOR
            = new Parcelable.Creator<Point>(){


        @Override
        public Point createFromParcel(Parcel source) {
            return new Point(source);
        }

        @Override
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };
}
