package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FichaJuego extends AppCompatActivity {

    // Segunda clase de la práctica 4
    private final Button btnVolverAlMenuFJ = findViewById(R.id.btnVolverAlMenuFJ);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_juego);



        btnVolverAlMenuFJ.setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        });
    }
}
