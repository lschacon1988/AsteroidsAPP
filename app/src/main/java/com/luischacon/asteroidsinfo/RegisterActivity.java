package com.luischacon.asteroidsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText txt_username, txt_name, txt_last_name, txt_email, txt_register_pass;
    Button btn_register_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_username = findViewById(R.id.txt_username);
        txt_name = findViewById(R.id.txt_name);
        txt_last_name = findViewById(R.id.txt_last_name);
        txt_email = findViewById(R.id.txt_email);
        txt_register_pass = findViewById(R.id.txt_register_pass);

        btn_register_form = findViewById(R.id.btn_register_form);

        System.out.printf(String.valueOf(txt_name));
    }
}