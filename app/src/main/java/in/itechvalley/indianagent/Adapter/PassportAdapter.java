package in.itechvalley.indianagent.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
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
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;
import in.itechvalley.indianagent.WebviewActivity;

/**
 * Created by Mayur Bherade on 01-08-2017.
 */

public class PassportAdapter extends RecyclerView.Adapter<PassportAdapter.MyViewHolder>
{
    private Intent intent;
    FragmentManager fragmentManager;
    Context context;

    private ArrayList<GetterSetter> passportServices;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView Title, Subtitle;
        private ImageView img;
        private CardView cardView;

        public MyViewHolder(View view)
        {
            super(view);
            Title = (TextView) view.findViewById(R.id.txtView_Title);
            Subtitle = (TextView) view.findViewById(R.id.txtView_Subtitle);
            img = (ImageView) view.findViewById(R.id.upperImageView);
            cardView = (CardView) view.findViewById(R.id.cardDownloadAadhaar);
        }
    }

    public PassportAdapter(ArrayList<GetterSetter> passportServices, Context context, FragmentManager supportFragmentManager)
    {
        this.passportServices = passportServices;
        this.context = context;
        this.fragmentManager = supportFragmentManager;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_passport, parent, false);
        intent = new Intent(context, WebviewActivity.class);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final int clickPosition = holder.getAdapterPosition();
        GetterSetter getterSetter = passportServices.get(position);
        holder.Title.setText(getterSetter.getTitle());
//        holder.Subtitle.setText(getterSetter.getSubtitle());
        // holder.img.setImageResource(getterSetter.getImgResourceId());
        holder.img.setImageResource(getterSetter.getImgResourceId());

        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (clickPosition)
                {
                    case 0:
                    {
                        startWebActivity("https://passport.gov.in/nri/Online.do",
                                "NRI Passport");
                        break;
                    }
                    case 1:
                    {
                        startWebActivity("https://portal2.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction?request_locale=en",
                                "Apply Online");
                        break;
                    }
                    case 2:
                    {
                        startWebActivity("https://portal2.passportindia.gov.in/AppOnlineProject/online/procEFormSub",
                                "Passport Procedure");
                        break;
                    }
                    case 3: {
                        startWebActivity(Constants.PASSPORT_FEE_CALCULATOR_URL, "Passport Fee Calculator");
                        break;
                    }
                    case 4: {
                        startWebActivity(Constants.PASSPORT_KNOW_YOUR_POLICE_STATION_URL, "Police Station");
                        break;
                    }
                    case 5:
                    {
                     startWebActivity(Constants.PASSPORT_ACT_RULES_URL,"Passport Act & Rules");
                     break;
                    }
                    case 6:
                    {
                        startWebActivity(Constants.PASSPORT_DOWNLOAD_EFORM_URL,"Passport E-Form");
                        break;
                    }
                    case 7:
                    {
                        startWebActivity(Constants.PASSPORT_DOWNLOAD_PRINT_FORM_URL,"Passport Print Form");
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
        return passportServices.size();
    }

    private void startWebActivity(String url, String title)
    {
        intent.putExtra(Constants.KEY_URL, url);
        intent.putExtra(Constants.KEY_HEADING, title);


        Log.d("TAG", "startWebActivity:++++++++ "+url+title);
        context.startActivity(intent);
    }




}
