package co.gobd.tracker.callback;

/**
 * Created by fahad on 10-Apr-16.
 */
public interface ProfileCallback extends ConnectionCallback {

    void onLoadProfileSuccess(String assetId);
    void onLoadProfileFailure();
}
