package com.example.catalogue;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView animalImage = findViewById(R.id.animalImage);
        TextView animalNameText = findViewById(R.id.animalNameText);
        TextView descriptionText = findViewById(R.id.descriptionText);
        View backButton = findViewById(R.id.backButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String animalName = extras.getString("animalName");
            int imageResource = extras.getInt("imageResource");

            animalNameText.setText(animalName);
            animalImage.setImageResource(imageResource);

            // Set description text based on the selected animal
            String description = getAnimalDescription(animalName);
            descriptionText.setText(description);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private String getAnimalDescription(String animalName) {
        switch (animalName) {
            case "Capybara":
                return getString(R.string.capybara_description);
            case "Chinchilla":
                return getString(R.string.chinchilla_description);
            case "Guinea Pig":
                return getString(R.string.guinea_pig_description);
            case "Marmot":
                return getString(R.string.marmot_description);
            default:
                return getString(R.string.default_description);
        }
    }
}
