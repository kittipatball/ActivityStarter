package kittipat.activitystarterex;

import android.os.Bundle;
import android.util.Log;

import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;

/**
 * Created by Kittipat on 26-Apr-17.
 */

@MakeActivityStarter
public class StudentParcelableActivity extends BaseActivity {

    @Arg Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_parcelable);
        displayResult(student);
    }

    @DebugLog
    private String displayResult(Student student) {
        Log.e("Result" , String.valueOf("Name : " + student.name + " Number : " + student.id + " Grade : " + student.grade));
        return String.valueOf("Name : " + student.name + " Number : " + student.id + " Grade : " + student.grade);
    }
}
