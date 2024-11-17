package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.EstiloUsuarioConPCDTO;
import pe.edu.upc.demo.dtos.EstiloUsuarioDTO;
import pe.edu.upc.demo.entities.EstiloUsuario;
import pe.edu.upc.demo.serviceinterfaces.IEstiloUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estiloUsuario")
@PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
public class EstiloUsuarioController {
    @Autowired
    private IEstiloUsuarioService eS;

    @GetMapping
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<EstiloUsuarioDTO> listar(){

        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,EstiloUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CLIENTE')")
    public void insertar(@RequestBody EstiloUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloUsuario v=m.map(dto,EstiloUsuario.class);
        eS.insert(v);
    }
    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public EstiloUsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstiloUsuarioDTO dto = m.map(eS.listId(id), EstiloUsuarioDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody EstiloUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloUsuario v=m.map(dto,EstiloUsuario.class);
        eS.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        eS.delete(id);
    }


    @GetMapping("/ListarEstiloDeUsuarioConPeorCalifiacion")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EstiloUsuarioConPCDTO> estiloUsuarioConPeorCalificacion(){
        List<String[]> lista=eS.estiloUsuarioConPC();
        List<EstiloUsuarioConPCDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            EstiloUsuarioConPCDTO dto=new EstiloUsuarioConPCDTO();
            dto.setId_estilo_fav(Integer.parseInt(columna[0]));
            dto.setNickname_usuario(columna[1]);
            dto.setNombre_estilo(columna[2]);
            dto.setCalificacion_estilo(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
