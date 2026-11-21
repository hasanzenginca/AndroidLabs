package com.example.androidlabs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_contraint);
        getWindow().getDecorView().setSystemUiVisibility(0);

        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkBox);

        // Update the label when the button is clicked.
        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            textView.setText(text);

            Toast.makeText(
                    this,
                    getResources().getString(R.string.toast_message),
                    Toast.LENGTH_SHORT
            ).show();
        });

        // Show a Snackbar when the checkbox changes.
        checkBox.setOnCheckedChangeListener((cb, isChecked) -> {

            String status = isChecked
                    ? getString(R.string.on_text)
                    : getString(R.string.off_text);

            String message = getString(R.string.snackbar_message)
                    + " " + status;

            Snackbar.make(checkBox, message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo_text,
                            v -> cb.setChecked(!isChecked))
                    .show();
        });
    }
}
