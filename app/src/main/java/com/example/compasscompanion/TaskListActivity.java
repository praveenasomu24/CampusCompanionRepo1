package com.example.compasscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskListActivity extends AppCompatActivity {

    String[] titles = {
            "Submit Assignment",
            "Attend Lecture",
            "Read Chapter",
            "Complete Quiz",
            "Do Lab Work",
            "Prepare Notes",
            "Team Meeting",
            "Practice Coding"
    };

    String[] descriptions = {
            "Submit the mobile computing assignment before the deadline.",
            "Attend today’s class lecture and participate actively.",
            "Read the assigned chapter from the textbook.",
            "Complete the quiz available on Blackboard.",
            "Finish the lab exercise for this week.",
            "Prepare notes for revision and exam study.",
            "Join the group meeting for the team project.",
            "Practice Android coding and activity navigation."
    };

    String[] priorities = {
            "High",
            "Medium",
            "Low",
            "High",
            "Medium",
            "Low",
            "Medium",
            "High"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Log.d("LIFECYCLE", "onCreate called");

        TextView tvWelcome = findViewById(R.id.tvWelcome);
        ListView listTasks = findViewById(R.id.listTasks);

        String username = getIntent().getStringExtra("username");
        if (username == null || username.isEmpty()) {
            username = "Student";
        }

        tvWelcome.setText("Welcome, " + username);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titles
        );

        listTasks.setAdapter(adapter);

        listTasks.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);
            intent.putExtra("title", titles[position]);
            intent.putExtra("description", descriptions[position]);
            intent.putExtra("priority", priorities[position]);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy called");
    }
}