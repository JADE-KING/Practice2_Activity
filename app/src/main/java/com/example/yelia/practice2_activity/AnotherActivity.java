package com.example.yelia.practice2_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent = getIntent();
        String fromMain = intent.getStringExtra("editToAnother");
        TextView textFromMain = (TextView)findViewById(R.id.textFromMain);
        textFromMain.setText("Text from the main activity:\n    " + fromMain);

        Button buttonToMain = (Button)findViewById(R.id.buttonToMain);
        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editToMain = (EditText)findViewById(R.id.editToMain);
                Intent intent = getIntent();
                intent.putExtra("editToMain", editToMain.getText().toString());
                setResult(0, intent);
                finish();
            }
        });

    }
}
