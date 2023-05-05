package com.example.pendataanpenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

  private EditText username, password;
  private Button btn_sign_in;
  private Authentication auth;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    username = (EditText) findViewById(R.id.username_field);
    password = (EditText) findViewById(R.id.password_field);
    btn_sign_in = (Button) findViewById(R.id.btn_signIn);

    btn_sign_in.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String username_text = username.getText().toString();
        String password_text = password.getText().toString();
        auth = new Authentication(username_text, password_text);

        if(!auth.validateLength()) {
          Toast.makeText(LoginActivity.this, "Invalid input length!", Toast.LENGTH_SHORT).show();
        }
        else {
          if (auth.isMatched()) {
            Toast.makeText(LoginActivity.this, "Login successed!", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(LoginActivity.this, InsertDataActivity.class));
          }
          else {
            Toast.makeText(LoginActivity.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
          }
        }
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    if (Authentication.isNotLogin()) {
      finish();
      startActivity(new Intent(LoginActivity.this, InsertDataActivity.class));
    }
    else {
      username = (EditText) findViewById(R.id.username_field);
      password = (EditText) findViewById(R.id.password_field);
      username.setText("");
      password.setText("");
    }
  }
}