package in.itechvalley.indianagent.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import in.itechvalley.indianagent.Constants.DataAttributes;
import in.itechvalley.indianagent.R;

public class AadharDetails extends AppCompatActivity {
    
    private TextView txtAadhar_uid,txtAadhar_name,txtAadhar_gender,txtAadhar_yob,txtAadhar_co,txtAadhar_vtc,txtAadhar_po,txtAadhar_dist,
            txtAadhar_state,txtAadhar_pc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_details);



        txtAadhar_uid = (TextView)findViewById(R.id.txtAadhar_uid);
        txtAadhar_name = (TextView)findViewById(R.id.txtAadhar_name);
        txtAadhar_gender = (TextView)findViewById(R.id.txtAadhar_gender);
        txtAadhar_yob = (TextView)findViewById(R.id.txtAadhar_yob);
        txtAadhar_co = (TextView)findViewById(R.id.txtAadhar_co);
        txtAadhar_vtc = (TextView)findViewById(R.id.txtAadhar_vtc);
        txtAadhar_po = (TextView)findViewById(R.id.txtAadhar_po);
        txtAadhar_dist = (TextView)findViewById(R.id.txtAadhar_dist);
        txtAadhar_state = (TextView)findViewById(R.id.txtAadhar_state);
        txtAadhar_pc = (TextView)findViewById(R.id.txtAadhar_pc);

        Intent receivingIntent =getIntent();
       String aadharUID= receivingIntent.getStringExtra(DataAttributes.AADHAR_UID_ATTR);
       String aadharName= receivingIntent.getStringExtra(DataAttributes.AADHAR_NAME_ATTR);
       String aadharGender= receivingIntent.getStringExtra(DataAttributes.AADHAR_GENDER_ATTR);
       String aadharYOB= receivingIntent.getStringExtra(DataAttributes.AADHAR_YOB_ATTR);
       String aadharVillage= receivingIntent.getStringExtra(DataAttributes.AADHAR_VTC_ATTR);
       String aadharPostOffice= receivingIntent.getStringExtra(DataAttributes.AADHAR_PO_ATTR);
       String aadharDistrict= receivingIntent.getStringExtra(DataAttributes.AADHAR_DIST_ATTR);
       String aadharState= receivingIntent.getStringExtra(DataAttributes.AADHAR_STATE_ATTR);
       String aadharPinCode= receivingIntent.getStringExtra(DataAttributes.AADHAR_PC_ATTR);



        // update UI Elements
        txtAadhar_uid.setText(aadharUID);
        txtAadhar_name.setText(aadharName);
        txtAadhar_gender.setText(aadharGender);
        txtAadhar_yob.setText(aadharYOB);
        txtAadhar_co.setText("-");
        txtAadhar_vtc.setText(aadharVillage);
        txtAadhar_po.setText(aadharPostOffice);
        txtAadhar_dist.setText(aadharDistrict);
        txtAadhar_state.setText(aadharState);
        txtAadhar_pc.setText(aadharPinCode);

    }
}
