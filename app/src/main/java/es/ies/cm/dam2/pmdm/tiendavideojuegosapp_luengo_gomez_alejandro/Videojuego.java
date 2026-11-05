package es.ies.cm.dam2.pmdm.tiendavideojuegosapp_luengo_gomez_alejandro;

import java.time.LocalDate;
import java.util.ArrayList;

// Clase que almacena los datos de un Videojuego, necesaria para próximas implementaciones, como por ejemplo las bases de datos
public class Videojuego {
    protected String titulo;
    protected double precio;
    protected String genero; // aventura, rol, etc...
    protected int minJugadores;
    protected int maxJugadores; // ej: 1 a 4 jugadores
    protected int edadRecomendada; // +3, +7, etc...

    protected LocalDate fechaSalida;
    protected ArrayList<String> plataformas; // ej: Consolas, PC, etc...

    public Videojuego() {
    }

    public Videojuego(String titulo, double precio, String genero, int minJugadores, int maxJugadores, int edadRecomendada, LocalDate fechaSalida, ArrayList<String> plataformas) {
        this.titulo = titulo;
        this.precio = precio;
        this.genero = genero;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
        this.edadRecomendada = edadRecomendada;
        this.fechaSalida = fechaSalida;
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

    public int getMinJugadores() {
        return minJugadores;
    }

    public void setMinJugadores(int minJugadores) {
        this.minJugadores = minJugadores;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
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
                ", minJugadores=" + minJugadores +
                ", maxJugadores=" + maxJugadores +
                ", edadRecomendada=" + edadRecomendada +
                ", fechaSalida=" + fechaSalida +
                ", plataformas=" + plataformas +
                '}';
    }
}