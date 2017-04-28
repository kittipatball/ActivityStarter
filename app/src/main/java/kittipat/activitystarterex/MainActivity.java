package kittipat.activitystarterex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;

/**
 * Created by Kittipat on 26-Apr-17.
 */
@MakeActivityStarter
public class MainActivity extends BaseActivity {

    @BindView(R.id.btnSendData) Button btnSendData;
    @BindView(R.id.btnSendDataParcelable) Button btnSendDataParcelable;
    @BindView(R.id.btnSendDataToThisPage) Button btnSendDataToThisPage;

    @Arg Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(student != null){
            displayData();
        }
    }

    @DebugLog
    private String displayData() {
        return String.valueOf(" Name : " + student.name + " Number : " + student.id + " Grade : " + student.grade);
    }

    @OnClick(R.id.btnSendData)
    public void sendData(View v){
        StudentActivityStarter.start(MainActivity.this,"Kittipat",55051001,'A',true);
    }

    @OnClick(R.id.btnSendDataParcelable)
    public void sendDataParcelable(View v){
        Student student = new Student(55051002,"Piyawat","A",true);
        StudentParcelableActivityStarter.start(MainActivity.this,student);
    }

    @OnClick(R.id.btnSendDataToThisPage)
    public void sendDataToThisPage(View v){
        Student student = new Student(55051003,"Wasan","A",true);
        StudentForResultActivityStarter.start(MainActivity.this,student);
    }

}
