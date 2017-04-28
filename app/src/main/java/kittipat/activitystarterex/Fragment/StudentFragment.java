package kittipat.activitystarterex.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kittipat.activitystarterex.Data.Student;
import kittipat.activitystarterex.R;

/**
 * Created by Kittipat on 28-Apr-17.
 */

@MakeActivityStarter
public class StudentFragment extends Fragment {

    @BindView(R.id.txtName) TextView txtName;
    @BindView(R.id.txtGrade)  TextView txtGrade;
    @BindView(R.id.txtNumber)  TextView txtNumber;
    @BindView(R.id.btnSendDataFmToFm)  TextView btnSendDataFmToFm;

    @Arg Student student;

    public StudentFragment newInstance(){
        return new StudentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_student, container, false);
        ButterKnife.bind(this, view);
        ActivityStarter.fill(this);
        DisplayData();

        return view;
    }

    @DebugLog
    private String DisplayData() {
        txtName.setText(student.name);
        txtGrade.setText(String.valueOf(student.grade));
        txtNumber.setText(String.valueOf(student.id));
        return String.valueOf("Name : " + student.name + " Number : " + student.id + " Grade : " + student.grade);
    }

    @OnClick(R.id.btnSendDataFmToFm)
    public void SendDataFragmentToFragment(View v){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ResultStudentFragment fragment = ResultStudentFragmentStarter.newInstance(student);
        ft.replace(R.id.BlankLayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
