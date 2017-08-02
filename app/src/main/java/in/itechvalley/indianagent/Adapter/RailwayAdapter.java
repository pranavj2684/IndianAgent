package in.itechvalley.indianagent.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.itechvalley.indianagent.Constants.Constants;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;
import in.itechvalley.indianagent.WebviewActivity;

/**
 * Created by pranav on 29/07/2017.
 */

public class RailwayAdapter extends RecyclerView.Adapter<RailwayAdapter.MyViewHolder>
{


    private FragmentManager fragmentManager;
    Context context;
    private Intent intent;
    private AppCompatActivity appCompatActivity;
    int lastPosition = -1;

    private ArrayList<GetterSetter> services;


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView Title, Subtitle;
        public ImageView img;
        public CardView cardView;

        public MyViewHolder(View view)
        {
            super(view);
            Title = (TextView) view.findViewById(R.id.txtView_rail_Title);
            Subtitle = (TextView) view.findViewById(R.id.txtView_rail_Subtitle);
            img = (ImageView) view.findViewById(R.id.upperImageView);
            cardView = (CardView) view.findViewById(R.id.cardRailway);
        }

    }

    public RailwayAdapter(ArrayList<GetterSetter> services, Context context, AppCompatActivity activity)
    {
        this.services = services;
        this.context = context;
        this.fragmentManager = activity.getSupportFragmentManager();
        this.appCompatActivity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_railway, parent, false);
        intent = new Intent(context, WebviewActivity.class);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final int clickPosition = holder.getAdapterPosition();

        GetterSetter getterSetter = services.get(position);

        holder.Title.setText(getterSetter.getTitle());
        holder.Subtitle.setText(getterSetter.getSubtitle());
        holder.img.setImageResource(getterSetter.getImgResourceId());

        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (clickPosition)
                {
                    case 0:
                    {
                        startWebActivity(
                                "http://www.indianrail.gov.in/enquiry/PnrEnquiry.html",
                                "Check PNR Status");
                        break;
                    }
                    case 1:
                    {
                        startWebActivity(
                                "https://www.services.irctc.co.in/cgi-bin/bv60.dll/irctc/services/login.do",
                                "IRCTC Login");
                        break;
                    }
                    case 2:
                    {
                        startWebActivity(
                                "http://www.indianrail.gov.in/between_Imp_Stations.html",
                                "Train Berth Availability");
                        break;

                    }
                    case 3:
                    {
                        startWebActivity(
                                "http://www.indianrail.gov.in/between_Imp_Stations.html",
                                "Trains Between Stations");
                        break;
                    }
                    case 4:
                    {
                        startWebActivity(
                                "http://www.indianrail.gov.in/fare_Enq.html",
                                "Fare Enquiry");
                        break;
                    }
                    case 5:
                    {
                        startWebActivity(
                                "http://enquiry.indianrail.gov.in/ntes/",
                                "National Train Enquiry Status");
                        break;
                    }
                    // Dial 139
                    case 6:
                    {
                        Intent intent = new Intent(context, WebviewActivity.class);
                        intent.putExtra(Constants.KEY_URL, "");
                        context.startActivity(intent);
                        break;
                    }
                    case 7:
                    {
                        Intent intent = new Intent(context, WebviewActivity.class);
                        intent.putExtra(Constants.KEY_URL, "http://www.indianrail.gov.in/139.html");
                        intent.putExtra(Constants.KEY_HEADING, "SMS Services");
                        context.startActivity(intent);
                        break;
                    }

                }
            }
        });
        if (position > lastPosition)
        {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    private void startWebActivity(String url, String title)
    {
        intent.putExtra(Constants.KEY_URL, url);
        intent.putExtra(Constants.KEY_HEADING, title);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(appCompatActivity).toBundle());
        }
        else
        {
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount()
    {
        return services.size();
    }
}

