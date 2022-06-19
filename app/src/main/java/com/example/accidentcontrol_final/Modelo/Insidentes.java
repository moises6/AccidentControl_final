package com.example.accidentcontrol_final.Modelo;

public class Insidentes {


     public static String Descripcion;
    public static String Fecha;
    public static String TipoInsidente;

    public Insidentes() {
    }

    public Insidentes(String descripcion, String fecha, String tipoInsidente) {
        Descripcion = descripcion;
        Fecha = fecha;
        TipoInsidente = tipoInsidente;
    }

    public static String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public static String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public static String getTipoInsidente() {
        return TipoInsidente;
    }

    public void setTipoInsidente(String tipoInsidente) {
        TipoInsidente = tipoInsidente;
    }
}
