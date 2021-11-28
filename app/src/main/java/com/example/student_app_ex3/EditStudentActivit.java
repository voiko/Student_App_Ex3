package com.example.student_app_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditStudentActivit extends AppCompatActivity {

    Button save;
    Button cancel;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        save = findViewById(R.id.main_btn_save);
        cancel = findViewById(R.id.main_btn_cancel);
    }

    public void cancelBtn(View v){
        Intent intent = new Intent(this, StudentListRvActivity.class);
        startActivity(intent);
    }
}