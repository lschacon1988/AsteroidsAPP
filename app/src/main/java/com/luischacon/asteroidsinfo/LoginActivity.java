package com.luischacon.asteroidsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luischacon.asteroidsinfo.db.SQLiteOpenHelper;

public class LoginActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btnLogin;

    SQLiteOpenHelper helper = new SQLiteOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txt_email_login);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor consultUsers = helper.consultarUser(txtEmail.getText().toString(),
                                       txtPassword.getText().toString());
                if( consultUsers.getCount() > 0){
                    Toast.makeText(getApplicationContext(),"Usuario logeado", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Error al loger usuario", Toast.LENGTH_LONG).show();

                }
                txtEmail.setText("");
                txtPassword.setText("");
                txtEmail.findFocus();

            }
        });


    }
}