package za.co.projects.android.pmoloi.winterolympics.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import za.co.projects.android.pmoloi.winterolympics.BuildConfig;
import za.co.projects.android.pmoloi.winterolympics.R;
import za.co.projects.android.pmoloi.winterolympics.ui.schedule.fragment_olympic_schedule;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, fragment_olympic_schedule.OnFragmentInteractionListener {

        private Toolbar toolbar;
        private TextView appVersionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        appVersionCode = findViewById(R.id.footer_version_label);
        appVersionCode.setText(BuildConfig.VERSION_NAME);
        navigationView.getMenu().getItem(0).setChecked(true);
        fragment_olympic_schedule olympicSchedule = new fragment_olympic_schedule();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, olympicSchedule).commit();
        toolbar.setTitle("Olympic Schedule");
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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
           // return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_schedule) {
            fragment_olympic_schedule olympicSchedule = new fragment_olympic_schedule();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, olympicSchedule).commit();
            toolbar.setTitle("Olympic Schedule");
        } else if (id == R.id.nav_leaderboard) {

        } else if (id == R.id.nav_sport_selection) {

        } else if (id == R.id.nav_athlete_profile) {

        } else if (id == R.id.nav_stream) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }
}
