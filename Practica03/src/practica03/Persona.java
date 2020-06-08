package practica03;

/**
 * Representa a una persona genérica.
 */
public class Persona {
    
    private String nombre;
    private String apellidos;
    private int edad;
    private String email;
    
    public String getNombre() { return nombre; }
    
    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }
    
    public String getApellidos() { return apellidos; }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }
    
    public int getEdad() { return edad; }
    
    public void setEdad(int edad) {
        this.edad = Math.abs(edad);
    }
    
    public String getEmail() { return email; }
    
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }
    
    public String getNombreCompleto() {
        return getNombre() + " " + getApellidos();
    }
    
}
