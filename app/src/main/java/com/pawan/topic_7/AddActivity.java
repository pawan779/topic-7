package com.pawan.topic_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity {

    EditText etWord, etDefinition;
    Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etWord=findViewById(R.id.etWord);
        etDefinition=findViewById(R.id.etMeaning);
        btnAddWord=findViewById(R.id.btnAddWord);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();

                Intent intent=new Intent(AddActivity.this,MeaningActivity.class);
                startActivity(intent);
            }
        });

    }
    private void Save()
    {
        try {
            PrintStream printStream=new PrintStream(openFileOutput("words.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etWord.getText().toString()+ "->"+etDefinition.getText().toString());
            Toast.makeText(this,"Save to"+ getFilesDir(), Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            Log.d("Dictionary app","Error: "+e.toString());
            e.printStackTrace();
        }
    }

}
