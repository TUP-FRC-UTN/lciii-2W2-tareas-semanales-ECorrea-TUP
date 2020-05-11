package fabrica;

public class Producto {
    private String descripcion;
    private Material[] Materiales;

    public Producto() {
    }

    public Producto(String descripcion, Material[] Materiales) {
        this.descripcion = descripcion;
        this.Materiales = Materiales;
    }
    
    public Producto(int cantidadMateriales) {
        this.Materiales = new Material[cantidadMateriales];
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Material[] getMateriales() {
        return Materiales;
    }
    
    public void agregarMaterial(Material material){
        for (int i = 0; i < this.Materiales.length; i++) {
            if (this.Materiales[i] == null) {
                this.Materiales[i] = material;
                System.out.println("MATERIAL AGREGADO CORRECTAMENTE" + "\n" + Materiales[i].materialToString());
                break;
            }
            else {
                System.out.println("ERROR - No se pueden agregar más materiales");
                System.out.println("");
                break;
            }
        }
    }
    
    public float calcularCostoTotal(){
        float costoTotal = 0;
        for (int i = 0; i < this.Materiales.length; i++) {
            if (Materiales[i] != null) {
                costoTotal += Materiales[i].getValorUnitario();
            }            
        }
        return costoTotal;
    }
    
    public boolean tieneMaterial(int codigoMaterial){
        boolean tieneMaterial = false;
        for (int i = 0; i < this.Materiales.length; i++) {
            if (this.Materiales[i] != null) {
                if (this.Materiales[i].getCodigo() == codigoMaterial) {
                    tieneMaterial = true;
                    break;
                }
            }            
        }
        return tieneMaterial;
    }
    
    public Material[] buscarMaterialesMasBaratos(float valor){
        Material[] materiales = new Material[this.Materiales.length];
        
        for (int i = 0; i < this.Materiales.length; i++) {
            if (this.Materiales[i] != null && this.Materiales[i].getValorUnitario() < valor) {
                for (int j = 0; j < materiales.length; j++) {
                    if (materiales[j] == null) {
                        materiales[j] = Materiales[i];
                        System.out.println(materiales[j].materialToString());
                        break;
                    }
                }
            }
        }        
        return materiales;
    }
    
    public int [] materialesPorPrecio(){
        int precioHastaDiez = 0;
        int precioHastaVeinte = 0;
        int precioHastaTreinta = 0;
        int precioMayorTreinta = 0;
        int[] materialesPorPrecio = new int[4];
        
        for (int i = 0; i < materialesPorPrecio.length; i++) {
            materialesPorPrecio[i] = 0;            
        }
        
        for (int i = 0; i < Materiales.length; i++) {
            if (Materiales[i].getValorUnitario() > 0 && Materiales[i].getValorUnitario() <= 10) {
                precioHastaDiez++;
            }
            else if (Materiales[i].getValorUnitario() > 10 && Materiales[i].getValorUnitario() <= 20) {
                precioHastaVeinte++;
            }
            else if (Materiales[i].getValorUnitario() > 20 && Materiales[i].getValorUnitario() <= 30) {
                precioHastaTreinta++;
            }
            else if (Materiales[i].getValorUnitario() > 30) {
                precioMayorTreinta++;
            }            
        }
        materialesPorPrecio[0] = precioHastaDiez;
        materialesPorPrecio[1] = precioHastaVeinte;
        materialesPorPrecio[2] = precioHastaTreinta;
        materialesPorPrecio[3] = precioMayorTreinta;
        
        return materialesPorPrecio;
    }
    
    public void materialesPorPrecioToString(int[] materialesPorPrecio){
        System.out.println("Cantidad de materiales con valores unitarios menores o iguales a 10: " + materialesPorPrecio[0]);
        System.out.println("Cantidad de materiales con valores unitarios menores o iguales a 20: " + materialesPorPrecio[1]);
        System.out.println("Cantidad de materiales con valores unitarios menores o iguales a 30: " + materialesPorPrecio[2]);
        System.out.println("Cantidad de materiales con valores unitarios mayores a 30: " + materialesPorPrecio[3]);
    }
}
