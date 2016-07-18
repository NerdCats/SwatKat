package co.gobd.tracker.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
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

    ListAdapter adapter;

    List<String> packageLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        ButterKnife.bind(this);

        packageLists = new ArrayList<>();

        getPackageList(getIntent().getExtras());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, packageLists);
        lvPackageList.setAdapter(adapter);
        ListViewHelper.getListViewSize(lvPackageList);


    }

    public void getPackageList(Bundle bundle) {
        if (bundle != null) {
            OrderCart cart = (OrderCart) bundle.get(Constant.Job.ORDER_CART);
            if (cart != null) {
                for (PackageList item : cart.getListofPackageList()) {
                    String itemName = item.getItem();
                    packageLists.add(itemName);
                }
            }
        }
    }
}
