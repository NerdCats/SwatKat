package co.gobd.tracker.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.gobd.tracker.R;
import co.gobd.tracker.model.job.order.OrderCart;
import co.gobd.tracker.model.job.order.PackageList;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.ListViewHelper;

public class JobDetailsActivity extends AppCompatActivity {

    @BindView(R.id.lv_package_list)
    ListView lvPackageList;

    @BindView(R.id.cv_jobmodel)
    CardView cvJobmodel;

    @BindView(R.id.tv_title_note)
    TextView tvTitleNote;

    @BindView(R.id.tv_note_to_delivery)
    TextView tvNoteToDelivery;

    @BindView(R.id.tv_pickup_address)
    TextView tvPickupAddress;

    @BindView(R.id.tv_delivery_address)
    TextView tvDeliveryAddress;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_package_description)
    TextView tvPackageDescription;

    ListAdapter adapter;
    List<String> packageLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        ButterKnife.bind(this);

        packageLists = new ArrayList<>();


        Bundle bundle = getIntent().getExtras();
        setupToolBar();

        updateToolBarTitle(bundle);

        updatePackageList(bundle);

        updateNote(bundle);

        updatePickupAddress(bundle);

        updateDeliveryAddress(bundle);

        updatePackageDescription(bundle);

    }

    public void updatePackageDescription(Bundle extras) {
        if (extras != null) {
            tvPackageDescription.setText(extras.getString(Constant.Job.PACKAGE_DESCRIPTION));
        }
    }

    public void updateToolBarTitle(Bundle extras) {
        if (extras != null) {
            String jobHrid = extras.getString(Constant.Job.JOB_HRID);
            toolbar.setTitle(jobHrid);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setupToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    public void updatePickupAddress(Bundle extras) {
        if (extras != null) {
            String address = extras.getString(Constant.Job.PICKUP_ADDRESS);
            tvPickupAddress.setText(address);
        }
    }

    public void updateDeliveryAddress(Bundle extras) {
        if (extras != null) {
            String address = extras.getString(Constant.Job.DELIVERY_ADDRESS);
            tvDeliveryAddress.setText(address);
        }
    }

    public void updateNote(Bundle extras) {
        if (extras != null) {
            String note = extras.getString(Constant.Job.NOTE_TO_DELIVERY_MAN);
            tvNoteToDelivery.setText(note);
        }

    }

    public void updatePackageList(Bundle extras) {
        if (extras != null) {
            OrderCart cart = (OrderCart) extras.get(Constant.Job.ORDER_CART);
            if (cart != null) {
                for (PackageList item : cart.getListofPackageList()) {
                    String itemName = item.getItem();
                    packageLists.add(itemName);
                }
            }
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, packageLists);
        lvPackageList.setAdapter(adapter);
        ListViewHelper.getListViewSize(lvPackageList);
    }
}
