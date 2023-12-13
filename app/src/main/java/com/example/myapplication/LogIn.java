package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.List;

public class LogIn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        this.findViewById(R.id.Loginbutton).setOnClickListener(v -> {
            String username = ((EditText) this.findViewById(R.id.username))
                    .getText().toString();
            String password = ((EditText) this.findViewById(R.id.password))
                    .getText().toString();
            Log.i("myInfoTag", username + " " + password);
            if(username.isEmpty() && password.isEmpty()) {
                Toast.makeText(
                                this.getApplicationContext(),
                                R.string.messaggio,
                                Toast.LENGTH_SHORT)
                        .show();
            } else {
                Log.i("myInfoTag", username + " " + password);
                AppDatabase db = Room.databaseBuilder(
                        getApplicationContext(),
                        AppDatabase.class, "database").build();

                UserDao userDao = db.userDao();
                Log.i("myInfoTag", userDao.toString());
                List<User> users = userDao.findByUserPass(username, password);






                if(!users.isEmpty()) {
                    Toast.makeText(
                                    this.getApplicationContext(),
                                    R.string.notInDatabase,
                                    Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Intent firstIntent = new Intent(this, MainActivity.class);
                    startActivity(firstIntent);
                }
            }
        });
        this.findViewById(R.id.registrazione).setOnClickListener(v -> {
            Intent firstIntent = new Intent(this, Registration.class);
            startActivity(firstIntent);
        });
    }
}
