package com.example.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_sign;
    Button btn_dot;
    Button btn_add;
    Button btn_sub;
    Button btn_multi;
    Button btn_div;
    Button btn_equal;
    Button btn_ce;
    Button btn_c;
    Button btn_bs;
    TextView txt_cal;
    TextView txt_result;
    String calculation = "";
    String result = "";
    boolean isDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_sign = findViewById(R.id.btn_sign);
        btn_dot = findViewById(R.id.btn_dot);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_multi = findViewById(R.id.btn_multi);
        btn_div = findViewById(R.id.btn_div);
        btn_equal = findViewById(R.id.btn_equal);
        btn_ce = findViewById(R.id.btn_ce);
        btn_c = findViewById(R.id.btn_c);
        btn_bs = findViewById(R.id.btn_bs);
        txt_cal = findViewById(R.id.txt_cal);
        txt_result = findViewById(R.id.txt_result);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_sign.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_ce.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_bs.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (isDone) {
            if (v.getId() == btn_add.getId() || v.getId() == btn_sub.getId() || v.getId() == btn_multi.getId() || v.getId() == btn_div.getId())
                calculation = result;
            else calculation = "";
            result = "";
            isDone = false;
        }
        if (v.getId() == btn_0.getId()) {
            result += "0";
        }
        if (v.getId() == btn_1.getId()) {
            result += "1";
        }
        if (v.getId() == btn_2.getId()) {
            result += "2";
        }
        if (v.getId() == btn_3.getId()) {
            result += "3";
        }
        if (v.getId() == btn_4.getId()) {
            result += "4";
        }
        if (v.getId() == btn_5.getId()) {
            result += "5";
        }
        if (v.getId() == btn_6.getId()) {
            result += "6";
        }
        if (v.getId() == btn_7.getId()) {
            result += "7";
        }
        if (v.getId() == btn_8.getId()) {
            result += "8";
        }
        if (v.getId() == btn_9.getId()) {
            result += "9";
        }
        if (v.getId() == btn_dot.getId()) {
            result += ".";
        }
        if (v.getId() == btn_sign.getId()) {
            result = "-" + result;
        }
        if (v.getId() == btn_add.getId()) {
            calculation += result;
            calculation += "+";
            result = "";
        }
        if (v.getId() == btn_sub.getId()) {
            calculation += result;
            calculation += "-";
            result = "";
        }
        if (v.getId() == btn_multi.getId()) {
            calculation += result;
            calculation += "*";
            result = "";
        }
        if (v.getId() == btn_div.getId()) {
            calculation += result;
            calculation += "/";
            result = "";
        }
        if (v.getId() == btn_equal.getId()) {
            calculation += result;
            calculation += "=";
            result = calculate(calculation);
            isDone = true;
        }
        if (v.getId() == btn_ce.getId()) {
            //Xoa so dang nhap
            result = "";
        }
        if (v.getId() == btn_c.getId()) {
            //Xoa het
            calculation = "";
            result = "";
        }
        if (v.getId() == btn_bs.getId()) {
            //Xoa 1 ki tu phia truoc
            if (result.length() > 1) result = result.substring(0, result.length() - 1);
            else result = "";
        }
        txt_cal.setText(calculation);
        txt_result.setText(result);
    }

    String calculate(String calculation) {
        Stack<Float> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String temp = "";
        Float result = (float) 0;
        for (int i = 0; i < calculation.length(); i++) {
            if (Character.isDigit(calculation.charAt(i)) || calculation.charAt(i) == '.') {
                temp = temp.concat(String.valueOf(calculation.charAt(i)));
            } else {
                numStack.push(Float.parseFloat(temp));
                temp = "";
                if (calculation.charAt(i) == '=') {
                    while (operatorStack.size() != 0) {
                        Float subResult = subCalc(numStack.pop(), numStack.pop(), operatorStack.pop());
                        numStack.push(subResult);
                    }
                    result = numStack.pop();
                }
                if (operatorStack.size() == 0) {
                    operatorStack.push(calculation.charAt(i));
                    continue;
                }
                if (calculation.charAt(i) == '+' || calculation.charAt(i) == '-') {
                    while (operatorStack.size() != 0) {
                        Float subResult = subCalc(numStack.pop(), numStack.pop(), operatorStack.pop());
                        numStack.push(subResult);
                    }
                    operatorStack.push(calculation.charAt(i));
                }
                if (calculation.charAt(i) == '*' || calculation.charAt(i) == '/') {
                    while (operatorStack.peek() == '*' || operatorStack.peek() == '/') {
                        Float subResult = subCalc(numStack.pop(), numStack.pop(), operatorStack.pop());
                        numStack.push(subResult);
                    }
                    operatorStack.push(calculation.charAt(i));
                }
            }
        }
        return result.toString();
    }

    Float subCalc(Float a, Float b, Character operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
            default:
                return (float) 0;
        }
    }

}
