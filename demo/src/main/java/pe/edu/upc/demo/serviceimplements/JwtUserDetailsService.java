package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findOneByUsername(username);
        Rol rol11 = user.getRo();
        List<GrantedAuthority> roles = new ArrayList<>();

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }
        String rol = rol11.getNombre();
        roles.add(new SimpleGrantedAuthority(rol));

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNicknameUsuario(), user.getContraseniaUsuario(), user.getEnabled(), true, true, true, roles);

        return ud;
    }
}