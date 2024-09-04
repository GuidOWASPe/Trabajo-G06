package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.CantidadRostroFormaDTO;
import pe.edu.upc.demo.dtos.CantidadUsuarioSegunEdadGeneroDTO;
import pe.edu.upc.demo.dtos.UsuarioDTO;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar(){

        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uS.insert(u);
    }

    @GetMapping ("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listId(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.update(u);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }
    @GetMapping("/usuarios_por_paises")
    public List<UsuarioDTO> UsuariosPorPaises(){
        return uS.UsuariosPorPais().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
      
    @GetMapping("/usuariosRostrosFormas")
    public List<CantidadUsuarioSegunEdadGeneroDTO> usuarioSegunEdadGenero(){
        List<String[]>lista= uS.cantidadUsuarioEdadGenero();
        List<CantidadUsuarioSegunEdadGeneroDTO> listaDTO = new ArrayList<>();
        for(String[] columna:lista){
            CantidadUsuarioSegunEdadGeneroDTO dto=new CantidadUsuarioSegunEdadGeneroDTO();
            dto.setRangoEdad(columna[0]);
            dto.setGenero(columna[1]);
            dto.setCantidadUsuario(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
