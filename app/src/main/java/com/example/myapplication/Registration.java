package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        this.findViewById(R.id.RegistrationButton).setOnClickListener(v -> {
            String name = ((EditText) this.findViewById(R.id.name))
                    .getText().toString();
            String username = ((EditText) this.findViewById(R.id.username))
                    .getText().toString();
            String email = ((EditText) this.findViewById(R.id.email))
                    .getText().toString();
            String password = ((EditText) this.findViewById(R.id.password))
                    .getText().toString();
            if(name.isEmpty() | username.isEmpty() | email.isEmpty() | password.isEmpty()) {
                Toast.makeText(
                                this.getApplicationContext(),
                                R.string.messaggio,
                                Toast.LENGTH_SHORT)
                        .show();
            } else {
                User user = new User(name, username, email, password);
                AppDatabase db = Room.databaseBuilder(
                        getApplicationContext(),
                        AppDatabase.class, "database").build();

                UserDao userDao = db.userDao();
                userDao.insertUsers(user);
            }
        });
        this.findViewById(R.id.log).setOnClickListener(v -> {
            Intent firstIntent = new Intent(this, LogIn.class);
            startActivity(firstIntent);
        });
    }
}
