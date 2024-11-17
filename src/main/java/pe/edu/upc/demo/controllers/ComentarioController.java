package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.ComentarioDTO;
import pe.edu.upc.demo.dtos.ComentariosNegativosFrecuentesDTO;
import pe.edu.upc.demo.entities.Comentario;
import pe.edu.upc.demo.serviceinterfaces.IComentarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
@PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
public class ComentarioController {
    @Autowired
    private IComentarioService cT;

    @GetMapping
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<ComentarioDTO> listar() {
        return cT.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
  
    @PostMapping
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public void insertar(@RequestBody ComentarioDTO dto){
        ModelMapper m=new ModelMapper();
        Comentario u=m.map(dto, Comentario.class);
        cT.insert(u);
    }

    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ComentarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ComentarioDTO dto = m.map(cT.listId(id), ComentarioDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody ComentarioDTO dto){
        ModelMapper m=new ModelMapper();
        Comentario u=m.map(dto,Comentario.class);
        cT.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        cT.delete(id);
    }


    @GetMapping("/ListarCantidadComentariosNegativos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ComentariosNegativosFrecuentesDTO> listarComentariosNegativosFrecuentes(){
        List<String[]>lista= cT.listarComentariosNegativosFrecuentes();
        List<ComentariosNegativosFrecuentesDTO> listaDTO = new ArrayList<>();
        for(String[] columna:lista){
            ComentariosNegativosFrecuentesDTO dto=new ComentariosNegativosFrecuentesDTO();
            dto.setContenido(columna[0]);
            dto.setFrecuencia(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}