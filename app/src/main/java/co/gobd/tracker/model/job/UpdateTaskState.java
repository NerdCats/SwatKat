package co.gobd.tracker.model.job;

/**
 * Created by fahadwajed on 7/14/16.
 */
public class UpdateTaskState {
    private String op;
    private String value;
    private String path;



    public UpdateTaskState(String op, String path, String value) {
        this.op = op;
        this.path = path;
        this.value = value;

    }



    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ClassPojo [op = " + op + ", value = " + value + ", path = " + path + "]";
    }
}