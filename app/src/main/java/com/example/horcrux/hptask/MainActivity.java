package com.example.horcrux.hptask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    String[] enteredNumbers;
    int[] numbers;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // int numSplits = editText.getText().toString().split(" ").length;
                // enteredNumbers = new String[numSplits+1];
                //numbers = new int[numSplits];
                enteredNumbers = editText.getText().toString().split(" ");
                for (int i = 0; i < enteredNumbers.length; i++) {
                    for (int j = 0; j < enteredNumbers.length - i - 1; j++) {
                        if (Float.parseFloat(enteredNumbers[j]) > Float.parseFloat(enteredNumbers[j + 1])) {
                            String temp = enteredNumbers[j];
                            enteredNumbers[j] = enteredNumbers[j + 1];
                            enteredNumbers[j + 1] = temp;
                        }
                    }
                }
                String sortedString = String.join("\n", enteredNumbers);
                textView.setText(sortedString);
            }
        });
    }
}
