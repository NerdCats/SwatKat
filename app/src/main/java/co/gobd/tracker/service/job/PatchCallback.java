package co.gobd.tracker.service.job;

import co.gobd.tracker.callback.ConnectionCallback;

/**
 * Created by fahadwajed on 7/14/16.
 */
public interface PatchCallback extends ConnectionCallback {

    void onPatchSuccess();
    void onPatchFailure();
}
