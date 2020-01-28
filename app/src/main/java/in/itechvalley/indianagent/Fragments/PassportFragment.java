package in.itechvalley.indianagent.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.itechvalley.indianagent.Activities.MainActivity;
import in.itechvalley.indianagent.Adapter.PassportAdapter;
import in.itechvalley.indianagent.Model.GetterSetter;
import in.itechvalley.indianagent.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PassportFragment extends Fragment
{
    private ArrayList<GetterSetter> passportServicesList = new ArrayList<>();
    private RecyclerView recyclerView;


    public PassportFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ((MainActivity)getActivity())
                .setActionBarTweaks(getString(R.string.passport_fragment_title),
                        ContextCompat.getColor(getContext(),R.color.colorBluePrimary),
                        ContextCompat.getColor(getContext(),R.color.colorBluePrimaryDark));

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareData();

        recyclerView.setAdapter(new PassportAdapter(passportServicesList, getContext(), getActivity().getSupportFragmentManager()));

        return rootView;
    }

    private void prepareData()
    {
        passportServicesList.clear();
        GetterSetter getterSetter = new GetterSetter(R.drawable.passport, getString(R.string.nri_passport), getString(R.string.nri_passport_subtitle), 0);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.indian_passport, getString(R.string.normal_passport), getString(R.string.passport_subtitle), 1);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.steps, getString(R.string.steps_for_passport),getString(R.string.steps_subtitle) , 2);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.calculator, getString(R.string.fee_calculator), getString(R.string.calculate_subtitle), 3);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.police_station, getString(R.string.know_ur_police_station),getString(R.string.police_station_subtitle) , 4);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.acts_rules, getString(R.string.passposr_act_rules),getString(R.string.rules_subtitle) , 5);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.download, getString(R.string.passport_download_eform),getString(R.string.download_subtitle) , 6);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.printer, getString(R.string.passport_download_print_eform),getString(R.string.download_subtitle) , 7);
        passportServicesList.add(getterSetter);

    }


}
