package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {
    private final Button btnIrMainActivity = findViewById(R.id.btnIrMainActivity);
    private final Button btnIrFichaJuego = findViewById(R.id.btnIrFichaJuego);
    private final Button btnIrAltaJuego = findViewById(R.id.btnIrAltaJuegos);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        // Al pulsar el botón inicio esa actividad, por el momento no se pasa ninguna información
        btnIrMainActivity.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        });

        btnIrFichaJuego.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, FichaJuego.class);
            startActivity(intent2);
        });

        btnIrAltaJuego.setOnClickListener(v -> {
            Intent intent3 = new Intent(this, AltaJuegoActivity.class);
            startActivity(intent3);
        });
    }
}
