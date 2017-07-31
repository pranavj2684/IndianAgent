package in.itechvalley.indianagent.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 29/07/2017.
 */
public class AadhaarPanFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aadhaar_pan, container, false);
    }

}
