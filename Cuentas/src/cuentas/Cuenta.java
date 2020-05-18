/*
 2. En un banco hay dos tipos de cuentas: cajas de ahorro y cuentas corrientes.
Programar una clase Cuenta y dos derivadas correspondientes a cada uno de los
tipos de cuenta.
La clase Cuenta debe poseer dos métodos para operar con las mismas llamados
Depositar y Extraer.
Las cajas de ahorro no permiten extracciones si el saldo no es suficiente, mientras
que las cuentas corrientes poseen un atributo “acuerdo” que indica el máximo saldo
negativo admisible. La clase cuenta debe poseer al menos los atributos número,
nombre y saldo.

* @author Emiliano Correa - 2W2 - 110947
 */
package cuentas;

public class Cuenta {
    protected int numeroCta;
    protected String nombre;
    protected float saldo;

    public Cuenta() {
    }

    public Cuenta(int numeroCta, String nombre, float saldo) {
        this.numeroCta = numeroCta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public int getNumeroCta() {
        return numeroCta;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setNumeroCta(int numeroCta) {
        this.numeroCta = numeroCta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(float deposito){
        this.saldo += deposito;
    }
    
    public void extraer(float extraccion){
        this.saldo -= extraccion;
    }
}
