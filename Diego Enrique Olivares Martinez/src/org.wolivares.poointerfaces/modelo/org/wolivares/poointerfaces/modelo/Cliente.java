package org.wolivares.poointerfaces.modelo;

public class Cliente{
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoid;
    
    public Cliente(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public static int getUltimoid() {
        return ultimoid;
    }
    public static void setUltimoid(int ultimoid) {
        Cliente.ultimoid = ultimoid;
    }

    
}