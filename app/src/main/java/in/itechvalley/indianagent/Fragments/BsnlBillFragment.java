package in.itechvalley.indianagent.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.itechvalley.indianagent.Adapter.BSNLAdapter;
import in.itechvalley.indianagent.Adapter.RailwayAdapter;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 17/08/2017.
 */

public class BsnlBillFragment extends Fragment
{
    private ArrayList<GetterSetter> servicesList = new ArrayList<>();
    public RecyclerView recyclerView;
    private AppCompatActivity appCompatActivity;

    public BsnlBillFragment()
    {

    }

    @SuppressLint("ValidFragment")
    public BsnlBillFragment(AppCompatActivity appCompatActivity)
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

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(),3);
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

        recyclerView.setAdapter(new BSNLAdapter(servicesList, getContext(), appCompatActivity));

        //RunTime Permission Check for Call Phone
        String[] permissions = {Manifest.permission.CALL_PHONE};
        int result = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE);
        if(result== PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(getActivity(),permissions, 3131);
        }

        return rootView;
    }

    public void prepareData()
    {
        servicesList.clear();
        GetterSetter getterSetter = new GetterSetter(R.drawable.invoice, getString(R.string.quick_pay_bill), "", 0);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.battery, getString(R.string.bsnl_recharge), "", 1);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.world, getString(R.string.bsnl_website), "", 2);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.phone, getString(R.string.bsnl_customer_care), "", 3);
        servicesList.add(getterSetter);

    }

}
