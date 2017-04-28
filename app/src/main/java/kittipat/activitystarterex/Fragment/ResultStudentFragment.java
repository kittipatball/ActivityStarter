package kittipat.activitystarterex.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;
import kittipat.activitystarterex.R;

/**
 * Created by Kittipat on 28-Apr-17.
 */

@MakeActivityStarter
public class ResultStudentFragment extends Fragment {

    @Arg Student student;

    @BindView(R.id.txtName) TextView txtName;
    @BindView(R.id.txtGrade)  TextView txtGrade;
    @BindView(R.id.txtNumber)  TextView txtNumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_student_parcelable, container, false);
        ButterKnife.bind(this, view);
        ActivityStarter.fill(ResultStudentFragment.this);
        displayResult(student);
        return view;
    }

    @DebugLog
    private String displayResult(Student student) {
        txtName.setText(student.name);
        txtGrade.setText(String.valueOf(student.grade));
        txtNumber.setText(String.valueOf(student.id));
        return String.valueOf("Name : " + student.name + "," + " Number : " + student.id + "," + " Grade : " + student.grade);
    }
}
