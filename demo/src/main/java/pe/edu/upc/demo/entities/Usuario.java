package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "username",length = 100 , unique = true)
    private String username;
    @Column(name = "password",length = 100)
    private String password;
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
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, String correoUsuario, LocalDate fechaNacimientoUsuario, LocalDate fechaRegistroUsuario, String fotoPerfilUsuario, String paisUsuario, String sexoUsuario, Boolean enabled, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.correoUsuario = correoUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.fotoPerfilUsuario = fotoPerfilUsuario;
        this.paisUsuario = paisUsuario;
        this.sexoUsuario = sexoUsuario;
        this.enabled = enabled;
        this.roles = roles;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public LocalDate getFechaRegistroUsuario() {
        return fechaRegistroUsuario;
    }

    public void setFechaRegistroUsuario(LocalDate fechaRegistroUsuario) {
        this.fechaRegistroUsuario = fechaRegistroUsuario;
    }

    public LocalDate getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
