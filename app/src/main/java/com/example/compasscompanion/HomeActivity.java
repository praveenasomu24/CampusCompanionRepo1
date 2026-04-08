package com.example.compasscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    EditText etName;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etName = findViewById(R.id.etName);
        btnGo = findViewById(R.id.btnGo);

        if (savedInstanceState != null) {
            String savedName = savedInstanceState.getString("username");
            if (savedName != null) {
                etName.setText(savedName);
            }
        }

        btnGo.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(HomeActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(HomeActivity.this, TaskListActivity.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username", etName.getText().toString());
    }
}