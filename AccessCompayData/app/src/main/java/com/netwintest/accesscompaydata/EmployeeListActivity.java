package com.netwintest.accesscompaydata;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.netwintest.accesscompaydata.adapter.EmployeeAdapter;
import com.netwintest.accesscompaydata.data.EmployeeData;
import com.netwintest.accesscompaydata.data.Table;

import org.chalup.microorm.MicroOrm;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeListActivity extends AppCompatActivity {
    @BindView(R.id.rvEmployees)
    RecyclerView rvEmployees;

    @BindView(R.id.overlay)
    View overlay;

    EmployeeAdapter adapter;
    ArrayList<Object> list;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        context = this;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        rvEmployees.setLayoutManager(new LinearLayoutManager(context));
        loadEmployees();
    }

    public void loadEmployees() {
        ContentResolver resolver = getContentResolver();
        overlay.setVisibility(View.VISIBLE);
        try {
            Cursor cursor = resolver.query(Table.Employee.uri,
                    new String[]{Table.Employee.Column.EMP_ID,
                            Table.Employee.Column.EMP_NAME,
                            Table.Employee.Column.EMP_DESIGNATION,
                            Table.Employee.Column.EMP_AGE,
                            Table.Employee.Column.EMP_DOJ

                    },
                    null, null, null);
            list = new ArrayList<>();
            MicroOrm orm = new MicroOrm();
            while(cursor.moveToNext()) {
                EmployeeData data = orm.fromCursor(cursor, EmployeeData.class);
                list.add(data);
            }
            cursor.close();
            adapter = new EmployeeAdapter(context, list);
            rvEmployees.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to load data. Please retry", Toast.LENGTH_LONG).show();
        }

        overlay.setVisibility(View.GONE);
        /*list = new ArrayList<>();

        list.addAll(model.getEmployees());
        adapter = new EmployeeAdapter(context, list);
        rvEmployees.setAdapter(adapter);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
