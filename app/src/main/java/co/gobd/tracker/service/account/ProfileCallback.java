package co.gobd.tracker.service.account;

import co.gobd.tracker.callback.ConnectionCallback;

/**
 * Created by fahad on 10-Apr-16.
 */
public interface ProfileCallback extends ConnectionCallback {

    void onLoadProfileSuccess(String assetId);

    void onLoadProfileFailure();
}
