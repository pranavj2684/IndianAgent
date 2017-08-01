package in.itechvalley.indianagent.Fragments;

import android.content.Context;
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

import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * Created by Mayur Bherade on 01-08-2017.
 */

class PassportAdapter extends RecyclerView.Adapter<PassportAdapter.MyViewHolder>
{
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
                        break;
                    }
                    case 1:
                    {
                        break;
                    }
                    case 2:
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
        return passportServices.size();
    }


}
