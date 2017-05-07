package co.gobd.tracker.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mr. Maps on 5/4/2017.
 */

public class TaskStatusv2 extends RealmObject {

    @PrimaryKey
    private String TaskId;
    private Boolean State=true;

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public Boolean getState() {
        return State;
    }



    public void setState(Boolean state) {
        State = state;
    }

}
