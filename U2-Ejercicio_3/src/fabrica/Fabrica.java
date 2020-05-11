/*
 3. Una empresa que fabrica caños de diferentes tipos, materiales y medidas está
desarrollando un sistema para automatizar la planificación y control de su circuito
productivo. Suponga que usted es parte del equipo de desarrollo y le asignan la
siguiente tarea:
 Laboratorio de Computación III – Guía de Estudio U2 – Pág. 2
 Desarrolle la clase Material de manera que contenga en su interior los
atributos: descripción (String) código(int) valorUnitario (float).
 Desarrolle la clase Producto de manera que contenga en su interior los
atributos descripción (String) y Materiales (Material[]).
 Desarrolle en la clase Producto un constructor que reciba por parámetro una
cantidad de elementos y dimensione el vector de materiales.

 Desarrolle en la clase Producto un método que permita agregar un Material
recibido por parámetro al vector.
 Desarrolle en la clase Producto un método que retorne el costo total. Dicho
valor se calcula sumando todos los valores unitarios de los Materiales que
componen el Producto.
 Desarrolle en la clase Producto un método que reciba por parámetro un código
de material y retorne true si dicho material forma parte del Producto.
 Desarrolle en la clase producto un método que retorne un vector con todos los
materiales que tengan un valor unitario menor a un parámetro.
 Desarrolle en la clase producto un método que retorne un vector donde cada
casillero contenga la cantidad de materiales por precio, siguiendo las siguiente
regla: Si 0 < precio ≤ 10 contarlo en el primer casillero. Si 10 < precio ≤ 20
contarlo en el segundo casillero. Si 20 < precio ≤ 30 contarlo en el tercer
casillero. Si precio > 30 contarlo en el cuarto casillero.

 Desarrolle un programa principal que permita ingresar los datos de un
producto, cree un objeto de esa clase y luego posibilite mediante un menú
llamar a los métodos de los puntos 4 a 8 todas las veces y en el orden que el
usuario quiera.

* @author Emiliano Correa - 2W2 - 110947
 */
package fabrica;

import java.util.Scanner;

public class Fabrica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la descripción del nuevo producto:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese la cantidad de materiales por la que está compuesto:");
        int cantidadMateriales = sc.nextInt();
        System.out.println("");
        Producto producto = new Producto(cantidadMateriales);
        producto.setDescripcion(descripcion);
        
        int respuesta = -1;
        while (respuesta != 0) {            
            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("");
            System.out.println("1. Agregar un nuevo material al producto");
            System.out.println("2. Ver el costo total del producto");
            System.out.println("3. Chequear si el producto contiene un material específico");
            System.out.println("4. Obtener una lista de materiales cuyo valor unitario sea menor a un valor ingresado");
            System.out.println("5. Obtener una lista de cantidades de materiales por precio");
            System.out.println("0. Salir del programa");
            System.out.println("");
            System.out.println("Su respuesta:");
            respuesta = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            
            if (respuesta == 1) {
                System.out.println("Ingrese la descripción del material:");
                String descripcionMaterial = sc.nextLine();
                System.out.println("Ingrese el código del material:");
                int codigoMaterial = sc.nextInt();
                System.out.println("Ingrese el valor unitario del material:");
                float valorMaterial = sc.nextFloat();
                System.out.println("");
                
                Material materialAgregado = new Material(descripcionMaterial, codigoMaterial, valorMaterial);
                producto.agregarMaterial(materialAgregado);
            }
            else if (respuesta == 2){
                System.out.println("El costo total del producto es de $" + producto.calcularCostoTotal());
                System.out.println("--------------------------------------------");
                System.out.println("");
            }
            else if (respuesta == 3){
                System.out.println("Ingrese el código del material a buscar en el producto:");
                int codigoMaterialBuscado = sc.nextInt();
                System.out.println("");
                if (producto.tieneMaterial(codigoMaterialBuscado)) {
                    System.out.println("El producto contiene el material.");
                    System.out.println("--------------------------------------------");
                    System.out.println("");
                }
                else {
                    System.out.println("El producto NO contiene el material.");
                    System.out.println("--------------------------------------------");
                    System.out.println("");
                }
            }
            else if (respuesta == 4){
                System.out.println("Ingrese un valor para obtener una lista de materiales cuyo valor unitario no lo supere:");
                float valorMaximo = sc.nextFloat();
                System.out.println("");
                System.out.println("Los valores unitarios de los siguientes materiales no superan el valor ingresado:");
                Material[] listaMateriales = producto.buscarMaterialesMasBaratos(valorMaximo);
                for (int i = 0; i < listaMateriales.length; i++) {
                    if (listaMateriales[i] != null) {
                        listaMateriales[i].materialToString();
                    }
                }
                System.out.println("--------------------------------------------");
                System.out.println("");
            }
            else if (respuesta == 5){
                System.out.println("A continuación se presenta una lista de cantidad de materiales por rango de precio:");
                System.out.println("");
                producto.materialesPorPrecioToString(producto.materialesPorPrecio());
                System.out.println("--------------------------------------------");
                System.out.println("");
            }
            else if (respuesta == 0){
                System.out.println("Cerrando el programa...");
            }
        }
    }
    
}
