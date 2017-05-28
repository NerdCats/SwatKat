package co.gobd.tracker.controller;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.location.Location;

import co.gobd.tracker.model.TaskStatusv2;
import co.gobd.tracker.model.tracker.LocationMod;
import co.gobd.tracker.model.tracker.LocationModel;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Mr. Maps on 5/4/2017.
 */

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }

    //clear all objects from Book.class
    public void clearAll() {

        realm.beginTransaction();
        realm.clear(TaskStatusv2.class);
        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public RealmResults<LocationMod> getAllLocations() {

        return realm.where(LocationMod.class).distinct("lat","lon");
    }

    //query a single item with the given id
    public TaskStatusv2 getOneStatus(String Taskid) {

        return realm.where(TaskStatusv2.class).equalTo("TaskId", Taskid).findFirst();
    }

    //check if Book.class is empty
    public boolean hasStatus() {

        return !realm.allObjects(TaskStatusv2.class).isEmpty();
    }

    //query example
    public RealmResults<TaskStatusv2> queryedBooks() {

        return realm.where(TaskStatusv2.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();

    }
    public void Updaterow(String id) {
        TaskStatusv2 taskStatus = realm.where(TaskStatusv2.class).equalTo("TaskId", id).findFirst();
        realm.beginTransaction();
       taskStatus.setState(false);
        realm.commitTransaction();



    }
    public boolean checkIfExists(String id){

        RealmResults<TaskStatusv2> query = realm.where(TaskStatusv2.class)
                .equalTo("TaskId", id).findAll();

        return query.size() !=0 ;
    }
}