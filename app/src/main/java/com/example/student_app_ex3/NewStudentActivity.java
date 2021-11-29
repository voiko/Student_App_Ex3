package com.example.student_app_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.student_app_ex3.Model.Model;
import com.example.student_app_ex3.Model.Student;

public class NewStudentActivity extends AppCompatActivity {
    public final static String MESSAGE_KEY ="com.example.message_key";

    Student studentData;
    EditText name;
    EditText id;
    EditText phone;
    EditText address;
    CheckBox cb;
    Button save;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        save  = findViewById(R.id.save_btn);
        cancel  = findViewById(R.id.cancel_btn);
        name=findViewById(R.id.new_name);
        id=findViewById(R.id.new_id);
        phone=findViewById(R.id.new_phone);
        address=findViewById(R.id.new_address);
        cb=findViewById(R.id.main_checkBox3);

       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               saveData();
               Cancel();
           }
       });

       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Cancel();
           }
       });
    }

    private void saveData() {
        String name1=name.getText().toString();
        String id1=id.getText().toString();
        String phone1=phone.getText().toString();
        String address1=address.getText().toString();
        boolean cb1=cb.isChecked();
        Log.d("TAG","CB: " + cb.isChecked());
        Student newStudent=new Student(name1,id1,phone1,address1,cb1);
        Model.instance.addStudent(newStudent);
        finish();
    }

    public void Cancel(){
        Intent intent = new Intent(this, StudentListRvActivity.class);
        startActivity(intent);
    }
}