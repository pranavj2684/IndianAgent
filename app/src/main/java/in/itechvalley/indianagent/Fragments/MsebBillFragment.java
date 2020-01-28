package in.itechvalley.indianagent.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import in.itechvalley.indianagent.Activities.WebviewActivity;
import in.itechvalley.indianagent.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsebBillFragment extends Fragment
{
    private Spinner spinnerMseb;
    private Button btnMesbPay;
    String link;
    ArrayAdapter<CharSequence> links;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View msebView = inflater.inflate(R.layout.fragment_mseb_bill, container, false);

        spinnerMseb = msebView.findViewById (R.id.spinnerMseb);
        btnMesbPay = msebView.findViewById (R.id.btnMesbPay);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.states_array,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        links = ArrayAdapter.createFromResource(getContext(),
                R.array.electric_bill_payment_links, android.R.layout.simple_spinner_dropdown_item);

        // Apply Adapter to Spinner
        spinnerMseb.setAdapter(adapter);

        btnMesbPay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent msebBillIntent = new Intent (getActivity().getApplicationContext(),
                        WebviewActivity.class);
                msebBillIntent.putExtra(getString(R.string.url), link);
                startActivity(msebBillIntent);
            }
        });

        // OnItemSelectedListener to Spinner
        spinnerMseb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                link = links.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        return msebView;
    }




}
