package kittipat.activitystarterex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import activitystarter.ActivityStarter;

/**
 * Created by Kittipat on 26-Apr-17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStarter.fill(this, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ActivityStarter.save(this, outState);
    }
}
