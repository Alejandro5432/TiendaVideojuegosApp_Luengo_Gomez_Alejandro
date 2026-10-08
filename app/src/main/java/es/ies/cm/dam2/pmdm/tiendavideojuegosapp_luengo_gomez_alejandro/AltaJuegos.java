package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AltaJuegos extends AppCompatActivity {

    private TextView tvNumJugadores = findViewById(R.id.tvNumJugadores);
    private TextView tvMostrarNombreJuego = findViewById(R.id.tvMostrarNombreJuego);
    private TextView tvPulsaBoton = findViewById(R.id.tvPulsaBoton);
    private Button btnMasJugadores = findViewById(R.id.btnMasJugadores);
    private Button btnMenosJugadores = findViewById(R.id.btnMenosJugadores);
    private Button btnCopiarNombreJuego = findViewById(R.id.btnCopiarNombreJuego);
    private Button btnPulsame = findViewById(R.id.btnPulsame);
    private EditText etEscribeNombreJuego = findViewById(R.id.etEscribeNombreJuego);
    private CheckBox cbEnLaColeccion = findViewById(R.id.cbEnLaColeccion);
    private int contadorNumJugadores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_juegos);

        btnMasJugadores.setOnClickListener(v-> {
            contadorNumJugadores++;
            tvNumJugadores.setText(String.valueOf(contadorNumJugadores));
            Toast.makeText(getApplicationContext(), "Se ha pulsado el botón de incrementar el número de jugadores", Toast.LENGTH_LONG).show();
        });
        btnMenosJugadores.setOnClickListener(v-> {
            contadorNumJugadores--;
            tvNumJugadores.setText(String.valueOf(contadorNumJugadores));
            Toast.makeText(getApplicationContext(), "Se ha pulsado el botón de reducir el número de jugadores", Toast.LENGTH_LONG).show();
        });

    }
}
