package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.EstiloUsuarioDTO;
import pe.edu.upc.demo.entities.EstiloUsuario;
import pe.edu.upc.demo.serviceinterfaces.IEstiloUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estiloUsuario")
public class EstiloUsuarioController {
    @Autowired
    private IEstiloUsuarioService eS;
    @GetMapping
    public List<EstiloUsuarioDTO> listar(){

        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,EstiloUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EstiloUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloUsuario v=m.map(dto,EstiloUsuario.class);
        eS.insert(v);
    }
    @GetMapping ("/{id}")
    public EstiloUsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstiloUsuarioDTO dto = m.map(eS.listId(id), EstiloUsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody EstiloUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloUsuario v=m.map(dto,EstiloUsuario.class);
        eS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        eS.delete(id);
    }
}
