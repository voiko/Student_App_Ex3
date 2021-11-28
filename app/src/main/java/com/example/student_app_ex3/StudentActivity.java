package com.example.student_app_ex3;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student_app_ex3.Model.Model;
import com.example.student_app_ex3.Model.Student;

import java.util.List;

public class StudentActivity extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        data = Model.instance.getAllStudents(); // bring al the students from model

        MyAdapter adapter = new MyAdapter();
        ListView listView = findViewById(R.id.studentlist_listv);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG","Row was Clicked!" + position);
            }
        });

//        Model model = new Model();
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) { return null; }

        @Override
        public long getItemId(int position) { return 0; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {// position is num of row
            //convertView must check if is the first
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.student_list_row, null); // null in order to be independeded
                CheckBox cb = convertView.findViewById(R.id.listrow_cb);
                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = Integer.parseInt(v.getTag().toString());
                        Log.d("TAG","CheckBox Position" + position);
                        Student s = data.get(pos);
                        s.setFlag(cb.isChecked());
                    }
                });
            }
            TextView nameTv = convertView.findViewById(R.id.listrow_name_tv);
            TextView idTv = convertView.findViewById(R.id.listrow_id_tv);
            CheckBox cb = convertView.findViewById(R.id.listrow_cb);
            cb.setTag(position);

            Student student = data.get(position);
            nameTv.setText(student.getName());
            idTv.setText(student.getId());
            cb.setChecked(student.isFlag());
            return convertView;
        }
    }
}