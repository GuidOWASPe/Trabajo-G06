package pe.edu.upc.demo.dtos;

public class ReporteEstilosPorUsuarioDTO {
    private String nickname_usuario;
    private int cantidad_estilos;

    public String getNickname_usuario() {
        return nickname_usuario;
    }

    public void setNickname_usuario(String nickname_usuario) {
        this.nickname_usuario = nickname_usuario;
    }

    public int getCantidad_estilos() {
        return cantidad_estilos;
    }

    public void setCantidad_estilos(int cantidad_estilos) {
        this.cantidad_estilos = cantidad_estilos;
    }
}
