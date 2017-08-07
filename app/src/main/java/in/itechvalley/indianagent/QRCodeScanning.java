package in.itechvalley.indianagent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.zxing.Result;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import in.itechvalley.indianagent.Constants.DataAttributes;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScanning extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    private String uid, name, gender, yearOfBirth, careOf, villageTehsil, postOffice, district, state, postCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanning);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
//        builder.setMessage(result.getText());
//        AlertDialog dialog = builder.create();
        // method to grab the data from QR code
        processScannedData(result.getText());
        startActivity(new Intent(QRCodeScanning.this, AadharDetails.class)
                .putExtra(DataAttributes.AADHAR_UID_ATTR, uid)
                .putExtra(DataAttributes.AADHAR_NAME_ATTR, name)
                .putExtra(DataAttributes.AADHAR_GENDER_ATTR, gender)
                .putExtra(DataAttributes.AADHAR_YOB_ATTR, yearOfBirth)
                .putExtra(DataAttributes.AADHAR_VTC_ATTR, villageTehsil)
                .putExtra(DataAttributes.AADHAR_PO_ATTR, postOffice)
                .putExtra(DataAttributes.AADHAR_PC_ATTR, postCode)
                .putExtra(DataAttributes.AADHAR_DIST_ATTR, district)
                .putExtra(DataAttributes.AADHAR_STATE_ATTR, state)
        );
        // dialog.show();
    }


    protected void processScannedData(String scanData) {
        Log.d("TAG", scanData);
        XmlPullParserFactory pullParserFactory;

        try {
            // init the parserfactory
            pullParserFactory = XmlPullParserFactory.newInstance();
            // get the parser
            XmlPullParser parser = pullParserFactory.newPullParser();

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(new StringReader(scanData));

            // parse the XML
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    Log.d("TAG", "Start document");
                } else if (eventType == XmlPullParser.START_TAG && DataAttributes.AADHAAR_DATA_TAG.equals(parser.getName())) {
                    // extract data from tag
                    //uid
                    uid = parser.getAttributeValue(null, DataAttributes.AADHAR_UID_ATTR);
                    //name
                    name = parser.getAttributeValue(null, DataAttributes.AADHAR_NAME_ATTR);
                    //gender
                    gender = parser.getAttributeValue(null, DataAttributes.AADHAR_GENDER_ATTR);
                    // year of birth
                    yearOfBirth = parser.getAttributeValue(null, DataAttributes.AADHAR_YOB_ATTR);
                    // care of
                    careOf = parser.getAttributeValue(null, DataAttributes.AADHAR_CO_ATTR);
                    // village Tehsil
                    villageTehsil = parser.getAttributeValue(null, DataAttributes.AADHAR_VTC_ATTR);
                    // Post Office
                    postOffice = parser.getAttributeValue(null, DataAttributes.AADHAR_PO_ATTR);
                    // district
                    district = parser.getAttributeValue(null, DataAttributes.AADHAR_DIST_ATTR);
                    // state
                    state = parser.getAttributeValue(null, DataAttributes.AADHAR_STATE_ATTR);
                    // Post Code
                    postCode = parser.getAttributeValue(null, DataAttributes.AADHAR_PC_ATTR);


                    Log.d("DATA", "processScannedData: uid-----------" + uid);
                    Log.d("DATA", "processScannedData: name-----------" + name);
                    Log.d("DATA", "processScannedData: gender-----------" + gender);
                    Log.d("DATA", "processScannedData: yearOfBirth-----------" + yearOfBirth);
                    Log.d("DATA", "processScannedData: careOf-----------" + careOf);
                    Log.d("DATA", "processScannedData: villageTehsil-----------" + villageTehsil);
                    Log.d("DATA", "processScannedData: postOffice-----------" + postOffice);
                    Log.d("DATA", "processScannedData: district-----------" + district);
                    Log.d("DATA", "processScannedData: state-----------" + state);
                    Log.d("DATA", "processScannedData: postCode-----------" + postCode);

                } else if (eventType == XmlPullParser.END_TAG) {
                    Log.d("TAG", "End tag " + parser.getName());

                } else if (eventType == XmlPullParser.TEXT) {
                    Log.d("TAG", "Text " + parser.getText());

                }
                // update eventType
                eventType = parser.next();
            }

            // display the data on screen
            // displayScannedData();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }// EO function


}
