package com.example.currency;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
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
    Button btn_dot;
    Button btn_ce;
    Button btn_bs;
    TextView txt_from;
    TextView txt_to;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    String valueFrom = "";
    String valueTo = "";
    Float rateFrom = (float) 0;
    Float rateTo = (float) 0;
    Integer statusChosen = 0;
    List<CurrencyModel> currencies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencies.add(new CurrencyModel("Viet Nam", "VND", "đ", (float) 23450));
        currencies.add(new CurrencyModel("United State", "USD", "$", (float) 1));
        currencies.add(new CurrencyModel("United Kingdom", "GBP", "$", (float) 0.8));
        currencies.add(new CurrencyModel("Europe", "EUR", "$", (float) 0.91));
        currencies.add(new CurrencyModel("Japan", "JPY", "$", (float) 104));
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
        btn_dot = findViewById(R.id.btn_dot);
        btn_ce = findViewById(R.id.btn_ce);
        btn_bs = findViewById(R.id.btn_bs);
        txt_from = findViewById(R.id.txt_from);
        txt_to = findViewById(R.id.txt_to);
        spinnerFrom = findViewById(R.id.spin_currency_from);
        spinnerTo = findViewById(R.id.spin_currency_to);
        ArrayAdapter<String> adapterFrom = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, currencies);
        adapterFrom.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<String> adapterTo = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, currencies);
        adapterFrom.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapterFrom);
        spinnerTo.setAdapter(adapterTo);
        spinnerFrom.setSelection(1);
        txt_from.setOnClickListener(this);
        txt_to.setOnClickListener(this);
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
        btn_dot.setOnClickListener(this);
        btn_ce.setOnClickListener(this);
        btn_bs.setOnClickListener(this);
        spinnerFrom.setOnItemSelectedListener(this);
        spinnerTo.setOnItemSelectedListener(this);
    }

    void setValue(String value) {
        if (statusChosen == 0) valueFrom += value;
        else valueTo += value;
        changeCurrency();
    }

    void changeCurrency() {
        String _valueFrom = valueFrom.equals("") ? "0" : valueFrom;
        String _valueTo = valueTo.equals("") ? "0" : valueTo;
        if (statusChosen == 0) {
            float value = Float.parseFloat(_valueFrom) * rateTo / rateFrom;
            valueTo = String.format("%.1f", value);
        } else {
            float value = Float.parseFloat(_valueTo) * rateFrom / rateTo;
            valueFrom = String.format("%.1f", value);
        }
        txt_from.setText(valueFrom);
        txt_to.setText(valueTo);
    }

    void changeStatusChosen(int status) {
        statusChosen = status;
        valueFrom = "";
        valueTo = "";
        txt_from.setText(valueFrom);
        txt_to.setText(valueTo);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == txt_from.getId()) {
            System.out.println("1111111111111111111111");
            changeStatusChosen(0);
        }
        if (v.getId() == txt_to.getId()) {
            System.out.println("2222222222222222222222");
            changeStatusChosen(1);
        }
        if (v.getId() == btn_0.getId()) {
            setValue("0");
        }
        if (v.getId() == btn_1.getId()) {
            setValue("1");
        }
        if (v.getId() == btn_2.getId()) {
            setValue("2");
        }
        if (v.getId() == btn_3.getId()) {
            setValue("3");
        }
        if (v.getId() == btn_4.getId()) {
            setValue("4");
        }
        if (v.getId() == btn_5.getId()) {
            setValue("5");
        }
        if (v.getId() == btn_6.getId()) {
            setValue("6");
        }
        if (v.getId() == btn_7.getId()) {
            setValue("7");
        }
        if (v.getId() == btn_8.getId()) {
            setValue("8");
        }
        if (v.getId() == btn_9.getId()) {
            setValue("9");
        }
        if (v.getId() == btn_dot.getId()) {
            setValue(".");
        }
        if (v.getId() == btn_ce.getId()) {
            //Xoa so dang nhap
            if (statusChosen == 0) valueFrom = "";
            else valueTo = "";
            changeCurrency();
        }
        if (v.getId() == btn_bs.getId()) {
            //Xoa 1 ki tu phia truoc
            if (statusChosen == 0) valueFrom = valueFrom.substring(0, valueFrom.length() - 1);
            else valueTo = valueTo.substring(0, valueTo.length() - 1);
            changeCurrency();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == spinnerFrom.getId()) {
            rateFrom = currencies.get(i).getRate();
        }
        if (adapterView.getId() == spinnerTo.getId()) {
            rateTo = currencies.get(i).getRate();
        }
        valueFrom = "";
        valueTo = "";
        txt_from.setText(valueFrom);
        txt_to.setText(valueTo);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
