package pe.edu.upc.demo.dtos;

public class CantidadUsuarioSegunEdadGeneroDTO {


    private String rangoEdad;
    private String genero;
    private int cantidadUsuario;

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadUsuario() {
        return cantidadUsuario;
    }

    public void setCantidadUsuario(int cantidadUsuario) {
        this.cantidadUsuario = cantidadUsuario;
    }
}
