package com.android.dmaharjan.primenumberchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputNumberEditText = (EditText) findViewById(R.id.inputNumberEditText);
        Button btnCheck = (Button) findViewById(R.id.buttonCheck);
        final TextView tvResult = (TextView) findViewById(R.id.result);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumberEditText.getText().toString();
                if (!input.isEmpty()) {
                    int inputNumber = Integer.parseInt(input);
                    boolean result = isPrimeNumber(inputNumber);
                    if (result) {
                        tvResult.setTextColor(getResources().getColor(R.color.colorGreen));
                        tvResult.setText("Is a prime number.");
                    } else {
                        tvResult.setTextColor(getResources().getColor(R.color.colorRed));
                        tvResult.setText("Is not a prime number.");
                    }
                } else {
                    tvResult.setTextColor(getResources().getColor(R.color.colorWarning));
                    tvResult.setText("Please input a number.");
                }
            }
        });
    }

    private boolean isPrimeNumber(int n) {
        if (n >= 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
