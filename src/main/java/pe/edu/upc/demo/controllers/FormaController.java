package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.FormaDTO;
import pe.edu.upc.demo.entities.Forma;
import pe.edu.upc.demo.serviceinterfaces.IFormaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formas")
public class FormaController {

    @Autowired
    private IFormaService fS;

    @GetMapping
    public List<FormaDTO> listar(){

        return fS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,FormaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody FormaDTO dto){
        ModelMapper m=new ModelMapper();
        Forma v=m.map(dto,Forma.class);
        fS.insert(v);
    }
    @GetMapping ("/{id}")
    public FormaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        FormaDTO dto = m.map(fS.listId(id), FormaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody FormaDTO dto){
        ModelMapper m=new ModelMapper();
        Forma v=m.map(dto,Forma.class);
        fS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        fS.delete(id);
    }
}