package in.itechvalley.indianagent.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.itechvalley.indianagent.Activities.WebviewActivity;
import in.itechvalley.indianagent.Constants.Constants;
import in.itechvalley.indianagent.R;

/**
 * Created by pranav on 29/07/2017.
 */
public class AadhaarPanFragment extends Fragment
{

    private Button PanAadhaar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_aadhaar_pan,container,false);

        PanAadhaar = (Button)rootView.findViewById(R.id.btnPanAadhaar);

        PanAadhaar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra(Constants.KEY_URL,"https://incometaxindiaefiling.gov.in/e-Filing/Services/LinkAadhaarHome.html");
                getContext().startActivity(intent);
            }
        });
        return rootView;
    }

}
