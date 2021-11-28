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

public class MainActivity extends AppCompatActivity  {
    TextView nameVt;
    TextView idVt;
    TextView phoneVt;
    TextView addressVt;
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
        addressVt = findViewById(R.id.main_address_vt);
        cb = findViewById(R.id.main_checkBox);
        edit = findViewById(R.id.main_BT_edit);
        add = findViewById(R.id.main_btn);

    }

    public void editStudent(View v){
        Intent intent = new Intent(this, EditStudentActivit.class);
        startActivity(intent);
    }



}