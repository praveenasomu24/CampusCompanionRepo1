package com.example.compasscompanion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    TextView tvTitle, tvDescription, tvPriority;
    Button btnComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvPriority = findViewById(R.id.tvPriority);
        btnComplete = findViewById(R.id.btnComplete);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String priority = getIntent().getStringExtra("priority");

        if (title == null || description == null || priority == null) {
            Toast.makeText(this, "Task data missing", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        tvTitle.setText(title);
        tvDescription.setText(description);
        tvPriority.setText("Priority: " + priority);

        btnComplete.setOnClickListener(v ->
                Toast.makeText(TaskDetailActivity.this, "Task marked complete!", Toast.LENGTH_SHORT).show()
        );
    }
}