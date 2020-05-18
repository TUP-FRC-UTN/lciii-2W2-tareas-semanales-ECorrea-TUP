package cuentas;

public class CajaAhorro extends Cuenta{

    public CajaAhorro(int numeroCta, String nombre, float saldo) {
        super(numeroCta, nombre, saldo);
    }
    
    @Override
    public void extraer(float extraccion){
        if ((this.saldo - extraccion) < 0)
            System.out.println("Su saldo es insuficiente para realizar esta operación.");
        else
            this.saldo -= extraccion;
    }
}