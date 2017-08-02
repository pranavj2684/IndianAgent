package in.itechvalley.indianagent.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

import in.itechvalley.indianagent.Adapter.AadhaarAdapter;
import in.itechvalley.indianagent.Adapter.RailwayAdapter;
import in.itechvalley.indianagent.MainActivity;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 29/07/2017.
 */
public class RailwayFragment extends Fragment
{
    private ArrayList<GetterSetter> servicesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AppCompatActivity appCompatActivity;

    public RailwayFragment()
    {

    }

    @SuppressLint("ValidFragment")
    public RailwayFragment(AppCompatActivity appCompatActivity)
    {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.main_fragment,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        servicesList.clear();

        prepareData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new SimpleItemAnimator()
        {
            @Override
            public boolean animateRemove(RecyclerView.ViewHolder holder)
            {
                return false;
            }

            @Override
            public boolean animateAdd(RecyclerView.ViewHolder holder)
            {
                return true;
            }

            @Override
            public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY)
            {
                return false;
            }

            @Override
            public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop)
            {
                return false;
            }

            @Override
            public void runPendingAnimations()
            {

            }

            @Override
            public void endAnimation(RecyclerView.ViewHolder item)
            {

            }

            @Override
            public void endAnimations()
            {

            }

            @Override
            public boolean isRunning()
            {
                return false;
            }
        });
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new RailwayAdapter(servicesList, getContext(), appCompatActivity));


//        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
//        {
//            @Override
//            public boolean onPreDraw()
//            {
//                recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
//                for (int i = 0; i < recyclerView.getChildCount(); i++) {
//                    View v = recyclerView.getChildAt(i);
//                    v.setAlpha(0.0f);
//                    v.animate().alpha(1.0f)
//                            .setDuration(300)
//                            .setStartDelay(i * 50)
//                            .start();
//                }
//
//                return true;
//            }
//        });
        return rootView;
    }

    public void prepareData()
    {
        servicesList.clear();
        GetterSetter getterSetter = new GetterSetter(R.drawable.train, getString(R.string.check_pnr_status), getString(R.string.check_pnr_subtitle), 0);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.account, getString(R.string.irctc_login), getString(R.string.irctc_login_subtitle), 1);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.seat_recline_extra, getString(R.string.train_berth_available), getString(R.string.train_berth_avl_subtitle), 2);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.airballoon, getString(R.string.trains_betwn_stations), getString(R.string.train_bet_station_subtitle), 3);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.currency_inr, getString(R.string.fair_enquiry), getString(R.string.fair_enquiry_subtitle), 4);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.information_variant, getString(R.string.nat_train_enq_system), getString(R.string.ntes_subtitle), 5);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.phone, getString(R.string.dial_139), getString(R.string.dial_139_subtitle), 6);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.message, getString(R.string.sms_service), getString(R.string.sms_service_subtitle), 7);
        servicesList.add(getterSetter);
    }

}
