package in.itechvalley.indianagent.Adapter;

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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.itechvalley.indianagent.Constants.Constants;
import in.itechvalley.indianagent.Fragments.AadhaarFragment;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.QRCodeScanning;
import in.itechvalley.indianagent.R;
import in.itechvalley.indianagent.WebviewActivity;

/**
 * Created by pranav on 29/07/2017.
 */

public class AadhaarAdapter extends RecyclerView.Adapter<AadhaarAdapter.MyViewHolder>
{

    private Intent intent;

    FragmentManager fragmentManager;
    Context context;

    private ArrayList<GetterSetter> services;


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView Title, Subtitle;
        public ImageView img;
        public CardView cardView;

        public MyViewHolder(View view)
        {
            super(view);
            Title = (TextView) view.findViewById(R.id.txtView_Title);
            Subtitle = (TextView) view.findViewById(R.id.txtView_Subtitle);
            img = (ImageView) view.findViewById(R.id.upperImageView);
            cardView = (CardView) view.findViewById(R.id.cardDownloadAadhaar);
        }

    }

    public AadhaarAdapter(ArrayList<GetterSetter> services, Context context, FragmentManager fragmentManager)
    {
        this.services = services;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_aadhaar, parent, false);
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
        // holder.img.setImageResource(getterSetter.getImgResourceId());
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
                        startWebActivity("https://eaadhaar.uidai.gov.in/",
                                "Download Aadhar Card");

//                        Bundle bundle = new Bundle();
//                        bundle.putString("URL","https://uidai.gov.in");
//
//                        fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
//                        webviewFragment.setArguments(bundle);
//                        FragmentTransaction transaction = fragmentManager.beginTransaction();
//                        transaction.replace(R.id.container,webviewFragment).commit();

//                        WebviewActivity webviewActivity = new WebviewActivity();
//                        Intent intent = new Intent(context, WebviewActivity.class);
//                        intent.putExtra("URL", "https://incometaxindiaefiling.gov.in/e-Filing/Services/LinkAadhaarPrelogin.html");
//                        ((AppCompatActivity) context).startActivity(intent);
//                        break;


                        break;
                    }
                    case 1:
                    {
                        startWebActivity("https://appointments.uidai.gov.in/",
                                "Enrolment Center Search");

                        break;
                    }
                    case 2:
                    {
                        startWebActivity("https://resident.uidai.net.in/check-aadhaar-status",
                                "Check Aadhaar Status");

                        break;
                    }
                    case 3:
                    {
                        Intent i = new Intent(context, QRCodeScanning.class);
                        context.startActivity(i);
                        break;
                    }
                    case 4:
                    {
                        break;
                    }


                }
            }
        });
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
