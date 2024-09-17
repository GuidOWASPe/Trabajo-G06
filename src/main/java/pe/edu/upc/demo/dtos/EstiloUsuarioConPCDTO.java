package pe.edu.upc.demo.dtos;

public class EstiloUsuarioConPCDTO {
    private Integer id_estilo_fav;
    private String nickname_usuario;
    private String nombre_estilo;
    private Integer calificacion_estilo;

    public Integer getId_estilo_fav() {
        return id_estilo_fav;
    }

    public void setId_estilo_fav(Integer id_estilo_fav) {
        this.id_estilo_fav = id_estilo_fav;
    }

    public String getNickname_usuario() {
        return nickname_usuario;
    }

    public void setNickname_usuario(String nickname_usuario) {
        this.nickname_usuario = nickname_usuario;
    }

    public String getNombre_estilo() {
        return nombre_estilo;
    }

    public void setNombre_estilo(String nombre_estilo) {
        this.nombre_estilo = nombre_estilo;
    }

    public Integer getCalificacion_estilo() {
        return calificacion_estilo;
    }

    public void setCalificacion_estilo(Integer calificacion_estilo) {
        this.calificacion_estilo = calificacion_estilo;
    }
}
