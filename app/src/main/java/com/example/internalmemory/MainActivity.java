package com.example.internalmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etUserName,etpassword,etEmail,etfirstName,etlastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.et_userName);
        etpassword=findViewById(R.id.et_Password);
        etEmail=findViewById(R.id.et_email);
        etfirstName=findViewById(R.id.et_firstName);
        etlastName=findViewById(R.id.et_lastName);

    }

    public void save(View view) {

        String UserName= etUserName.getText().toString()+" ";
        String password=etpassword.getText().toString()+" ";
        String Email=etEmail.getText().toString()+" ";
        String firstName=etfirstName.getText().toString()+" ";
        String lastName=etlastName.getText().toString();

        File file=null;
        FileOutputStream fileOutputStream=null;

      try{
          file=getFilesDir();

          fileOutputStream=openFileOutput("ahmed.txt", Context.MODE_PRIVATE);
          fileOutputStream.write(UserName.getBytes());
          fileOutputStream.write(password.getBytes());
          fileOutputStream.write(Email.getBytes());
          fileOutputStream.write(firstName.getBytes());
          fileOutputStream.write(lastName.getBytes());
      }
      catch (IOException e){
          Log.d("ahmed",e.toString());
      }



        finally {
          try {
              fileOutputStream.close();
          }
          catch (IOException e){
              e.printStackTrace();
          }
      }

        Toast.makeText(this,"saved Successfully "+file+"/ahmed.txt",Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {

        Toast.makeText(this,"Database page",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,DBActivity.class);
        startActivity(intent);
    }
}
