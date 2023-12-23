package com.example.catalogue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome to Animal Gallery, Select the animal you want to see information of:");

        Button capybaraButton = findViewById(R.id.capybaraButton);
        Button chinchillaButton = findViewById(R.id.chinchillaButton);
        Button guineaPigButton = findViewById(R.id.guineaPigButton);
        Button marmotButton = findViewById(R.id.marmotButton);

        capybaraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity("Capybara", R.drawable.capybara_image);
            }
        });

        chinchillaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity("Chinchilla", R.drawable.chinchilla_image);
            }
        });

        guineaPigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity("Guinea Pig", R.drawable.guinea_pig_image);
            }
        });

        marmotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity("Marmot", R.drawable.marmot_image);
            }
        });
    }

    private void openDetailActivity(String animalName, int imageResource) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("animalName", animalName);
        intent.putExtra("imageResource", imageResource);
        startActivity(intent);
    }
}
