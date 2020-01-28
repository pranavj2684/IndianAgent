package in.itechvalley.indianagent.Adapter;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.itechvalley.indianagent.Activities.WebviewActivity;
import in.itechvalley.indianagent.Constants.Constants;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 17/08/2017.
 */

public class BSNLAdapter extends RecyclerView.Adapter<BSNLAdapter.MyViewHolder>
{

    private Intent intent;
    FragmentManager fragmentManager;
    Context context;
    private AppCompatActivity appCompatActivity;

    private ArrayList<GetterSetter> services;
    int lastPosition = -1;



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView Title, Subtitle;
        public ImageView img;
        public LinearLayout Llayout;

        public MyViewHolder(View view)
        {
            super(view);
            Title = (TextView) view.findViewById(R.id.txtView_Title);
           // Subtitle = (TextView) view.findViewById(R.id.txtView_Subtitle);
            img = (ImageView) view.findViewById(R.id.upperImageView);
            Llayout = (LinearLayout) view.findViewById(R.id.cardBSNL);
        }

    }

    public BSNLAdapter(ArrayList<GetterSetter> services, Context context, AppCompatActivity activity)
    {
        this.services = services;
        this.context = context;
        this.fragmentManager = activity.getSupportFragmentManager();
        this.appCompatActivity = activity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_bsnl_bill, parent, false);
        intent = new Intent(context, WebviewActivity.class);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final int clickPosition = holder.getAdapterPosition();
        GetterSetter getterSetter = services.get(position);
        holder.Title.setText(getterSetter.getTitle());
//        holder.Subtitle.setText(getterSetter.getSubtitle());
        // holder.img.setImageResource(getterSetter.getImgResourceId());
        holder.img.setImageResource(getterSetter.getImgResourceId());

        holder.Llayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (clickPosition)
                {
                    case 0:
                    {
                        startWebActivity(Constants.BSNL_LANDLINE_PAY_URL,
                                Constants.BSNL_LANDLINE_PAY);
                        break;
                    }
                    case 1:
                    {
                        startWebActivity(Constants.BSNL_RECHARGE,
                                Constants.BSNL_RECHARGE_TITLE);

                        break;
                    }
                    case 2:
                    {
                        startWebActivity(Constants.BSNL_WEBSITE,
                                Constants.BSNL_ALL_OPTIONS);

                        break;
                    }
                    case 3:
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Dial");
                        builder.setItems(new CharSequence[]
                                        {"198", "1500", "1800 345 1500"},
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // The 'which' argument contains the index position
                                        // of the selected item

                                        Intent intent = new Intent(Intent.ACTION_CALL);
                                        switch (which) {
                                            case 0:
                                                intent.setData(Uri.parse("tel:198"));
                                                context.startActivity(intent);
                                                break;
                                            case 1:
                                                intent.setData(Uri.parse("tel:1500"));
                                                context.startActivity(intent);
                                                break;
                                            case 2:
                                                intent.setData(Uri.parse("tel:1800 345 1500"));
                                                context.startActivity(intent);
                                                break;

                                        }
                                    }
                                });
                        builder.create().show();
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
        Log.d("TAG", "onBindViewHolder: " + getterSetter.getSubtitle());

    }

    @Override
    public int getItemCount()
    {
        return services.size();
    }

    private void startWebActivity(String url, String title)
    {
        intent.putExtra(Constants.KEY_URL, url);
        intent.putExtra(Constants.KEY_HEADING, title);


        Log.d("TAG", "startWebActivity:++++++++ "+url+title);
        context.startActivity(intent);
    }

}