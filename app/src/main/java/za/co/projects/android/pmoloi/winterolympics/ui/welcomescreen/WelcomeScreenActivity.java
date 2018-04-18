package za.co.projects.android.pmoloi.winterolympics.ui.welcomescreen;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import za.co.projects.android.pmoloi.winterolympics.R;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    public void onExploreClick(View view)
    {
        startActivity(new Intent(this,HomeActivity.class));
    }
}

