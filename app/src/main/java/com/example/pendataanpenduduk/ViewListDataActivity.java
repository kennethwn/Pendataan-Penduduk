package com.example.pendataanpenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewListDataActivity extends AppCompatActivity {
  private ListView listView;
  private ListAdapter adapter;
  private Button btn_back;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_list_data);

    btn_back = (Button) findViewById(R.id.btn_back);
    listView = findViewById(R.id.listView);

    adapter = new ListAdapter(this, DataModel.data);
    listView.setAdapter(adapter);

    btn_back.setOnClickListener(v -> {
      finish();
      startActivity(new Intent(this, InsertDataActivity.class));
    });
  }
}