package com.example.androidlabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private static final int NAME_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        Button nextButton = findViewById(R.id.nextButton);

        SharedPreferences preferences =
                getSharedPreferences("UserPreferences", MODE_PRIVATE);

        String savedName = preferences.getString("user_name", "");

        nameEditText.setText(savedName);

        nextButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();

            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("user_name", name);

            startActivityForResult(intent, NAME_REQUEST);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences preferences =
                getSharedPreferences("UserPreferences", MODE_PRIVATE);

        preferences.edit()
                .putString("user_name", nameEditText.getText().toString())
                .apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NAME_REQUEST) {
            if (resultCode == 0) {
                nameEditText.requestFocus();
            } else if (resultCode == 1) {
                finish();
            }
        }
    }
}
