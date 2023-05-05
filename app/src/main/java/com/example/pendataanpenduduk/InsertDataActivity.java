package com.example.pendataanpenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertDataActivity extends AppCompatActivity {
  private EditText name_txt, address_txt, city_txt, age_txt, job_txt, salary_txt, status_txt;
  private Button btn_clear, btn_submit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_insert_data);

    name_txt = (EditText) findViewById(R.id.name);
    address_txt = (EditText) findViewById(R.id.address);
    city_txt = (EditText) findViewById(R.id.city );
    age_txt = (EditText) findViewById(R.id.age);
    job_txt = (EditText) findViewById(R.id.job);
    salary_txt = (EditText) findViewById(R.id.salary);
    status_txt = (EditText) findViewById(R.id.status);
    btn_clear = (Button) findViewById(R.id.btn_clear);
    btn_submit = (Button) findViewById(R.id.btn_submit);

    btn_clear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        clearPrompt();
      }
    });

    btn_submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (inputIsEmpty()) {
          return;
        }
        String name = name_txt.getText().toString();
        String address = address_txt.getText().toString();
        String city = city_txt.getText().toString();
        Integer age = Integer.parseInt(age_txt.getText().toString());
        String job = job_txt.getText().toString();
        Double salary = Double.parseDouble(salary_txt.getText().toString());
        String status = status_txt.getText().toString();
        DataModel data = new DataModel(name, address, city, age, job, salary, status);

        DataModel.setData(data);

        finish();
        startActivity(new Intent(InsertDataActivity.this, ViewListDataActivity.class));
        Toast.makeText(InsertDataActivity.this, "Data added successful!", Toast.LENGTH_SHORT).show();
      }
    });
  }

  public void clearPrompt() {
    name_txt.setText("");
    address_txt.setText("");
    city_txt.setText("");
    age_txt.setText("");
    job_txt.setText("");
    salary_txt.setText("");
    status_txt.setText("");
  }

  public boolean inputIsEmpty() {
    if (
      name_txt.getText().toString().isEmpty() ||
      address_txt.getText().toString().isEmpty() ||
      city_txt.getText().toString().isEmpty() ||
      age_txt.getText().toString().isEmpty() ||
      job_txt.getText().toString().isEmpty() ||
      status_txt.getText().toString().isEmpty()
    ) {
      Toast.makeText(InsertDataActivity.this, "All field should be filled!", Toast.LENGTH_SHORT).show();
      return true;
    }
    else return false;
  }
}