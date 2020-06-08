package practica03;

/**
 * Esta clase representa una cuenta de crédito, la cual se abre con un límite 
 * de crédito.
 */
public class CuentaCredito extends Cuenta {
    
    private double limiteCredito;

    /**
     * Constructor de la clase CuentaCredito crea una nueva instancia de esta.
     * @param propietario
     * @param numero
     * @param saldoInicial
     * @param limiteCredito 
     */
    public CuentaCredito(
            Persona propietario, String numero, double saldoInicial,
            double limiteCredito) {
        
        // El contructor de la superclase es lo primero que hay que ejecutar.
        super("Crédito", propietario, numero, saldoInicial);
        
        this.limiteCredito = limiteCredito;
        
    }
    
    public double getLimiteCredito() { return limiteCredito; }
    
    public double getSaldoDisponible() {
        return getLimiteCredito() - getSaldo();
    }
    
    public void aumentarLimiteCredito(double en) {
        limiteCredito += Math.abs(en);
    }
    
    public boolean retirar(double cantidad) {
        cantidad = Math.abs(cantidad);
        if (cantidad > getSaldoDisponible()) return false;
        saldo += cantidad;
        return true;
    }
    
    public void pagar(double cantidad) {
        cantidad = Math.abs(cantidad);
        saldo -= cantidad;
    }
    
}
