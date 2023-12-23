package com.example.button_interactions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.topLeftButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("You have clicked TOP LEFT button");
            }
        });

        findViewById(R.id.topRightButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("You have clicked TOP RIGHT button");
            }
        });

        findViewById(R.id.bottomLeftButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("You have clicked BOTTOM LEFT button");
            }
        });

        findViewById(R.id.bottomRightButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("You have clicked BOTTOM RIGHT button");
            }
        });

        findViewById(R.id.centerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("You have clicked ANDROID button");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}