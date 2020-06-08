package practica03;

/**
 * Representa una cuenta bancaria genérica la cual según su implementación puede
 * ser de ahorro o de crédito.
 */
public class Cuenta {
    
    private String tipo;
    private Persona propietario;
    private String numero;
    protected double saldo;  // variable de instancia puede ser accedida en subclases.
    
    public Cuenta(
            String tipo, Persona propietario, String numero, double saldoInicial) {
        this.tipo = tipo;
        this.propietario = propietario;
        this.numero = numero;
        this.saldo = saldoInicial;
    }
    
    public String getTipo() { return tipo; }
    
    public Persona getPropietario() { return propietario; }
    
    public String getNumero() { return numero; }
    
    public double getSaldo() { return saldo; }
    
    
}
