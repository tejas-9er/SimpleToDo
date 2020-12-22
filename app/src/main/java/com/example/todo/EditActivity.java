package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etitem;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etitem = findViewById(R.id.etitem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        etitem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create an intent that contains result of the modification
                Intent intent = new Intent();

                //pass the edited data
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etitem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set the result of the intent
                setResult(RESULT_OK, intent);

                //finish the activity or close the screen and back to main screen
                finish();
            }
        });
    }
}