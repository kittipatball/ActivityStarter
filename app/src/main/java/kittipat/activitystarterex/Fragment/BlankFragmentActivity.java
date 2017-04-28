package kittipat.activitystarterex.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;
import kittipat.activitystarterex.Fragment.StudentFragment;
import kittipat.activitystarterex.R;

@MakeActivityStarter
public class BlankFragmentActivity extends AppCompatActivity {

    @Arg Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        ActivityStarter.fill(this);
        replaceStudentFragment();
        ShowLog();
    }

    private void replaceStudentFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        StudentFragment fragment = StudentFragmentStarter.newInstance(student);
        ft.replace(R.id.BlankLayout, fragment);
        ft.commit();
    }

    @DebugLog
    private String ShowLog(){
        return String.valueOf("Name : " + student.name + " Number : " + student.id + " Grade : " + student.grade);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ActivityStarter.save(this, outState);
    }
}
