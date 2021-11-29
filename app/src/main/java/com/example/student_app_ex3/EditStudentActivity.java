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


public class EditStudentActivity extends AppCompatActivity {
    public final static String MESSAGE_KEY ="com.example.message_key";

    Student studentData;
    Button save;
    Button cancel;
    Button delete;
    EditText name;
    EditText id;
    EditText phone;
    EditText address;
    CheckBox cb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        save = findViewById(R.id.main_btn_save);
        cancel = findViewById(R.id.main_btn_cancel);
        delete = findViewById(R.id.main_btn_delete);
        name = findViewById(R.id.edit_name);
        id =findViewById(R.id.edit_id);
        phone = findViewById(R.id.edit_phone);
        address = findViewById(R.id.edit_address);
        cb = findViewById(R.id.Edit_checkBox2);

        Intent intentFromDetail = getIntent();
        String s = intentFromDetail.getStringExtra(MESSAGE_KEY);
        studentData = Model.instance.getStudent(s);

        oldDisplay();

        Intent intentEdit = new Intent(this,StudentListRvActivity.class);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentEdit.putExtra(MESSAGE_KEY,s);
                startActivity(intentEdit);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                intentEdit.putExtra(MESSAGE_KEY,s);
                startActivity(intentEdit);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.instance.removeStudent(studentData);
                intentEdit.putExtra(MESSAGE_KEY,s);
                startActivity(intentEdit);
            }
        });
    }

    public void oldDisplay(){
        name.setText(studentData.getName());
        id.setText(studentData.getId());
        address.setText(studentData.getAddress());
        phone.setText(studentData.getPhone());
        cb.setChecked(studentData.isFlag());
    }

    public void save(){
        String name1=name.getText().toString();
        String id1=id.getText().toString();
        String phone1=phone.getText().toString();
        String address1=address.getText().toString();
        boolean cb1=cb.isChecked();
        Log.d("TAG","CB: " + cb.isChecked());
        Student newStudent=new Student(name1,id1,phone1,address1,cb1);
        Model.instance.updateList(studentData,newStudent);
        finish();
   }
}

