package co.gobd.tracker.callback;

/**
 * Created by fahad on 10-Apr-16.
 */
public interface TokenCallback {

    void onTokenSucces(String assetId);
    void onTokenFailure();
}
