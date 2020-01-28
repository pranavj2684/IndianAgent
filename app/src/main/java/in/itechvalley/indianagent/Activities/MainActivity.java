package in.itechvalley.indianagent.Activities;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import in.itechvalley.indianagent.Constants.Constants;
import in.itechvalley.indianagent.Fragments.AadhaarFragment;
import in.itechvalley.indianagent.Fragments.AadhaarPanFragment;
import in.itechvalley.indianagent.Fragments.BsnlBillFragment;
import in.itechvalley.indianagent.Fragments.MainFragment;
import in.itechvalley.indianagent.Fragments.MsebBillFragment;
import in.itechvalley.indianagent.Fragments.PassportFragment;
import in.itechvalley.indianagent.Fragments.PrivacyPolicyFragment;
import in.itechvalley.indianagent.Fragments.RailwayFragment;
import in.itechvalley.indianagent.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setActionBarTweaks(getString(R.string.app_name),
                ContextCompat.getColor(this,R.color.colorPrimary),
                ContextCompat.getColor(this,R.color.colorPrimaryDark));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        MainFragment mainFragment = new MainFragment();
        transaction.replace(R.id.container, mainFragment).commit();
        Log.d("CHECK GIT", "onCreate: ");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aadhaar_card) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            AadhaarFragment aadhaarFragment = new AadhaarFragment();
            transaction.replace(R.id.container, aadhaarFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_rail_services) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            RailwayFragment railwayFragment = new RailwayFragment(MainActivity.this);

            transaction.replace(R.id.container, railwayFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_link_aadhaar_pan) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            AadhaarPanFragment aadhaarPanFragment = new AadhaarPanFragment();
            fragmentTransaction.replace(R.id.container, aadhaarPanFragment)
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_pay_eBill) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            MsebBillFragment msebBillFragment = new MsebBillFragment();
            transaction.replace(R.id.container, msebBillFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_indian_passport) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            PassportFragment passportFragment = new PassportFragment();
            transaction.replace(R.id.container, passportFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_pay_landline_bill) {

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            BsnlBillFragment bsnlBillFragment = new BsnlBillFragment(MainActivity.this);

            transaction.replace(R.id.container, bsnlBillFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_driving_license) {
//
            startActivity(new Intent(MainActivity.this, WebviewActivity.class)
                    .putExtra(Constants.KEY_URL, Constants.DRIVING_LICENCE_WEB_URL)
                    .putExtra(Constants.KEY_HEADING, Constants.DRIVING_LICENCE)

            );
        }

        else if(id==R.id.nav_privacy_policy) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();

            transaction.replace(R.id.container, privacyPolicyFragment)
                    .addToBackStack(null)
                    .commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setActionBarTweaks(String Title,int colorPrimary,int colorPrimaryDark)
    {
        assert getSupportActionBar()!=null;
        getSupportActionBar().setTitle(Title);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(colorPrimary));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setStatusBarColor(colorPrimaryDark);
        }
    }
}
