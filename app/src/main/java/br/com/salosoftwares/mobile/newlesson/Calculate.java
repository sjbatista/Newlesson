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
//Parei na otimização dos botões
//preciso reorganizar a identação, usar o conceito de armazenar alguns textos usando arquivo Strings
//Preciso melhorar a interação de click e unclick
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
        subClicked = dbTest.getBoolean("subClicked", false);
        divClicked = dbTest.getBoolean("divClicked", false);
        multClicked = dbTest.getBoolean("multClicked", false);

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
    }

    @SuppressLint("ResourceType")
    public void funCalcSum(View view) {
        if (!sumClicked) {
            Log.i("Click", "Button sum was clicked");
            calcSum.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcSum.setText("Sum clicked");
            sumClicked = true;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.sum(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("sumClicked", true);
            editor.apply();
        } else {
            Log.i("Click", "Button sum was 'Unclicked'");
            calcSum.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
            calcSum.setText(R.string.btn_calculate_sumStr);
            sumClicked = false;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.sum(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("sumClicked", false);
            editor.apply();
        }
    }

    @SuppressLint("ResourceType")
    public void funCalcSub(View view) {
        if (!subClicked) {
            Log.i("Click", "Button sub was clicked");
            calcSub.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcSum.setText("Sub clicked");
            subClicked = true;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.sub(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("subClicked", true);
            editor.apply();
        } else {
            Log.i("Click", "Button sub was 'Unclicked'");
            calcSub.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
            calcSub.setText(R.string.btn_calculate_subStr);
            subClicked = false;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.sub(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("subClicked", false);
            editor.apply();
        }
    }

    @SuppressLint("ResourceType")
    public void funCalcDiv(View view) {
        if (!divClicked) {
            Log.i("Click", "Button div was clicked");
            calcDiv.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcDiv.setText("Div clicked");
            divClicked = true;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.div(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("divClicked", true);
            editor.apply();
        } else {
            Log.i("Click", "Button div was 'Unclicked'");
            calcDiv.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
            calcDiv.setText(R.string.btn_calculate_divStr);
            divClicked = false;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.div(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("divClicked", false);
            editor.apply();
        }
    }

    @SuppressLint("ResourceType")
    public void funCalcMult(View view) {
        if (!multClicked) {
            Log.i("Click", "Button mult was clicked");
            calcMult.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
            calcMult.setText("Mult clicked");
            multClicked = true;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.mult(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("multClicked", true);
            editor.apply();
        } else {
            Log.i("Click", "Button mult was 'Unclicked'");
            calcMult.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
            calcMult.setText(R.string.btn_calculate_multStr);
            multClicked = false;
            int a = Integer.parseInt(firstValue.getText().toString());
            int b = Integer.parseInt(secondValue.getText().toString());
            String resultString = Integer.toString(Calculations.mult(a, b));
            result.setText(resultString);
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("multClicked", false);
            editor.apply();
        }
    }


}