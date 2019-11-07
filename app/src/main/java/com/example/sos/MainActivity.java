package com.example.sos;

import android.content.Intent;
import android.media.MediaCas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkButtonBuilder;
import com.varunest.sparkbutton.SparkEventListener;

import java.util.EventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SparkEventListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.spark_button)
    SparkButton SOSButton;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        try{
            setSupportActionBar(toolbar);
            fab.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
            SOSButton.setEventListener(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEvent(ImageView button, boolean buttonState) {
        Snackbar.make(button, "Sending SOS", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onEventAnimationEnd(ImageView button, boolean buttonState) {
        SOSButton.setChecked(false);
    }

    @Override
    public void onEventAnimationStart(ImageView button, boolean buttonState) {

    }
}
