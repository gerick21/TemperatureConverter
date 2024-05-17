package com.example.convertidortemperatura;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.textViewResult);
        Button buttonBack = findViewById(R.id.buttonBack);

        // Obtener el resultado del Intent
        String result = getIntent().getStringExtra("conversionResult");
        resultTextView.setText(result);

        // Configurar el botón de regreso
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
