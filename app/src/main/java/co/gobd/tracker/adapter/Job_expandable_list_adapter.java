package co.gobd.tracker.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.ISODateTimeFormat;

import java.util.List;

import co.gobd.tracker.R;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.job.order.PackageList;

/**
 * Created by Mr. Maps on 4/23/2017.
 */

public class Job_expandable_list_adapter extends BaseExpandableListAdapter {

    private Context context;
    private List<JobModel> jobModelList;
    String PersonName,contact, Invoice,Area,items,NoteforAsset,Tasktypefrommain,address, seller;

    StringBuilder s;
    int days,count;
    public Job_expandable_list_adapter(Context context,String task) {
        this.context = context;
        this.Tasktypefrommain=task;
    }
    public void setAdapterData(List<JobModel> jobModelList) {
        this.jobModelList = jobModelList;
        notifyDataSetChanged();
    }
    public List<JobModel> getAdapterData() {
        return jobModelList;
    }
    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.jobModelList.get(listPosition);

    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
convertView=null;
        if (expandedListPosition == 0) {
              Invoice = jobModelList.get(listPosition).getOrder().getReferenceInvoice();
            if (Invoice == null) {
                Invoice="Not Applicable";
            }
                if (convertView == null) {
                    LayoutInflater layoutInflater = (LayoutInflater) this.context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = layoutInflater.inflate(R.layout.job_details_with_icon, null);
                }
                TextView expandedListTextView = (TextView) convertView
                        .findViewById(R.id.child_list_item_job_date_text_view);
                ImageView icon = (ImageView) convertView.findViewById(R.id.child_icon);
                icon.setImageResource(R.drawable.invoice);
                expandedListTextView.setText(Invoice);


            }

        if (expandedListPosition == 1) {

            if(Tasktypefrommain.equals("PackagePickUp"))
            {
                 address = (jobModelList.get(listPosition).getTasks().get(1).getLocation().getAddress()).replace('\n',' ');
            }
             else address = (jobModelList.get(listPosition).getTasks().get(count-1).getLocation().getAddress()).replace('\n',' ');
            //Pattern wikiWordMatcher = Pattern.compile("^(?:\\+?88)?01[15-9]\\d{8}$");





            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.job_details_with_icon, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.child_list_item_job_date_text_view);
            ImageView icon=(ImageView)convertView.findViewById(R.id.child_icon);
            icon.setImageResource(R.drawable.house);
            expandedListTextView.setText(address);
            convertView.setTag(contact);

        }
        if (expandedListPosition == 2) {
            final List<PackageList> Itemlist = jobModelList.get(listPosition).getOrder().getOrderCart().getListofPackageList();
            int Size=Itemlist.size();
            if(Size>1)
            {
                items=null;
                s = new StringBuilder(100);
                for(int i=0;i<Size;i++)
                {
                    String joiningitems=Itemlist.get(i).getItem();

                    s.append(joiningitems);

                }
                items=s.toString();
            }
            else
               items=Itemlist.get(0).getItem();
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.job_details_with_icon, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.child_list_item_job_date_text_view);
            ImageView icon=(ImageView)convertView.findViewById(R.id.child_icon);
            icon.setImageResource(R.drawable.box);
            expandedListTextView.setText(items);

        }
        if (expandedListPosition == 3) {
            final String price = jobModelList.get(listPosition).getOrder().getOrderCart().getTotalToPay().toString().concat(" taka");

            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.job_details_with_icon, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.child_list_item_job_date_text_view);
            ImageView icon=(ImageView)convertView.findViewById(R.id.child_icon);
            icon.setImageResource(R.drawable.taka2);
            expandedListTextView.setText(price);


        }
        if (expandedListPosition == 4) {
            try {
                NoteforAsset = jobModelList.get(listPosition).getOrder().getNoteToDeliveryMan();
                if (TextUtils.isEmpty(NoteforAsset))
                    NoteforAsset = "No notes provided";

                if (convertView == null) {
                    LayoutInflater layoutInflater = (LayoutInflater) this.context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = layoutInflater.inflate(R.layout.job_details_with_icon, null);
                }
                TextView expandedListTextView = (TextView) convertView
                        .findViewById(R.id.child_list_item_job_date_text_view);
                ImageView icon = (ImageView) convertView.findViewById(R.id.child_icon);
                icon.setImageResource(R.drawable.notepad);
                expandedListTextView.setText(NoteforAsset);

            } catch (Exception e) {

            }

        }
        if (expandedListPosition == 5) {


            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.job_details_text, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.child_list_item_job_date_text_view);

            expandedListTextView.setText("Update Task");
            convertView.setTag(listPosition);

        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {

        return 6;
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.jobModelList.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.jobModelList.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        convertView=null;
        days=0;
        String listTitle = jobModelList.get(listPosition).getHRID();
        String timestampfromjob =jobModelList.get(listPosition).getTime();
        DateTime currentDate=new DateTime();

        DateTime dateTime = ISODateTimeFormat.dateTimeParser().parseDateTime(timestampfromjob);

        long diffInMillis = currentDate.getMillis() - dateTime.getMillis();
        days = (int) (diffInMillis / (1000*60*60*24));
        PersonName=null;
        Area=null;
if(Tasktypefrommain.equals("PackagePickUp")) {

    boolean exists = jobModelList.get(listPosition).getOrder().hasSellerInfo();
    if (exists) {
        PersonName = jobModelList.get(listPosition).getOrder().getSellerInfo().getName();


    } else {
        PersonName = jobModelList.get(listPosition).getUser().getUserName();

    }
    Area = jobModelList.get(listPosition).getTasks().get(1).getLocation().getLocality();
}
else {
    boolean exists = jobModelList.get(listPosition).getOrder().hasBuyerInfo();
    if (exists) {
        PersonName = jobModelList.get(listPosition).getOrder().getBuyerInfo().getName();

        try{
             seller=jobModelList.get(listPosition).getOrder().getSellerInfo().getName();
        }catch (Exception e)
        {

        }

        PersonName=PersonName.concat(" ( "+seller+" )");

    } else {
        String[] all=jobModelList.get(listPosition).getOrder().getTo().getAddress().split(",");
        PersonName = all[0];

    }
     count=jobModelList.get(listPosition).getTasks().size();
    Area = jobModelList.get(listPosition).getTasks().get(count-1).getLocation().getLocality();
}
        if (convertView == null) {

           convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.job_parent, parent, false);        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.parent_list_item_job_title);
        TextView ContactPerson = (TextView) convertView
                .findViewById(R.id.parent_list_item_job_pickupfrom);
        TextView Areaplace = (TextView) convertView
                .findViewById(R.id.parent_list_item_job_pickupcontact);
        ImageView flag=(ImageView)convertView.findViewById(R.id.parent_list_item_flag);
        flag.setImageResource(0);
        if(days==0)flag.setImageResource(R.drawable.flaggreen);
        if(days==1)flag.setImageResource(R.drawable.flagyellow);
        if(days>=2)flag.setImageResource(R.drawable.flagred);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        ContactPerson.setText(PersonName);
        Areaplace.setTextColor(Color.parseColor("#D50000"));
        Areaplace.setText(Area);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {

        return true;
    }


}