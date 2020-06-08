package practica03;

/**
 * Representa una cuenta básica de ahorro.
 */
public class CuentaAhorro extends Cuenta {
       
    public CuentaAhorro(
            Persona propietario, String numero, double saldoInicial) {
        super("Ahorro", propietario, numero, saldoInicial);
    }

    public void depositar(double cantidad) {
        if (cantidad < 0.0) return;
        saldo += cantidad;
    }
    
    public boolean retirar(double cantidad) {
        cantidad = Math.abs(cantidad);
        if (cantidad > saldo) return false;
        saldo -= cantidad;
        return true;
    }
    
}
