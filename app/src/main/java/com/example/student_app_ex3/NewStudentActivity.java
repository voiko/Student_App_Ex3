package com.example.student_app_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
    }

    public void cancelBtn(View v){
        Intent intent = new Intent(this, StudentListRvActivity.class);
        startActivity(intent);
    }
}