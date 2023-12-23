package com.example.login_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView attemptsTextView;
    private int loginAttempts = 3; // Initialize with the maximum attempts
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        attemptsTextView = findViewById(R.id.attemptsTextView);

        // Initialize the attemptsTextView with the maximum attempts
        updateAttemptsTextView();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidCredentials(username, password)) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Proceed with the next steps after successful login
                } else {
                    loginAttempts--;
                    updateAttemptsTextView();

                    if (loginAttempts <= 0) {
                        Toast.makeText(MainActivity.this, "Exceeded maximum login attempts. App will now close.", Toast.LENGTH_SHORT).show();
                        finishAffinity(); // Close the app
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid username or password. Attempts remaining: " +
                                loginAttempts, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }

    private void updateAttemptsTextView() {
        attemptsTextView.setText("Login attempts: " + loginAttempts);
    }
}
