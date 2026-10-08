package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import java.util.ArrayList;

// Clase que almacena los datos de un Videojuego, necesaria para próximas implementaciones, como por ejemplo las bases de datos
public class Videojuego {
    protected String titulo;
    protected double precio;
    protected String genero;
    protected String numJugadores; // ej: 1 a 4 jugadores
    protected int edadRecomendada;
    protected ArrayList<String> plataformas; // ej: Consolas, PC, etc...

    public Videojuego() {
    }

    public Videojuego(String titulo, double precio, String genero, String numJugadores, int edadRecomendada, ArrayList<String> plataformas) {
        this.titulo = titulo;
        this.precio = precio;
        this.genero = genero;
        this.numJugadores = numJugadores;
        this.edadRecomendada = edadRecomendada;
        this.plataformas = plataformas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(String numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public ArrayList<String> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(ArrayList<String> plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", genero='" + genero + '\'' +
                ", numJugadores='" + numJugadores + '\'' +
                ", edadRecomendada=" + edadRecomendada +
                ", plataformas=" + plataformas +
                '}';
    }
}