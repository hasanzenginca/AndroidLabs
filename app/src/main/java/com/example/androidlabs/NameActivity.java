
package com.example.androidlabs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        Button dontCallButton = findViewById(R.id.dontCallButton);
        Button thankYouButton = findViewById(R.id.thankYouButton);

        String name = getIntent().getStringExtra("user_name");

        if (name == null) {
            name = "";
        }

        welcomeTextView.setText(
                getString(R.string.welcome_message, name)
        );

        dontCallButton.setOnClickListener(v -> {
            setResult(0);
            finish();
        });

        thankYouButton.setOnClickListener(v -> {
            setResult(1);
            finish();
        });
    }
}
