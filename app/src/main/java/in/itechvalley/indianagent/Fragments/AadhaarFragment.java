package in.itechvalley.indianagent.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.ImageView;

import java.util.ArrayList;

import in.itechvalley.indianagent.Adapter.AadhaarAdapter;
import in.itechvalley.indianagent.Adapter.RecyclerAdapter;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 29/07/2017.
 */
public class AadhaarFragment extends Fragment
{
    private ArrayList<GetterSetter> servicesList = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        ((Toolbar) getActivity().findViewById(R.id.toolbar)).setTitle("Aadhaar Card");

        recyclerView = rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareData();

        recyclerView.setAdapter(new AadhaarAdapter(servicesList, getContext(), getActivity().getSupportFragmentManager()));

        return rootView;
    }

    public void prepareData()
    {
        GetterSetter getterSetter = new GetterSetter(R.drawable.download, getString(R.string.download_aadhaar_card), getString(R.string.download_aadhaar_subtitle), 0);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.open_in_new, getString(R.string.apply_new_aadhaar_card), getString(R.string.apply_new_aadhaar_subtitle), 2);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.account_card_details, getString(R.string.check_aadhaar_status), getString(R.string.check_aadhaar_status_subtitle), 3);
        servicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.qrcode, getString(R.string.scan_qr_code), getString(R.string.scan_qr_code_subtitle), 4);
        servicesList.add(getterSetter);

    }

}
