package practica03;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase principal de la aplicación.
 */
public class Practica03 {

    /**
     * Punto de entrada de la aplicación.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Practica03 app = new Practica03();
        app.run();        
    }
    
    /**
     * 
     */
    public void run() {
        
        System.out.println("\t\t== Práctica 03 ==\n");
        
        int opcion = 0;
        do {
            
            imprimirMenu();
            System.out.print("Opción: ");
            opcion = in.nextInt(); in.nextLine();
            
            System.out.println("");
            
            switch (opcion) {
                case 1:  // Ver todas las cuentas.
                    verCuentas();
                    break;
                case 2:  // Ver detalle de una cuenta.
                    verDetalleCuenta();
                    break;
                case 3:  // Agregar una cuenta.
                    agregarCuenta();
                    break;
                case 4:  // Retirar de una cuenta.
                    retirarDeCuenta();
                    break;
                case 5:  // Depositar/Pagar una cuenta.
                    depositarPagarCuenta();
                    break;
                case 0:  // SALIR
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("[Opción no válida]");
            }
            
            System.out.println("");
            
        }
        while (opcion != 0);
        
    }
    
    public void imprimirMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println(" 1. Ver todas las cuentas.");
        System.out.println(" 2. Ver detalle de una cuenta.");
        System.out.println(" 3. Agregar una cuenta.");
        System.out.println(" 4. Retirar de una cuenta.");
        System.out.println(" 5. Depositar/Pagar una cuenta.");
        System.out.println(" 0. SALIR.");
        
    }
    
    public void verCuentas() {
        
        if (cuentas.isEmpty()) {
            System.out.println("[No hay cuentas registradas]");
            return;
        }
        
        for (Cuenta cuenta : cuentas) {            
            System.out.printf(
                    "%s (%s) de %s\n", cuenta.getNumero(), cuenta.getTipo(),
                    cuenta.getPropietario().getNombreCompleto());
        }
        
    }
    
    public void verDetalleCuenta() {
        
        System.out.print("Ingrese el número de la cuenta a mostrar: ");
        String numero = in.nextLine();
        Cuenta cuenta = obtenerCuentaPorNumero(numero);
        if (cuenta == null) {
            System.out.println("[No existe la cuenta]");
            return;
        }
        
        System.out.println("Numero: " + cuenta.getNumero());
        System.out.println(
                "Propietario: " + cuenta.getPropietario().getNombreCompleto());
        System.out.println("Tipo: " + cuenta.getTipo());
        System.out.printf("Saldo: $ %,.02f \n", cuenta.getSaldo());
        
        // si el objeto cuenta es de tipo CuentaCredio
        if (cuenta instanceof CuentaCredito) {  
            
            //                       Operador CAST 
            CuentaCredito cCredito = (CuentaCredito)cuenta;
            System.out.printf(
                    "Límite de crédito: $ %,.02f \n", cCredito.getLimiteCredito());
            System.out.printf(
                    "Crédito disponible: $ %,.02f\n", cCredito.getSaldoDisponible());
                
        }
        
    }
    
    public void agregarCuenta() {
        
        System.out.println("Ingrese los datos del propietario.");
        System.out.print("Nombre: ");
        String nombre = in.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        
        Persona propietario = new Persona();
        propietario.setNombre(nombre);
        propietario.setApellidos(apellidos);
        propietario.setEmail(email);
        
        System.out.println("Ingrese los datos de la cuenta.");
        System.out.print("Número: ");
        String numero = in.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = in.nextDouble(); in.nextLine();
        
        System.out.print("Tipo de cuenta (1 = Ahorro, 2 = Crédito): ");
        short tipoCuenta = in.nextShort(); in.nextLine();
        
        double limiteCredito = 0.0;
        if (tipoCuenta == 2) {
            System.out.print("Límite de crédito: ");
            limiteCredito = in.nextDouble(); in.nextLine();
        }
        
        // Por buenas prácticas siempre hay que inicializar las variables,
        // aunque sean en null.
        Cuenta cuenta = null;
        switch (tipoCuenta) {
            case 1:  // Creamos objeto tipo CuentaAhorro.
                cuenta = new CuentaAhorro(propietario, numero, saldo);
                break;
            case 2:  
                cuenta = new CuentaCredito(
                        propietario, numero, saldo, limiteCredito);
                break;
        }
        
        if (cuenta == null) {
            System.out.println("[ERROR: tipo de cuentan no válido]");
            return;
        }
        
        cuentas.add(cuenta);
        
    }
    
    public Cuenta obtenerCuentaPorNumero(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equalsIgnoreCase(numeroCuenta))
                return cuenta;
        }
        return null;
    }
    
    public void retirarDeCuenta() {
        // TODO: Implementar el funcionamiento.
        
        System.out.print("Ingrese el número de la cuenta: ");
        String numero = in.nextLine();
        Cuenta cuenta = obtenerCuentaPorNumero(numero);
        if (cuenta == null) {
            System.out.println("[No existe la cuenta]");
            return;
        }
        System.out.println("Numero: " + cuenta.getNumero());
        System.out.println(
                "Propietario: " + cuenta.getPropietario().getNombreCompleto());
        System.out.println("Tipo: " + cuenta.getTipo());
        
        System.out.printf("Saldo: $ %,.02f \n", cuenta.getSaldo());
        //Cuenta cuenta = null;
        switch (cuenta.getTipo()) {
            case "Ahorro":  // Creamos objeto tipo CuentaAhorro.
                //Ahorro
                // si el objeto cuenta es de tipo CuentaAhorro
                if (cuenta instanceof CuentaAhorro) {  

                    //                       Operador CAST 
                    CuentaAhorro cAhorro = (CuentaAhorro)cuenta;
                    System.out.println("Ingrese el monto a retirar: ");
                    double Monto = in.nextDouble(); in.nextLine();
                    System.out.print("Desea Retirar la siguiente cantidad (1 = Si, 2 = No): "+ Monto);
                    int Confirmacion = in.nextInt();;
                    if(Confirmacion == 1){
                        cAhorro.retirar(Monto);
                        System.out.printf("Usted retiro la cantidad de: " + Monto);
                    }else{
                        System.out.println("Retiro Canselado!");
                    }
                    

                }
                break;
            case "Crédito":  
                //Credito
                // si el objeto cuenta es de tipo CuentaCredio
                if (cuenta instanceof CuentaCredito) {  

                    //                       Operador CAST 
                    CuentaCredito cCredito = (CuentaCredito)cuenta;
                    System.out.println("Ingrese el monto a retirar: ");
                    double Monto = in.nextDouble(); in.nextLine();
                    System.out.print("Desea Retirar la siguiente cantidad (1 = Si, 2 = No): "+ Monto);
                    int Confirmacion = in.nextInt();;
                    if(Confirmacion == 1){
                        cCredito.retirar(Monto);
                        System.out.printf("Usted retiro la cantidad de: " + Monto);
                    }else{
                        System.out.println("Retiro Canselado!");
                    }
                    

                }
                break;
        }
        
        
    }
    
    public void depositarPagarCuenta() {
        // TODO: Implementar el funcionmiento de pagar o depositar a una cuenta.
         System.out.print("Ingrese el número de la cuenta a depositar: ");
        String numero = in.nextLine();
        Cuenta cuenta = obtenerCuentaPorNumero(numero);
        if (cuenta == null) {
            System.out.println("[No existe la cuenta]");
            return;
        }
        //Cuenta cuenta = null;
        switch (cuenta.getTipo()) {
            case "Ahorro":  // Creamos objeto tipo CuentaAhorro.
                //Ahorro
                // si el objeto cuenta es de tipo CuentaAhorro
                if (cuenta instanceof CuentaAhorro) {  

                    //                       Operador CAST 
                    CuentaAhorro cAhorro = (CuentaAhorro)cuenta;
                    System.out.println("Ingrese el monto a Depositar: ");
                    double Monto = in.nextDouble(); in.nextLine();
                    System.out.print("Desea depositar la siguiente cantidad (1 = Si, 2 = No): "+ Monto);
                    int Confirmacion = in.nextInt();;
                    if(Confirmacion == 1){
                        cAhorro.depositar(Monto);
                        System.out.printf("Usted deposito la cantidad de: " + Monto);
                    }else{
                        System.out.println("deposito Canselado!");
                    }
                    

                }
                break;
            case "Crédito":  
                //Credito
                // si el objeto cuenta es de tipo CuentaCredio
                if (cuenta instanceof CuentaCredito) {  

                    //                       Operador CAST 
                    CuentaCredito cCredito = (CuentaCredito)cuenta;
                    System.out.println("Ingrese el monto a pagar: ");
                    double Monto = in.nextDouble(); in.nextLine();
                    System.out.print("Desea pagar la siguiente cantidad (1 = Si, 2 = No): "+ Monto);
                    int Confirmacion = in.nextInt();;
                    if(Confirmacion == 1){
                        cCredito.pagar(Monto);
                        System.out.printf("Usted Pago la cantidad de: " + Monto);
                    }else{
                        System.out.println("Pago Canselado!");
                    }
                    

                }
                break;
        }
        
    }

    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

}
