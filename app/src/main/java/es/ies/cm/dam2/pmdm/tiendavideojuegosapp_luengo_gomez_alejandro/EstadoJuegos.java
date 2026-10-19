package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Clase de la práctica 3
public class EstadoJuegos extends AppCompatActivity {
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
    private RadioButton rbNuevo = findViewById(R.id.rbNuevo);
    private RadioButton rbSegundaMano = findViewById(R.id.rbSegundaMano);
    private RadioButton rbAlquilado = findViewById(R.id.rbAlquilado);
    private String seHaPulsado = getString(R.string.seHaPulsado);
    private String dificultadIncorrecta = getString(R.string.tvDificultadIncorrecta);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estado_juegos);

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
        btnLimpiar.setOnClickListener(v-> {

        });
    }

    private void configurarButton(Button button, String numero){
        button.setOnClickListener(v-> tvBotonPulsado.setText(seHaPulsado + numero));
    }
}
