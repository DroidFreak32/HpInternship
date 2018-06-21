package com.example.horcrux.hptask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[] num_buttons;
    Button clearButton,plusButton,minusButton,divideButton,multiplyButton,equalsButton;
    EditText input;
    String inputText;
    double result;
    static int[] buttID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = "";
        input = findViewById(R.id.input);
        clearButton = findViewById(R.id.button_clear);
        plusButton = findViewById(R.id.button_plus);
        minusButton = findViewById(R.id.button_minus);
        multiplyButton = findViewById(R.id.button_multiply);
        divideButton = findViewById(R.id.button_divide);
        equalsButton = findViewById(R.id.button_equals);
        num_buttons = new Button[10];
        int[] buttID = new int[] {R.id.num_button_0,R.id.num_button_1,R.id.num_button_2,R.id.num_button_3,
                R.id.num_button_4,R.id.num_button_5,R.id.num_button_6,R.id.num_button_7,
                R.id.num_button_8,R.id.num_button_9};
        for (int i = 0; i < 10; i++) {
            num_buttons[i] = findViewById(buttID[i]);
            num_buttons[i].setOnClickListener(this);
        }
        clearButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        equalsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Button currentButton = findViewById(view.getId());
        switch (view.getId()){

            case R.id.button_clear:
                inputText = "";
                input.setText(inputText);
                break;
            case R.id.button_equals:
                result = eval(input.getText().toString());
                inputText = Double.toString(result);
                Toast.makeText(getApplicationContext(),inputText,Toast.LENGTH_SHORT).show();
                input.setText(inputText);
                break;
            default:
                inputText += currentButton.getText().toString();
                input.setText(inputText);
                break;
        }

    }

    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
