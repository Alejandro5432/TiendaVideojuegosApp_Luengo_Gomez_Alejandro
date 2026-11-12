package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

public class AltaJuegoActivity extends AppCompatActivity {
    // Clase de la práctica 4, introducir lo de la práctica 2 y 3 aquí más lo anotado en el txt
    private final TextView tvMinJugadores = findViewById(R.id.tvMinJugadores);
    private final TextView tvMaxJugadores = findViewById(R.id.tvMaxJugadores);
    private final TextView tvMostrarNombreJuego = findViewById(R.id.tvMostrarNombreJuego);
    private final Button btnMasJugadoresMin = findViewById(R.id.btnMasJugadoresMin);
    private final Button btnMenosJugadoresMin = findViewById(R.id.btnMenosJugadoresMin);
    private final Button btnMasJugadoresMax = findViewById(R.id.btnMasJugadoresMax);
    private final Button btnMenosJugadoresMax = findViewById(R.id.btnMenosJugadoresMax);
    private final Button btnCopiarNombreJuego = findViewById(R.id.btnCopiarNombreJuego);
    private final Button btnFechaLanzamiento = findViewById(R.id.btnFechaLanzamiento);
    private final Button btnVolverAlMenuAJ = findViewById(R.id.btnVolverAlMenuAJ);
    private final Button btnEnviar = findViewById(R.id.btnEnviar);
    private final Button btnResetearCampos = findViewById(R.id.btnResetearCampos);
    private final EditText etEscribeNombreJuego = findViewById(R.id.etEscribeNombreJuego);
    private final EditText etPrecio = findViewById(R.id.etPrecio);
    private final EditText etPlataformas = findViewById(R.id.etPlataformas);
    private int contadorMinJugadores = 1;
    private int contadorMaxJugadores = 1;
    private final TextView tvDificultadIncorrecta = findViewById(R.id.tvDificultadIncorrecta);
    private final EditText etDificultadJuego = findViewById(R.id.etDificultadJuego);
    private final RadioGroup radioGroup = findViewById(R.id.RadioGroup);
    private final RadioButton rbNuevo = findViewById(R.id.rbNuevo);
    private final RadioButton rbSegundaMano = findViewById(R.id.rbSegundaMano);
    private final RadioButton rbAlquilado = findViewById(R.id.rbAlquilado);

