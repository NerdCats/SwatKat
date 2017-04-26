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

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.gobd.tracker.R;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.job.order.PackageList;

/**
 * Created by Mr. Maps on 4/23/2017.
 */

public class Job_expandable_list_adapter extends BaseExpandableListAdapter {

    private Context context;
    private List<JobModel> jobModelList;
    String PersonName;
    String Area;
  String items,NoteforAsset;
    String contact;
    StringBuilder s;
    public Job_expandable_list_adapter(Context context) {
        this.context = context;
    }
    public void setAdapterData(List<JobModel> jobModelList) {
        this.jobModelList = jobModelList;
        notifyDataSetChanged();
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
            final String Invoice = jobModelList.get(listPosition).getOrder().getReferenceInvoice();
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.job_details_with_icon, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.child_list_item_job_date_text_view);
            ImageView icon=(ImageView)convertView.findViewById(R.id.child_icon);
            icon.setImageResource(R.drawable.invoice);
            expandedListTextView.setText(Invoice);
            convertView.setTag(jobModelList.get(listPosition));

        }
        if (expandedListPosition == 1) {
             String address = (jobModelList.get(listPosition).getOrder().getFrom().getAddress()).replace('\n',' ');
            //Pattern wikiWordMatcher = Pattern.compile("^(?:\\+?88)?01[15-9]\\d{8}$");

if(contact=="not")
{
    Pattern pattern =Pattern.compile("^[+]{1}[8]{2}[01]{1}[0-9]{9}|^[8]{2}[01]{1}[0-9]{9}|^[01]{2}[0-9]{9}");
    Matcher regexMatcher = pattern.matcher(address);
    if (regexMatcher.find()) {
       contact=regexMatcher.group(0);
    }
}



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

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {

        return 5;
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
        String listTitle = jobModelList.get(listPosition).getHRID();
        PersonName=null;
        Area=null;


            boolean exists=jobModelList.get(listPosition).getOrder().hasSellerInfo();
            if(exists){
                PersonName = jobModelList.get(listPosition).getOrder().getSellerInfo().getName();

                contact=jobModelList.get(listPosition).getOrder().getSellerInfo().getPhoneNumber();
            }
            else {
                PersonName=jobModelList.get(listPosition).getUser().getUserName();
                contact="not";
            }
        Area=jobModelList.get(listPosition).getOrder().getFrom().getLocality();
        if (convertView == null) {

           convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.job_parent, parent, false);        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.parent_list_item_job_title);
        TextView ContactPerson = (TextView) convertView
                .findViewById(R.id.parent_list_item_job_pickupfrom);
        TextView Areaplace = (TextView) convertView
                .findViewById(R.id.parent_list_item_job_pickupcontact);
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