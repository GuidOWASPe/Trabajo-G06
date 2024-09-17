package pe.edu.upc.demo.dtos;

public class PorcentUsuariosporGeneroDTO {
public String genero;
public int cantidadusuarios;
public double porcentaje;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadusuarios() {
        return cantidadusuarios;
    }

    public void setCantidadusuarios(int cantidadusuarios) {
        this.cantidadusuarios = cantidadusuarios;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
