package pe.edu.upc.demo.dtos;

import java.time.LocalDate;

public class PorcentUsuariosMesDTO {

    public LocalDate mesregistro;
    public int usuariosregistrados;
    public double porcentaje;

    public LocalDate getMesregistro() {
        return mesregistro;
    }

    public void setMesregistro(LocalDate mesregistro) {
        this.mesregistro = mesregistro;
    }

    public int getUsuariosregistrados() {
        return usuariosregistrados;
    }

    public void setUsuariosregistrados(int usuariosregistrados) {
        this.usuariosregistrados = usuariosregistrados;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
