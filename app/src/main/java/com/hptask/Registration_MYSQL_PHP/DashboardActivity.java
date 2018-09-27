package com.hptask.Registration_MYSQL_PHP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private static final String url = "http://192.168.1.102" + "/signin.php";
    String username, password;
    TextView usernameTextView, emailTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        username = i.getExtras().getString("username");
        password = i.getExtras().getString("password");
        setContentView(R.layout.dash_layout);
        usernameTextView = findViewById(R.id.usernameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        usernameTextView.setText("Welcome" + username);

    }
}
