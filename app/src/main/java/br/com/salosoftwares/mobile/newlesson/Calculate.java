package br.com.salosoftwares.mobile.newlesson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Calculate extends AppCompatActivity {

    private EditText firstValue;
    private EditText secondValue;
    private Button calcSum;
    private Button calcSub;
    private Button calcDiv;
    private Button calcMult;
    private TextView result;

    private SharedPreferences dbTest;
    private Boolean sumClicked;
    private Boolean subClicked;
    private Boolean divClicked;
    private Boolean multClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        firstValue = findViewById(R.id.etxt_first_value);
        secondValue = findViewById(R.id.etxt_second_value);
        calcSum = findViewById(R.id.btn_calculate_sum);
        calcSub = findViewById(R.id.btn_calculate_sub);
        calcDiv = findViewById(R.id.btn_calculate_div);
        calcMult = findViewById(R.id.btn_calculate_mult);
        result = findViewById(R.id.txt_result);

        dbTest = getSharedPreferences("dbTest", Context.MODE_PRIVATE);

        sumClicked = dbTest.getBoolean("sumClicked", false);
        subClicked = dbTest.getBoolean("sumClicked", false);
        divClicked = dbTest.getBoolean("sumClicked", false);
        multClicked = dbTest.getBoolean("sumClicked", false);

        result.setText(dbTest.getString("result", String.valueOf(R.string.txt_resultStr)));

        if (sumClicked) {
            calcSum.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcSum.setText("Sum clicked");
        }

        if (subClicked) {
            calcSub.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcSub.setText("Sub clicked");
        }

        if (divClicked) {
            calcDiv.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcDiv.setText("Div clicked");
        }

        if (multClicked) {
            calcMult.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcMult.setText("Mult clicked");
        }


        calcSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(firstValue.getText().toString());
                int b = Integer.parseInt(secondValue.getText().toString());
                String resultString = Integer.toString(Calculations.sub(a, b));
                result.setText(resultString);
                Log.i("Clicked", "Button sub was clicked");
            }
        });

        calcDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(firstValue.getText().toString());
                int b = Integer.parseInt(secondValue.getText().toString());
                String resultString = Integer.toString(Calculations.div(a, b));
                result.setText(resultString);
                Log.i("Clicked", "Button div was clicked");
            }
        });

        calcMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(firstValue.getText().toString());
                int b = Integer.parseInt(secondValue.getText().toString());
                String resultString = Integer.toString(Calculations.mult(a, b));
                result.setText(resultString);
                Log.i("Clicked", "Button mult was clicked");
            }
        });

    }

    @SuppressLint("ResourceType")
    public void funCalcSum(View view){

        if (!sumClicked) {
            Log.i("Click", "Button sum was clicked");
            calcSum.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.black));
            calcSum.setText("Sum clicked");
            sumClicked=true;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("sumClicked",true);
            editor.apply();

        }else{
            calcSum.setBackgroundTintList(ContextCompat.getColorStateList(this, R.drawable.bg_button_accent));
            calcSum.setText(R.string.btn_calculate_sumStr);
            Log.i("Click", "Button sum was 'Unclicked'");
        }

        int a = Integer.parseInt(firstValue.getText().toString());
        int b = Integer.parseInt(secondValue.getText().toString());
        String resultString = Integer.toString(Calculations.sum(a, b));
        result.setText(resultString);
    }


}