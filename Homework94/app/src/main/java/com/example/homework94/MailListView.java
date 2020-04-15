package com.example.homework94;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MailListView extends AppCompatActivity {
    List<MailModel> mails = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_listview);

        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));
        mails.add(new MailModel("Thang Dong Viet", "This is a description"));

        MailListAdapter adapter = new MailListAdapter(mails);
        ListView listView = findViewById(R.id.mail_list);
        listView.setAdapter(adapter);
    }
}
