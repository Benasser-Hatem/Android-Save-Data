package com.horizon.planetes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
    private EditText input;
    private Button save;
    public  String SHARED_PREFS = "sharedprefs";
    public String TEXT = "text";
    //public String textName;
    public String text;
    public String name;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        input =  findViewById(R.id.input);
        save = findViewById(R.id.save);
        //name = findViewById(R.id.planet_name);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView textName = findViewById(R.id.planet_name);
        textName.setText(name);

        String distance = intent.getStringExtra("distance");
        TextView textDistance = findViewById(R.id.textView2);
        textDistance.setText(distance);
        loadData();
        showData();
        Integer idImage = intent.getIntExtra("idImage", 0);
        ImageView imageView = findViewById(R.id.imageView);
        Picasso.get().load(idImage).fit().placeholder(R.mipmap.ic_launcher).into(imageView);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             saveData();
            }
        });

    }
    public void saveData(){
        SharedPreferences sharedPreferences =  getSharedPreferences(SHARED_PREFS,MainActivity2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name,input.getText().toString());
        editor.commit();
        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MainActivity2.MODE_PRIVATE);
        text = sharedPreferences.getString(name,"");
    }
    public void showData(){
        input.setText(text);
    }
}
