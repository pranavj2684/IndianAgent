package in.itechvalley.indianagent.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.itechvalley.indianagent.Adapter.RecyclerAdapter;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 25/07/2017.
 */

public class MainFragment extends Fragment
{
    private ArrayList<GetterSetter> servicesList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        ((Toolbar) getActivity().findViewById(R.id.toolbar)).setTitle("Indian Agent");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        servicesList.clear();
        prepareData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(new RecyclerAdapter(servicesList, getContext(), getActivity().getSupportFragmentManager()));


        return rootView;
    }

    private void prepareData()
    {
        servicesList.clear();
        GetterSetter getterSetter = new GetterSetter(R.drawable.ic_aadhaar_card, getString(R.string.aadhaar_card), getString(R.string.aadhaar_subtitle), 0);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.ic_pan_card, getString(R.string.pan_card), getString(R.string.pancard_subtitle), 1);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.ic_passport, getString(R.string.indian_passport), getString(R.string.indian_passport_subtitle), 2);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.ic_aadhaar_pan, getString(R.string.aadhaar_pan), getString(R.string.link_aadhaar_pan_subtitle), 3);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.ic_pay_bill, getString(R.string.bill_payment), getString(R.string.bill_payment_subtitle), 4);
        servicesList.add(getterSetter);


    }
}
