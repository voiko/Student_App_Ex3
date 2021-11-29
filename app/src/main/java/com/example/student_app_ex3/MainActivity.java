package com.example.student_app_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.example.student_app_ex3.Model.Model;
import com.example.student_app_ex3.Model.Student;

import java.util.List;


public class MainActivity extends AppCompatActivity  {
    public final static String MESSAGE_KEY ="com.example.message_key";
    Student studentData;
    TextView nameVt;
    TextView idVt;
    TextView phoneVt;
    TextView addresTV;
    CheckBox cb;
    Button edit;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameVt = findViewById(R.id.main_name_vt);
        idVt = findViewById(R.id.main_id_vt);
        phoneVt = findViewById(R.id.main_phone_vt);
        addresTV = findViewById(R.id.main_address_vt);
        cb = findViewById(R.id.main_checkBox);
        edit = findViewById(R.id.main_BT_edit);
        add = findViewById(R.id.main_btn);


        Intent intent = getIntent();
        String s = intent.getStringExtra(MESSAGE_KEY);
        studentData = Model.instance.getStudent(s);

        setData(studentData);

        Intent intentEdit = new Intent(this,EditStudentActivit.class);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentEdit.putExtra(MESSAGE_KEY,s);
                startActivity(intentEdit);
            }
        });

//        nameVt.setText(data.get(0).getName());
//        idVt.setText(data.get(0).getId());
//        phoneVt.setText(data.get(0).getId());
//        addressVt.setText(data.get(0).getId());
//        Log.d("TAG","save set: " + nameVt.getText().toString());
//        Log.d("TAG","save set: " + idVt.getText().toString());
//        Log.d("TAG","save set: " + phoneVt.getText().toString());
//        Log.d("TAG","save set: " + addressVt.getText().toString());

    }

    private void setData(Student stData) {
        nameVt.setText(stData.getName().toString());
        idVt.setText(stData.getId().toString());
        phoneVt.setText(stData.getPhone().toString());
        addresTV.setText(stData.getAddress().toString());
        cb.setChecked(stData.isFlag());
    }


//    public void editStudent(View v){
//        Intent intent = new Intent(this, EditStudentActivit.class);
//        startActivity(intent);
//    }


}