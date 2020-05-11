package fabrica;

/**
 *
 * @author usuario
 */
public class Material {
    private String descripcion;
    private int codigo;
    private float valorUnitario;

    public Material() {
    }

    public Material(String descripcion, int codigo, float valorUnitario) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.valorUnitario = valorUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }   
    
    public String materialToString(){
        return "Código: " + this.getCodigo()
                + " - Descripción: "+ this.getDescripcion()
                + " - Valor Unitario: " + this.getValorUnitario() + "\n";
    }
}
