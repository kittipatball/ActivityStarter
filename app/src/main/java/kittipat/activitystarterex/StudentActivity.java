package kittipat.activitystarterex;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

/**
 * Created by Kittipat on 26-Apr-17.
 */

@MakeActivityStarter
public class StudentActivity  extends BaseActivity{

    @BindView(R.id.txtName)  TextView txtName;
    @BindView(R.id.txtGrade)  TextView txtGrade;
    @BindView(R.id.txtNumber)  TextView txtNumber;

    @Arg String name;
    @Arg int id;
    @Arg char grade;
    @Arg boolean passing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_parcelable);
        ButterKnife.bind(this);
        displayResult(name,id ,grade,passing);
    }

    @DebugLog
    private String displayResult(String name , int id , char grade , boolean passing) {
        txtName.setText(name);
        txtGrade.setText(String.valueOf(grade));
        txtNumber.setText(String.valueOf(id));
        return String.valueOf("Name : " + name + "," + " Number : " + id + "," + " Grade : " + grade);
    }
}
