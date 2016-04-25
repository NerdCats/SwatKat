package co.gobd.tracker.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.gobd.tracker.R;
import co.gobd.tracker.ui.fragment.MapFragment;

public class JobActivity extends AppCompatActivity {

    private static final String FRAGMENET_TAG_MAP = "MAP_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        MapFragment mapFragment = new MapFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_job, mapFragment, FRAGMENET_TAG_MAP)
                .commit();


    }
}
