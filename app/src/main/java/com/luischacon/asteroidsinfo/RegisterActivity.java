package com.luischacon.asteroidsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luischacon.asteroidsinfo.db.SQLiteOpenHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText txt_username, txt_first_name, txt_last_name, txt_email, txt_register_pass;
    Button btn_register_form;

    SQLiteOpenHelper helper = new SQLiteOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_username = findViewById(R.id.txt_username);
        txt_first_name = findViewById(R.id.txt_name);
        txt_last_name = findViewById(R.id.txt_last_name);
        txt_email = findViewById(R.id.txt_email);
        txt_register_pass = findViewById(R.id.txt_register_pass);

        btn_register_form = findViewById(R.id.btn_register_form);

        btn_register_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txt_email.getText().toString();
                String password = txt_register_pass.getText().toString();

                // Valida el correo electrónico
                if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    Toast.makeText(getApplicationContext(), "El correo electrónico no es válido",Toast.LENGTH_LONG).show();
                    return;
                }

                // Valida la contraseña
                if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
                    Toast.makeText(getApplicationContext(), "La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula, un número y un carácter especial",Toast.LENGTH_LONG).show();
                    return;
                }

                helper.open();

                helper.insertUser(txt_username.getText().toString(),txt_register_pass.getText().toString(),txt_first_name.getText().toString(),txt_last_name.getText().toString(),txt_email.getText().toString());

                helper.cerra();

                Toast.makeText(getApplicationContext(), "Rgistro exitoso",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}