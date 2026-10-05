package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaro las variables
    private EditText etContadorJuegosComprados;
    private Button btnCheck;
    private Button btnReset;
    private int contadorClicks = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializo las variables en onCreate
        etContadorJuegosComprados = findViewById(R.id.etContadorJuegosComprados);
        btnCheck = findViewById(R.id.btnCheck);
        btnReset = findViewById(R.id.btnReset);

        // Incremento el contador al hacer click
        btnCheck.setOnClickListener(v-> {
            contadorClicks++;
            // Convierto el int a String y lo asigno al EditText
            etContadorJuegosComprados.setText(String.valueOf(contadorClicks));
        });
        // Reseteo el contador al hacer click
        btnReset.setOnClickListener(v-> {
            contadorClicks = 0;
            etContadorJuegosComprados.setText(String.valueOf(contadorClicks));
        });
    }
}