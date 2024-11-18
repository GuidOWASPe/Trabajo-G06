package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.CantidadRostroFormaDTO;
import pe.edu.upc.demo.dtos.ComentarioDTO;
import pe.edu.upc.demo.dtos.ComentariosNegativosFrecuentesDTO;
import pe.edu.upc.demo.entities.Comentario;
import pe.edu.upc.demo.serviceinterfaces.IComentarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coment")

public class ComentarioController {

    //dsfsdfsdfsd
    @Autowired
    private IComentarioService cT;

    @GetMapping
    public List<ComentarioDTO> listar() {
        return cT.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ComentarioDTO dto){
        ModelMapper m=new ModelMapper();
        Comentario u=m.map(dto, Comentario.class);
        cT.insert(u);
    }

    @GetMapping ("/{id}")
    public ComentarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ComentarioDTO dto = m.map(cT.listId(id), ComentarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody ComentarioDTO dto){
        ModelMapper m=new ModelMapper();
        Comentario u=m.map(dto,Comentario.class);
        cT.update(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cT.delete(id);
    }

    @GetMapping("/comentariosnegativos")
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