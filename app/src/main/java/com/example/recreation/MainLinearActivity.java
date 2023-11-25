package com.example.recreation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainLinearActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        checkBox = findViewById(R.id.checkBox);

        Button pressMeButton = findViewById(R.id.pressMeButton);
        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextValue = editText.getText().toString();

                textView.setText(editTextValue);

                showToast();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                showSnackbar(isChecked);
            }
        });
    }

    private void showToast() {
        String toastMessage = getResources().getString(R.string.toast_message);

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private void showSnackbar(boolean isChecked) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                "The checkbox is now " + (isChecked ? "on" : "off"), Snackbar.LENGTH_LONG);

        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setChecked(!isChecked);
            }
        });

        snackbar.show();
    }
}