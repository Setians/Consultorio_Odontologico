package dominio;

public class clsOdontograma {
    private int o_Dni;
    private int o_IdNroDiente;
    private int o_IdReferencia;
    private int o_IdSeccion;


    public clsOdontograma()
    {

    }


    public clsOdontograma(int o_Dni, int o_IdNroDiente,int o_IdReferencia, int o_IdSeccion) {
        super();
        this.o_Dni = o_Dni;
        this.o_IdNroDiente = o_IdNroDiente;
        this.o_IdReferencia = o_IdReferencia;
        this.o_IdSeccion = o_IdSeccion;
    }


    public int geto_Dni() {
        return o_Dni;
    }


    public void seto_Dni(int o_Dni) {
        this.o_Dni = o_Dni;
    }


    public int geto_IdNroDiente() {
        return o_IdNroDiente;
    }


    public void seto_IdNroDiente(int o_IdNroDiente) {
        this.o_IdNroDiente = o_IdNroDiente;
    }

    public int geto_IdReferencia() {
        return o_IdReferencia;
    }


    public void seto_IdReferencia(int o_IdReferencia) {
        this.o_IdReferencia = o_IdReferencia;
    }

    public int geto_IdSeccion() {
        return o_IdSeccion;
    }


    public void seto_IdSeccion(int o_IdSeccion) {
        this.o_IdSeccion = o_IdSeccion;
    }


}