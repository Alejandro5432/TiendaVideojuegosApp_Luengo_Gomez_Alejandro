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
    private final String alPulsarElButton = getString(R.string.alPulsarElButton);
    // Práctica 3
    private TextView tvBotonPulsado = findViewById(R.id.tvBotonPulsado);
    private TextView tvDificultadIncorrecta = findViewById(R.id.tvDificultadIncorrecta);
    private Button btnPrimero = findViewById(R.id.btnPrimero);
    private Button btnSegundo = findViewById(R.id.btnSegundo);
    private Button btnTercero = findViewById(R.id.btnTercero);
    private Button btnCuarto = findViewById(R.id.btnCuarto);
    private Button btnQuinto = findViewById(R.id.btnQuinto);
    private Button btnSexto = findViewById(R.id.btnSexto);
    private Button btnSeptimo = findViewById(R.id.btnSeptimo);
    private Button btnOctavo = findViewById(R.id.btnOctavo);
    private Button btnNoveno = findViewById(R.id.btnNoveno);
    private Button btnLimpiar = findViewById(R.id.btnLimpiar);
    private EditText etDificultadJuego = findViewById(R.id.etDificultadJuego);
    private RadioGroup radioGroup = findViewById(R.id.RadioGroup);
    private RadioButton rbNuevo = findViewById(R.id.rbNuevo);
    private RadioButton rbSegundaMano = findViewById(R.id.rbSegundaMano);
    private RadioButton rbAlquilado = findViewById(R.id.rbAlquilado);
    private String seHaPulsado = getString(R.string.seHaPulsado);
    private String dificultadIncorrecta = getString(R.string.tvDificultadIncorrecta);
    private final View mainLayoutAltaJuego = findViewById(R.id.mainLayoutAltaJuego);
    // IMPORTANTE poner lo de MAIN LAYOUT para altaJuego que permite cambiar los colores
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

        cbEnLaColeccion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                btnPulsame.setEnabled(false);
            } else{
                btnPulsame.setEnabled(true);
            }
        });

        btnPulsame.setOnClickListener(v -> tvPulsaBoton.setText(alPulsarElButton));
        // Práctica 2


        // Práctica 3
        // Primer ejercicio
        // Creo una función para dejar el código más limpio y menos repetitivo
        configurarButton(btnPrimero, "1");
        configurarButton(btnSegundo, "2");
        configurarButton(btnTercero, "3");
        configurarButton(btnCuarto, "4");
        configurarButton(btnQuinto, "5");
        configurarButton(btnSexto, "6");
        configurarButton(btnSeptimo, "7");
        configurarButton(btnOctavo, "8");
        configurarButton(btnNoveno, "9");

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
    private void configurarButton(Button button, String numero){
        button.setOnClickListener(v-> tvBotonPulsado.setText(seHaPulsado + numero));
    }
        // Práctica 3
}
