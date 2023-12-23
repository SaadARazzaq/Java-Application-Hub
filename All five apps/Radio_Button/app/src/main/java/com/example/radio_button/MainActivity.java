package com.example.radio_button;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioSpain, radioItaly, radioFrance;
    private Spinner citySpinner;
    private Button submitButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        radioSpain = findViewById(R.id.radioSpain);
        radioItaly = findViewById(R.id.radioItaly);
        radioFrance = findViewById(R.id.radioFrance);
        citySpinner = findViewById(R.id.citySpinner);
        submitButton = findViewById(R.id.submitButton);
        resultText = findViewById(R.id.resultText);

        // Set up the spinner with default values
        setupCitySpinner();

        // Set onClickListener for the Submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmission();
            }
        });
    }

    private void setupCitySpinner() {
        // Dummy data for cities
        final String[] spainCities = {"Barcelona", "Madrid", "Seville", "Valencia"};
        final String[] italyCities = {"Rome", "Venice", "Florence", "Milan"};
        final String[] franceCities = {"Paris", "Marseille", "Nice", "Lyon"};

        // Initialize spinner adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        // Set default values
        updateCitySpinner(spainCities);

        // Set OnItemSelectedListener to handle country selection
        final RadioGroup countryRadioGroup = findViewById(R.id.countryRadioGroup);
        countryRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioSpain) {
                    updateCitySpinner(spainCities);
                } else if (checkedId == R.id.radioItaly) {
                    updateCitySpinner(italyCities);
                } else if (checkedId == R.id.radioFrance) {
                    updateCitySpinner(franceCities);
                } else {
                    updateCitySpinner(new String[]{"No City"});
                }
            }
        });
    }

    private void updateCitySpinner(String[] cities) {
        final ArrayAdapter<String> adapter = (ArrayAdapter<String>) citySpinner.getAdapter();
        adapter.clear();
        adapter.addAll(cities);
    }

    private void handleSubmission() {
        // Get selected country and city
        String selectedCountry = "";
        String selectedCity = "";

        int selectedCountryId = ((RadioGroup) findViewById(R.id.countryRadioGroup)).getCheckedRadioButtonId();
        if (selectedCountryId != -1) {
            RadioButton selectedCountryRadioButton = findViewById(selectedCountryId);
            selectedCountry = selectedCountryRadioButton.getText().toString();
        }

        if (citySpinner.getSelectedItem() != null) {
            selectedCity = citySpinner.getSelectedItem().toString();
        }

        // Display the result
        if (!selectedCountry.isEmpty() && !selectedCity.isEmpty()) {
            resultText.setText("Selected country: " + selectedCountry + "\nSelected City: " + selectedCity);
        } else {
            resultText.setText("PLEASE SELECT BOTH CITY AND COUNTRY");
        }
    }
}
