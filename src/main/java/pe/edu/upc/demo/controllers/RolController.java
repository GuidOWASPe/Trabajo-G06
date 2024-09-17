package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.RolDTO;
import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService Rl;

    @GetMapping
    public List<RolDTO> listar(){

        return Rl.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RolDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Rol v=m.map(dto,Rol.class);
        Rl.insert(v);
    }
    @GetMapping ("/{id}")
    public RolDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(Rl.listId(id), RolDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Rol v=m.map(dto,Rol.class);
        Rl.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        Rl.delete(id);
    }
}
