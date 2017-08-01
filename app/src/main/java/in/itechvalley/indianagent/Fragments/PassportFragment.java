package in.itechvalley.indianagent.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        ((Toolbar) getActivity().findViewById(R.id.toolbar)).setTitle("Passport Hub");

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
        GetterSetter getterSetter = new GetterSetter(R.drawable.download, getString(R.string.nri_passport), "Sir Please Update", 0);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.download, getString(R.string.normal_passport), "Sir Please Update", 0);
        passportServicesList.add(getterSetter);

        getterSetter = new GetterSetter(R.drawable.download, getString(R.string.steps_for_passport), "Sir Please Update", 0);
        passportServicesList.add(getterSetter);
    }


}
