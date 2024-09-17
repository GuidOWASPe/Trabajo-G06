package pe.edu.upc.demo.dtos;


import pe.edu.upc.demo.entities.Rol;

import java.time.LocalDate;

public class UsuarioDTO {
    private int idUsuario;
    private String nicknameUsuario;
    private String contraseniaUsuario;
    private String correoUsuario;
    private LocalDate fechaNacimientoUsuario;
    private LocalDate fechaRegistroUsuario;
    private String fotoPerfilUsuario;
    private String paisUsuario;
    private String sexoUsuario;
    private Rol ro;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNicknameUsuario() {
        return nicknameUsuario;
    }

    public void setNicknameUsuario(String nicknameUsuario) {
        this.nicknameUsuario = nicknameUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public LocalDate getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public LocalDate getFechaRegistroUsuario() {
        return fechaRegistroUsuario;
    }

    public void setFechaRegistroUsuario(LocalDate fechaRegistroUsuario) {
        this.fechaRegistroUsuario = fechaRegistroUsuario;
    }

    public String getFotoPerfilUsuario() {
        return fotoPerfilUsuario;
    }

    public void setFotoPerfilUsuario(String fotoPerfilUsuario) {
        this.fotoPerfilUsuario = fotoPerfilUsuario;
    }

    public String getPaisUsuario() {
        return paisUsuario;
    }

    public void setPaisUsuario(String paisUsuario) {
        this.paisUsuario = paisUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public Rol getRo() {
        return ro;
    }

    public void setRo(Rol ro) {
        this.ro = ro;
    }
}
