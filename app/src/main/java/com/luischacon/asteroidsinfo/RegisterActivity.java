package com.luischacon.asteroidsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luischacon.asteroidsinfo.db.DbManager;

public class RegisterActivity extends AppCompatActivity {

    EditText txt_username, txt_first_name, txt_last_name, txt_email, txt_register_pass;
    Button btn_register_form;

    //SQLiteOpenHelper helper = new SQLiteOpenHelper(this);
    DbManager db = new DbManager(this);

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
                String username = txt_username.getText().toString();
                String first_name = txt_first_name.getText().toString();
                String last_name = txt_last_name.getText().toString();

                if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(), "El Username es Requerido",Toast.LENGTH_LONG).show();
                    return;
                }
                if(first_name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "El Nombre  es Requerido",Toast.LENGTH_LONG).show();
                    return;
                }
                if(last_name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "El Apellido es Requerido",Toast.LENGTH_LONG).show();
                    return;
                }


                // Valida el correo electrónico
                if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    Toast.makeText(getApplicationContext(), "El correo electrónico no es válido",Toast.LENGTH_LONG).show();
                    return;
                }

                if(db.isEmailExists(email)){
                    Toast.makeText(getApplicationContext(), "El correo electrónico ya esta registrago",Toast.LENGTH_LONG).show();
                    return;
                }


                // Valida la contraseña
                if (!password.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$")) {
                    Toast.makeText(getApplicationContext(), "La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula y un número",Toast.LENGTH_LONG).show();
                    return;
                }

                db.open();

                db.insertUser(username,
                        password,
                        first_name,
                        last_name,
                        email);

                db.cerra();

                Toast.makeText(getApplicationContext(), "Rgistro exitoso",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}