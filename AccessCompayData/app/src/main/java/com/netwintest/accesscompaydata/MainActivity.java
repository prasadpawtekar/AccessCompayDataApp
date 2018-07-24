package com.netwintest.accesscompaydata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAllEmps) public void showEmployees() {
        Intent intent = new Intent(this, EmployeeListActivity.class);
        startActivity(intent);
    }
}
