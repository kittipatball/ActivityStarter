package kittipat.activitystarterex.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kittipat on 26-Apr-17.
 */

public class Student implements Parcelable {

    public int id;
    public String name;
    public String grade;
    public boolean passing;

    public Student(int id, String name, String grade, boolean passing) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.passing = passing;
    }

    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        grade = in.readString();
        passing = in.readByte() != 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(grade);
        dest.writeByte((byte) (passing ? 1 : 0));
    }
}
