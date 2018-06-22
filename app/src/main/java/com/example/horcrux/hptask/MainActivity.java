package com.example.horcrux.hptask;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button redButton, greenButton, blueButton;
    String[] enteredText;
    Drawable defaultColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        redButton = findViewById(R.id.button);
        greenButton = findViewById(R.id.button2);
        blueButton = findViewById(R.id.button3);
        defaultColor = redButton.getBackground();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                enteredText = editText.getText().toString().toLowerCase().split(",");
                boolean r = false, g = false, b = false;
                for (String text : enteredText) {

                    if (text.matches("(red|green|blue)")) {
                        if (text.contains("red")) {

                            redButton.setBackgroundColor(Color.RED);
                            r = true;

                        }
                        if (text.contains("green")) {
                            greenButton.setBackgroundColor(Color.GREEN);
                            g = true;
                        }
                        if (text.contains("blue")) {
                            blueButton.setBackgroundColor(Color.BLUE);
                            b = true;
                        }

                    }
                    if (!b)
                        blueButton.setBackground(defaultColor);
                    if (!r)
                        redButton.setBackground(defaultColor);
                    if (!g)
                        greenButton.setBackground(defaultColor);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
