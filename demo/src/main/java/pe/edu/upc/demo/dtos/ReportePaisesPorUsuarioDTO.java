package pe.edu.upc.demo.dtos;

public class ReportePaisesPorUsuarioDTO {
    private String paisUsuario;
    private int cantidad;

    public String getPaisUsuario() {
        return paisUsuario;
    }

    public void setPaisUsuario(String paisUsuario) {
        this.paisUsuario = paisUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
