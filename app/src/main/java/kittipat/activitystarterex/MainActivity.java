package kittipat.activitystarterex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import kittipat.activitystarterex.Data.Student;

/**
 * Created by Kittipat on 26-Apr-17.
 */

public class MainActivity extends BaseActivity {

    Button btnSendData;
    Button btnSendDataParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInit();

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentActivityStarter.start(MainActivity.this,"Kittipat",3,'A',true);
            }
        });

        btnSendDataParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(4,"Piyawat",'A',true);
                StudentParcelableActivityStarter.start(MainActivity.this,student);
            }
        });
    }

    private void setInit() {
        btnSendData = (Button) findViewById(R.id.btnSendData);
        btnSendDataParcelable = (Button) findViewById(R.id.btnSendDataParcelable);
    }
}