    private final Spinner spGenero = findViewById(R.id.spGenero);
    private final Spinner spEdadRecomendada = findViewById(R.id.spEdadRecomendada);
    private String fechaLanzamiento = "";
    private final String dificultadIncorrecta = getString(R.string.tvDificultadIncorrecta);
    private final View mainLayoutAltaJuego = findViewById(R.id.mainLayoutAltaJuego);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_juego);

        btnCopiarNombreJuego.setOnClickListener(v -> {
            tvMostrarNombreJuego.setText((CharSequence) etEscribeNombreJuego);
            etEscribeNombreJuego.setText("");
        });

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

        btnVolverAlMenuAJ.setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        });

        btnResetearCampos.setOnClickListener(v-> {
            etEscribeNombreJuego.setText("");
            tvMinJugadores.setText("");
            tvMaxJugadores.setText("");
            etPrecio.setText("");
            etPlataformas.setText("");
            etDificultadJuego.setText("");
            //spGenero
            //spEdadRecomendada

            // Elimino la fecha seleccionada
            // fecha de lanzamiento

            // Limpio selección y pongo el color del fondo a blanco
            radioGroup.clearCheck();
            mainLayoutAltaJuego.setBackgroundColor(Color.WHITE);
        });

        btnEnviar.setOnClickListener(v-> {

        });
    }

    private void seleccionarNumJugadores(){
        btnMasJugadoresMin.setOnClickListener(v-> {
            contadorMinJugadores++;
            tvMinJugadores.setText(String.valueOf(contadorMinJugadores));
            Toast.makeText(getApplicationContext(), "Se ha pulsado el botón de incrementar el número de jugadores", Toast.LENGTH_LONG).show();
        });

        btnMenosJugadoresMin.setOnClickListener(v-> {
            if(contadorMinJugadores > 1) {
                contadorMinJugadores--;
                tvMinJugadores.setText(String.valueOf(contadorMinJugadores));
                Toast.makeText(getApplicationContext(), "Se ha pulsado el botón de reducir el número de jugadores", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Valor mínimo alcanzado. No se puede reducir más", Toast.LENGTH_LONG).show();
            }
        });

        btnMasJugadoresMax.setOnClickListener(v-> {
            contadorMaxJugadores++;
            tvMaxJugadores.setText(String.valueOf(contadorMaxJugadores));
            Toast.makeText(getApplicationContext(), "Se ha pulsado el botón de incrementar el número de jugadores", Toast.LENGTH_LONG).show();
        });

        btnMenosJugadoresMax.setOnClickListener(v-> {
            if (contadorMaxJugadores > 1) {
                contadorMaxJugadores--;
                tvMaxJugadores.setText(String.valueOf(contadorMaxJugadores));
                Toast.makeText(getApplicationContext(), "Se ha pulsado el botón de reducir el número de jugadores", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Valor mínimo alcanzado. No se puede reducir más", Toast.LENGTH_LONG).show();
            }
        });
    }

    // Configuro los adaptadores de los spinners con una función, la información está en el archivo de strings.xml
        private void configurarSpinners(){
            ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(
                    this, R.array.spGenero, android.R.layout.simple_spinner_item);
            adapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spGenero.setAdapter(adapterGenero);

            ArrayAdapter<CharSequence> adapterEdadRecomendada = ArrayAdapter.createFromResource(
                    this, R.array.spEdadRecomendada, android.R.layout.simple_spinner_item);
            adapterEdadRecomendada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spEdadRecomendada.setAdapter(adapterEdadRecomendada);
        }

        // Configuro el selector de la fecha de lanzamiento al pulsar el botón correspondiente
        private void configurarFecha() {
            btnFechaLanzamiento.setOnClickListener(v-> {
                Calendar calendario = Calendar.getInstance();
                int anio = calendario.get(Calendar.YEAR);
                int mes = calendario.get(Calendar.MONTH);
                int dia = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog selectorFecha = new DatePickerDialog(
                        AltaJuegoActivity.this,
                        (view, year, month, dayOfMonth) -> {
                            fechaLanzamiento = String.format(Locale.ROOT,
                                    "%04d-%02d-%02d", year, month + 1, dayOfMonth);
                            // Pongo la fecha en el botón para que el usuario sepa que se ha seleccionado la fecha que quería
                            btnFechaLanzamiento.setText(String.format(
                                    Locale.getDefault(),
                                    "%02d/%02d/%04d",
                                    dayOfMonth,
                                    month + 1,
                                    year
                            ));
                        },
                        anio,
                        mes,
                        dia);
                selectorFecha.show();
            });
        }
    private void validarCamposYEnviar(){
        // 1. Compruebo que tenga nombre
        String nombre = etEscribeNombreJuego.getText().toString().trim();

        if(nombre.isEmpty()){
            etEscribeNombreJuego.setError("Introduzca el nombre del juego");
            etEscribeNombreJuego.requestFocus(); // Establezco el foco en el EditText
            return;
        }

        // 2. Obtengo el número de jugadores mínimo y máximo y compruebo
        int minimo = contadorMinJugadores;
        int maximo = contadorMaxJugadores;

        if(minimo <=0 || maximo <= 0){
            Toast.makeText(this, "El número de jugadores debe ser positivo", Toast.LENGTH_LONG).show();
            return; // Le digo que pare de ejecutar código, así no se envía nada hasta que el formulario sea correcto en su totalidad.
        }

        if(minimo > maximo){
            Toast.makeText(this, "El número de jugadores debe ser positivo", Toast.LENGTH_LONG).show();
            return;
        }

        // 3. Comprobar que se ha introducido un precio
        String precioTexto = etPrecio.getText().toString().trim().replace(',','.'); // Cortesía del español intercambiando decimales por la agrupación por millares
        if(precioTexto.isEmpty()){
            etPrecio.setError("Introduzca el precio del juego");
            etPrecio.requestFocus();
            return;
        }
        BigDecimal precio;
        // Una vez comprueba que se ha introducido un precio se comprueba si es positivo
        try {
            precio = new BigDecimal(precioTexto);

            if(precio.signum() < 0){
                etPrecio.setError("El precio no puede ser negativo");
                etPrecio.requestFocus();
                return;
            }
        } catch(NumberFormatException e){
            etPrecio.setError("Introduce un precio positivo");
            etPrecio.requestFocus();
            return;
        }

        // 4. Compruebo que se ha seleccionado un valor distinto del primero
        if(spGenero.getSelectedItemPosition() <= 0){
            Toast.makeText(this, "Seleccione un género de entre los disponibles", Toast.LENGTH_LONG).show();
            spGenero.requestFocus();
            return;
        }
        String genero = spGenero.getSelectedItem().toString();

        // 5. Compruebo el spinner de edadRecomendada de igual forma que el anterior
        if(spEdadRecomendada.getSelectedItemPosition() <= 0){
            Toast.makeText(this, "Seleccione una edad recomendada de entre las disponibles", Toast.LENGTH_LONG).show();
            return;
        }
        String edadRecomendada = spEdadRecomendada.getSelectedItem().toString();

        // 6. Compruebo que se ha seleccionado una fecha
        if (fechaLanzamiento.isEmpty()){
            Toast.makeText(this, "Seleccione la fecha de lanzamiento del juego", Toast.LENGTH_LONG).show();
            return;
        }

        // 7. Compruebo que se haya escrito algo en plataformas
        String plataformas = etPlataformas.getText().toString().trim();

        if(plataformas.isEmpty()){
            etPlataformas.setError("Introduzca las plataformas en las que está disponible el juego");
            etPlataformas.requestFocus();
            return;
        }

        // 8. Compruebo que la dificultad sea correcta

        // 9. Compruebo que se ha seleccionado algo del RadioGroup
        int idSeleccionado = radioGroup.getCheckedRadioButtonId();

        if(idSeleccionado == -1){
            Toast.makeText(this, "Marque una de las tres opciones con respecto al estado del juego", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rbSeleccionado = findViewById(idSeleccionado);
        String opcionMarcada = rbSeleccionado.getText().toString();

        // Tras comprobar todos los datos, si todos son correctos, envía los datos a la activity de FichaJuego.java
        //Intent intent = new Intent(AltaJuegoActivity.this, FichaJuego.class);
        // Paso todos los datos del formulario, los tendré que recibir en la otra activity
        // todo Esta parafernalia
        //intent.putExtra();
        //intent.putExtra();
        //intent.putExtra();
        //intent.putExtra();
        //intent.putExtra();
        //intent.putExtra();
        //intent.putExtra();
        // intent.putExtra("Dificultad", dificultad);
        //intent.putExtra("Opcion Marcada", opcionMarcada);
        //startActivity(intent);

    }
}
