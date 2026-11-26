package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FichaJuego extends AppCompatActivity {

    // Segunda clase de la práctica 4
    // Para la práctica ocho pasará a ser ColeccionJuegos
    // En la nueve se hará con un RecyclerView
    private TextView tvDatosJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_juego);

        tvDatosJuego = findViewById(R.id.tvDatosJuego);
        Button btnVolverAlMenuFJ = findViewById(R.id.btnVolverAlMenuFJ);

        recibirYMostrarDatos();

        btnVolverAlMenuFJ.setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        });
    }

    private void recibirYMostrarDatos(){
        // Recibo los datos de AltaJuegoActivity
        int minJugadores = getIntent().getIntExtra("minJugadores", 0);
        int maxJugadores = getIntent().getIntExtra("maxJugadores", 0);
        String nombre = getIntent().getStringExtra("nombre");
        String precio = getIntent().getStringExtra("precio");
        String genero = getIntent().getStringExtra("genero");
        String edadRecomendada = getIntent().getStringExtra("edadRecomendada"); // Valor seleccionado de un Spinner por eso lo recibo como String
        String fechaLanzamiento = getIntent().getStringExtra("fechaLanzamiento");
        String plataformas = getIntent().getStringExtra("plataformas");
        int dificultad = getIntent().getIntExtra("dificultad", 0);
        String opcionMarcada = getIntent().getStringExtra("opcionMarcada");

        // Muestro los datos recibidos
        String datos = "Nombre: " + nombre +
                "\n\nJugadores mínimos: " + minJugadores +
                "\nJugadores máximos: " + maxJugadores +
                "\n\nPrecio: " + precio + " €" +
                "\nGénero: " + genero +
                "\nEdad recomendada: " + edadRecomendada +
                "\nFecha de lanzamiento: " + fechaLanzamiento +
                "\nPlataformas: " + plataformas +
                "\nDificultad: " + dificultad +
                "\nEstado: " + opcionMarcada;

        tvDatosJuego.setText(datos);
    }
}
