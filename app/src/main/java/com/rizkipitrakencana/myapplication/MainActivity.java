package com.rizkipitrakencana.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstname, lastname;
    TextView textView;
    DB_controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname =(EditText) findViewById(R.id.nama1);
        lastname =(EditText) findViewById(R.id.nama2);
        textView =(TextView) findViewById(R.id.textview);
        controller=new DB_controller(this,"",null,1);
    }
    public void btn_click(View view){
        switch (view.getId()){
            case R.id.btnadd:
                try {
                    controller.insert_student(firstname.getText().toString(),lastname.getText().toString());
                }catch (SQLiteException e){
                    Toast.makeText(MainActivity.this, "Sudah Ada",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btndel:
                controller.delete_student(firstname.getText().toString());
                break;
            case R.id.btnlist:
                controller.list_all_students(textView);
                break;
        }
    }
}