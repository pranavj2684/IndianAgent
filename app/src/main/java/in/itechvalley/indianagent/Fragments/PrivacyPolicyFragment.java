package in.itechvalley.indianagent.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 18/08/2017.
 */

public class PrivacyPolicyFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_privacy_policy,container,false);
        return rootView;
    }
}

