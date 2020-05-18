package cuentas;

public class CuentaCorriente extends Cuenta {
    private float acuerdo;

    public float getAcuerdo() {
        return acuerdo;
    }

    public void setAcuerdo(float acuerdo) {
        this.acuerdo = acuerdo;
    }

    public CuentaCorriente(float acuerdo, int numeroCta, String nombre, float saldo) {
        super(numeroCta, nombre, saldo);
        this.acuerdo = acuerdo;
    }
  
    @Override
    public void extraer(float extraccion){
        if ((this.saldo - extraccion) < (0 - this.acuerdo))
            System.out.println("Se supera el saldo en descubierto permitido");
        else
            this.saldo -= extraccion;
    }
}
