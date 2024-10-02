package com.example.td1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    private int currentTextSize = 14;
    private boolean isColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        Button updateButton = findViewById(R.id.updateButton);
        Button colorButton = findViewById(R.id.colorButton);
        Button sizeButton = findViewById(R.id.sizeButton);

        updateButton.setOnClickListener(v -> {
            String enteredText = editText.getText().toString();
            textView.setText(enteredText);
        });

        colorButton.setOnClickListener(v -> {
            if (!isColorChanged) {
                textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            } else {
                textView.setTextColor(getResources().getColor(android.R.color.black));
            }
            isColorChanged = !isColorChanged;
        });

        sizeButton.setOnClickListener(v -> {
            currentTextSize += 2;
            if (currentTextSize > 24) {
                currentTextSize = 14;
            }
            textView.setTextSize(currentTextSize);
        });
    }
}