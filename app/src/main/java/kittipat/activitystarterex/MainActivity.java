package kittipat.activitystarterex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;
import kittipat.activitystarterex.Fragment.*;

/**
 * Created by Kittipat on 26-Apr-17.
 */
@MakeActivityStarter
public class MainActivity extends BaseActivity {

    @BindView(R.id.btnSendData) Button btnSendData;
    @BindView(R.id.btnSendDataParcelable) Button btnSendDataParcelable;
    @BindView(R.id.btnSendDataToThisPage) Button btnSendDataToThisPage;
    @BindView(R.id.btnSendDataToFragment) Button btnSendDataToFragment;

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
        Toast.makeText(getApplicationContext(),"EditName : " + student.name,Toast.LENGTH_SHORT).show();
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

    @OnClick(R.id.btnSendDataToFragment)
    public void sendDataToFragment(View v){
        Student student = new Student(55051004,"Krit","A",true);
        BlankFragmentActivityStarter.start(this,student);
    }
}
