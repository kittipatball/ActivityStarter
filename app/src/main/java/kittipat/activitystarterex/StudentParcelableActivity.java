package kittipat.activitystarterex;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;

/**
 * Created by Kittipat on 26-Apr-17.
 */

@MakeActivityStarter
public class StudentParcelableActivity extends BaseActivity {

    @BindView(R.id.txtName)  TextView txtName;
    @BindView(R.id.txtGrade)  TextView txtGrade;
    @BindView(R.id.txtNumber)  TextView txtNumber;

    @Arg Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_parcelable);
        ButterKnife.bind(this);
        displayResult(student);
    }

    @DebugLog
    private String displayResult(Student student) {
        txtName.setText(student.name);
        txtGrade.setText(String.valueOf(student.grade));
        txtNumber.setText(String.valueOf(student.id));
        return String.valueOf("Name : " + student.name + "," + " Number : " + student.id + "," + " Grade : " + student.grade);
    }
}
