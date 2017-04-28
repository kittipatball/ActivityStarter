package kittipat.activitystarterex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;

@MakeActivityStarter
public class StudentForResultActivity extends BaseActivity {

    @BindView(R.id.txtName)  TextView txtName;
    @BindView(R.id.txtGrade)  TextView txtGrade;
    @BindView(R.id.txtNumber)  TextView txtNumber;

    @Arg Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_parcelable);
        ButterKnife.bind(this);
        displayData();
        EditNameStudent();
    }

    @DebugLog
    private String EditNameStudent() {
        student.name = "Wasu";
        return String.valueOf("Name : " + student.name);
    }

    @DebugLog
    private String displayData() {
        txtName.setText(student.name);
        txtGrade.setText(String.valueOf(student.grade));
        txtNumber.setText(String.valueOf(student.id));
        return String.valueOf("Name : " + student.name + "," + " Number : " + student.id + "," + " Grade : " + student.grade);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivityStarter.start(this,student);
    }
}
