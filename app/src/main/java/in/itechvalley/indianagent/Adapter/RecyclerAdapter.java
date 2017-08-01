package in.itechvalley.indianagent.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.itechvalley.indianagent.Fragments.AadhaarFragment;
import in.itechvalley.indianagent.Fragments.AadhaarPanFragment;
import in.itechvalley.indianagent.Fragments.MainFragment;
import in.itechvalley.indianagent.Fragments.MsebBillFragment;
import in.itechvalley.indianagent.Fragments.PassportFragment;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;
import in.itechvalley.indianagent.WebviewActivity;

/**
 * Created by pranav on 26/07/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{
    private FragmentManager fragmentManager;
    private Context context;

    private ArrayList<GetterSetter> services;


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView Title, Subtitle;
        public ImageView img;
        public LinearLayout cardView;

        public MyViewHolder(View view)
        {
            super(view);
            Title = view.findViewById(R.id.textViewTitle);
            Subtitle = view.findViewById(R.id.textView_Subtitle);
            img = view.findViewById(R.id.imgView);
            cardView = view.findViewById(R.id.cardItem);
        }

    }

    public RecyclerAdapter(ArrayList<GetterSetter> services, Context context, FragmentManager fragmentManager)
    {
        this.services = services;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem, parent, false);
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
                        AadhaarFragment aadhaarFragment = new AadhaarFragment();
                        fragmentManager
                                .beginTransaction()
                                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                .replace(R.id.container, aadhaarFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
//                    case 1:
//                    {
//
//                    }
                    case 2:
                    {
                        PassportFragment passportFragment = new PassportFragment();
                        fragmentManager
                                .beginTransaction()
                                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                .replace(R.id.container, passportFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 3:
                    {
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        AadhaarPanFragment aadhaarpanFragment = new AadhaarPanFragment();
                        transaction.replace(R.id.container, aadhaarpanFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    }

                    case 4:
                    {
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        MsebBillFragment msebBillFragment;
                        msebBillFragment = new MsebBillFragment();
                        transaction.replace(R.id.container, msebBillFragment)
                                .addToBackStack(null)
                                .commit();
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


}

/*
*/