package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AltaJuegoActivity extends AppCompatActivity {
    // Clase de la práctica 4, introducir lo de la práctica 2 y 3 aquí más lo anotado en el txt
    // Práctica 2
    private final TextView tvMinJugadores = findViewById(R.id.tvMinJugadores);
    private final TextView tvMaxJugadores = findViewById(R.id.tvMaxJugadores);
    private final TextView tvMostrarNombreJuego = findViewById(R.id.tvMostrarNombreJuego);
    private final Button btnMasJugadoresMin = findViewById(R.id.btnMasJugadoresMin);
    private final Button btnMenosJugadoresMin = findViewById(R.id.btnMenosJugadoresMin);
    private final Button btnMasJugadoresMax = findViewById(R.id.btnMasJugadoresMax);
    private final Button btnMenosJugadoresMax = findViewById(R.id.btnMenosJugadoresMax);
    private final Button btnCopiarNombreJuego = findViewById(R.id.btnCopiarNombreJuego);
    private final EditText etEscribeNombreJuego = findViewById(R.id.etEscribeNombreJuego);
    private final CheckBox cbEnLaColeccion = findViewById(R.id.cbEnLaColeccion);
    private int contadorNumJugadores = 0;

    // Práctica 3
    private final TextView tvDificultadIncorrecta = findViewById(R.id.tvDificultadIncorrecta);
    private final Button btnLimpiar = findViewById(R.id.btnLimpiar);
    private final EditText etDificultadJuego = findViewById(R.id.etDificultadJuego);
    private final RadioGroup radioGroup = findViewById(R.id.RadioGroup);
    private final RadioButton rbNuevo = findViewById(R.id.rbNuevo);
    private final RadioButton rbSegundaMano = findViewById(R.id.rbSegundaMano);
    private final RadioButton rbAlquilado = findViewById(R.id.rbAlquilado);
    private final String dificultadIncorrecta = getString(R.string.tvDificultadIncorrecta);
    private final View mainLayoutAltaJuego = findViewById(R.id.mainLayoutAltaJuego);
    private final Button btnVolverAlMenuAJ = findViewById(R.id.btnVolverAlMenuAJ);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_juego);

        // Práctica 2
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

        btnCopiarNombreJuego.setOnClickListener(v -> {
            tvMostrarNombreJuego.setText((CharSequence) etEscribeNombreJuego);
            etEscribeNombreJuego.setText("");
        });
        // Práctica 2


        // Práctica 3
        // Primer ejercicio (borrado ya que no me sirve para nada de las prácticas posteriores)

        // Segundo ejercicio
        etDificultadJuego.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String texto = s.toString().trim();

                try{
                    int dificultad = Integer.parseInt(texto);

                    if(dificultad >= 1 && dificultad <= 10){
                        // Si es correcto no dice nada
                        tvDificultadIncorrecta.setText("");
                    } else {
                        tvDificultadIncorrecta.setText(dificultadIncorrecta);
                        tvDificultadIncorrecta.setTextColor(Color.RED);
                    }
                    // Si salta un error porque no es un número se muestra el mismo mensaje
                } catch(NumberFormatException e){
                    tvDificultadIncorrecta.setText(dificultadIncorrecta);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No lo necesito
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Tampoco lo necesito
            }
        });

        // Tercer ejercicio
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbNuevo){
                    mainLayoutAltaJuego.setBackgroundColor(Color.GREEN);
                } else if (checkedId == R.id.rbSegundaMano) {
                    mainLayoutAltaJuego.setBackgroundColor(Color.YELLOW);
                } else if (checkedId == R.id.rbAlquilado) {
                    mainLayoutAltaJuego.setBackgroundColor(Color.RED);
                }
            }
        });
        // Limpio selección y pongo el color del fondo a blanco
        btnLimpiar.setOnClickListener(v-> {
            radioGroup.clearCheck();
            mainLayoutAltaJuego.setBackgroundColor(Color.WHITE);
        });
        btnVolverAlMenuAJ.setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        });
    }
        // Práctica 3
}
