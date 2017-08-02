package in.itechvalley.indianagent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScanning extends AppCompatActivity implements ZXingScannerView.ResultHandler
{

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanning);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(result.getText());
        AlertDialog dialog = builder.create();
        Log.d("TAG", "handleResult:Scan Result QR Code+++ " + result);

        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(result.getText()));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                if (eventType == XmlPullParser.START_DOCUMENT)
                {
                    System.out.println("Start document");
                }
                else if (eventType == XmlPullParser.START_TAG)
                {
                    System.out.println("Start tag " + xpp.getName());
                }
                else if (eventType == XmlPullParser.END_TAG)
                {
                    System.out.println("End tag " + xpp.getName());
                }
                else if (eventType == XmlPullParser.TEXT)
                {
                    System.out.println("Text " + xpp.getText());
                    System.out.println("Text " + xpp.getNamespace());

                }
                eventType = xpp.next();
            }
            System.out.println("End document");
        }
        catch (XmlPullParserException | IOException e)
        {
            e.printStackTrace();
        }


        dialog.show();
    }

}
