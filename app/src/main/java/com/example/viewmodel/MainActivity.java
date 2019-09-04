package com.example.viewmodel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private final String SAVED_NUMBER = "savedNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.numberShow);
        RandomNumberGenerator generator = new RandomNumberGenerator();
        textView.setText(generator.getNumber());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!textView.getText().toString().isEmpty()) {
            outState.putInt(SAVED_NUMBER, Integer.valueOf(textView.getText().toString()));
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(SAVED_NUMBER)) {
            textView.setText(String.valueOf(savedInstanceState.getInt(SAVED_NUMBER)));
        } else {
            RandomNumberGenerator generator = new RandomNumberGenerator();
            textView.setText(generator.getNumber());
        }
    }
}
