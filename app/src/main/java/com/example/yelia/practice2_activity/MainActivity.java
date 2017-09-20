package com.example.yelia.practice2_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textFromAnother = (TextView)findViewById(R.id.textFromAnother);
        textFromAnother.setText("Text from another activity:\n");

        Button buttonToAnother = (Button)findViewById(R.id.buttonToAnother);
        buttonToAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editToAnother = (EditText)findViewById(R.id.editToAnother);
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("editToAnother", editToAnother.getText().toString());
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == 0) {
            String str = data.getStringExtra("editToMain");
            TextView textFromAnother = (TextView)findViewById(R.id.textFromAnother);
            textFromAnother.setText("Text from another activity:\n" + str);
            EditText editToAnother = (EditText)findViewById(R.id.editToAnother);
            editToAnother.setText("");
        }
    }

}
