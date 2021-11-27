package com.example.student_app_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {
    EditText nameEt;
    EditText idEt;
    EditText phone;
    EditText address;
    CheckBox cb;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.main_name_ET);
        idEt = findViewById(R.id.main_id_ET);
        phone = findViewById(R.id.main_phone_ET);
        address = findViewById(R.id.main_address_ET);
        cb = findViewById(R.id.main_checkBox);
        edit = findViewById(R.id.main_BT_edit);

    }

//Testing
}