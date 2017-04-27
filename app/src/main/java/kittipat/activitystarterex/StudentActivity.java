package kittipat.activitystarterex;

import android.os.Bundle;
import android.util.Log;

import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import hugo.weaving.DebugLog;

/**
 * Created by Kittipat on 26-Apr-17.
 */

@MakeActivityStarter
public class StudentActivity  extends BaseActivity{

        @Arg String name;
        @Arg int id;
        @Arg char grade;
        @Arg boolean passing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        displayResult(name,id ,grade,passing);
    }

    @DebugLog
        private String displayResult(String name , int id , char grade , boolean passing) {
            Log.e("Result", String.valueOf("Name : " + name + " Number : " + id + " Grade : " + grade));
            return String.valueOf(" Name : " + name + " Number : " + id + " Grade : " + grade);
        }
}
