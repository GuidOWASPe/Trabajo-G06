package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nicknameUsuario",length = 100,nullable = false)
    private String nicknameUsuario;
    @Column(name = "contraseniaUsuario",length = 100,nullable = false)
    private String contraseniaUsuario;
    @Column(name = "correoUsuario",nullable = false)
    private String correoUsuario;
    @Column(name = "fechaNacimientoUsuario",nullable = false)
    private LocalDate fechaNacimientoUsuario;
    @Column(name = "fechaRegistroUsuario",nullable = false)
    private LocalDate fechaRegistroUsuario;
    @Column(name = "fotoPerfilUsuario",length = 100,nullable = false)
    private String fotoPerfilUsuario;
    @Column(name = "paisUsuario",length = 100,nullable = false)
    private String paisUsuario;
    @Column(name = "sexoUsuario",length = 100,nullable = false)
    private String sexoUsuario;
    
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol ro;

    public Usuario() {
    }

    public Usuario(int idUsuario, Rol ro, String sexoUsuario, String paisUsuario, String fotoPerfilUsuario, LocalDate fechaRegistroUsuario, LocalDate fechaNacimientoUsuario, String correoUsuario, String contraseñaUsuario, String nicknameUsuario) {
        this.idUsuario = idUsuario;
        this.ro = ro;
        this.sexoUsuario = sexoUsuario;
        this.paisUsuario = paisUsuario;
        this.fotoPerfilUsuario = fotoPerfilUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.nicknameUsuario = nicknameUsuario;
    }

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
