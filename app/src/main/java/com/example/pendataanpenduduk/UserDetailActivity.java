package com.example.pendataanpenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {

  private TextView name, address, city, age, job, salary, status;
  private Button btn_back;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_detail);

    name = (TextView) findViewById(R.id.tvFullname);
    address = (TextView) findViewById(R.id.tvAddress);
    city = (TextView) findViewById(R.id.tvCity);
    age = (TextView) findViewById(R.id.tvAge);
    job = (TextView) findViewById(R.id.tvJob);
    salary = (TextView) findViewById(R.id.tvSalary);
    status = (TextView) findViewById(R.id.tvStatus);

    btn_back = (Button) findViewById(R.id.btn_back);

    Intent intent = getIntent();
    DataModel data = (DataModel) intent.getSerializableExtra("user_data");

    name.setText(data.getName());
    address.setText(data.getAddress());
    city.setText(data.getCity());
    age.setText(String.valueOf(data.getAge()));
    job.setText(data.getJob());
    salary.setText("Rp" + String.valueOf(data.getSalary()));
    status.setText(data.getStatus());

    btn_back.setOnClickListener(v -> {
      finish();
      startActivity(new Intent(UserDetailActivity.this, ViewListDataActivity.class));
    });
  }
}