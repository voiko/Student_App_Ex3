package com.example.student_app_ex3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;
import com.example.student_app_ex3.Model.Model;
import com.example.student_app_ex3.Model.Student;

public class StudentListRvActivity extends AppCompatActivity {

    List<Student> data;
    Button newStud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_rv_acivity);

        data = Model.instance.getAllStudents();
        View setLayout = findViewById(R.id.layout_row);
        RecyclerView list = findViewById(R.id.studentlist_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);
        newStud = findViewById(R.id.main_btn);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("TAG","row was clicked " + position); // get the click on the list
            }
        });
    }

    public void setLayout(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void newStudent(View v){
        Intent intent = new Intent(this, NewStudentActivity.class);
        startActivity(intent);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.listrow_name_tv);
            idTv = itemView.findViewById(R.id.listrow_id_tv);
            cb = itemView.findViewById(R.id.listrow_cb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition(); //the click on the item
                    listener.onItemClick(pos);
                    Student student = data.get(pos);
                    student.setFlag(cb.isChecked());
                    Log.d("TAG","cb position" + pos);
//                    setLayout(v);
                }
            });
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        OnItemClickListener listener;
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            MyViewHolder holder = new MyViewHolder(view,listener);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);
            holder.nameTv.setText(student.getName());
            holder.idTv.setText(student.getId());
            holder.cb.setChecked(student.isFlag());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}