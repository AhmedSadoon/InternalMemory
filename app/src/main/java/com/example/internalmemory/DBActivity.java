package com.example.internalmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DBActivity extends AppCompatActivity {

    TextView tvUserNameDB,tvpasswordDB,tvEmailDB,tvfirstNameDB,tvlastNameDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        tvUserNameDB=findViewById(R.id.tv_userNameDB);
        tvpasswordDB=findViewById(R.id.tv_PasswordDB);
        tvEmailDB=findViewById(R.id.tv_emailDB);
        tvfirstNameDB=findViewById(R.id.tv_firstNameDB);
        tvlastNameDB=findViewById(R.id.tv_lastNameDB);
    }

    public void show(View view) {

        FileInputStream fileInputStream=null;
        try {

            fileInputStream=openFileInput("ahmed.txt");

            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1)
            {
                buffer.append((char) read);
            }
            Log.d(buffer.toString(),"ahmed");


            /*الطريقة الاولى
            String UserName= buffer.substring(0,buffer.indexOf(" "));
            String password=buffer.substring(buffer.indexOf(" ")+1,buffer.indexOf(" "));
            String Email=buffer.substring(buffer.indexOf(" ")+1,buffer.indexOf(" "));
            String firstName=buffer.substring(buffer.indexOf(" ")+1,buffer.indexOf(" "));
            String lastName=buffer.substring(buffer.indexOf(" ")+1,buffer.indexOf(" "));*/

            //الطريقة الثانية

            String m=buffer.toString();

            String[] data=m.split(" ");
            String UserName=data[0];
            String password=data[1];
            String Email=data[2];
            String firstName=data[3];
            String lastName=data[4];


            tvUserNameDB.setText(UserName);
            tvpasswordDB.setText(password);
            tvEmailDB.setText(Email);
            tvfirstNameDB.setText(firstName);
            tvlastNameDB.setText(lastName);

        } catch (java.io.IOException e) {

            Toast.makeText(this,"file not found",Toast.LENGTH_SHORT).show();
        }


        Toast.makeText(this,"Data found",Toast.LENGTH_SHORT).show();

    }

    public void back(View view) {

        Toast.makeText(this,"Main page",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
