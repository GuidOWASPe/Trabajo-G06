package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.TipoDTO;

import pe.edu.upc.demo.entities.Tipo;

import pe.edu.upc.demo.serviceinterfaces.ITipoService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos")
public class TipoController {
    @Autowired
    private ITipoService tS;

    @GetMapping
    public List<TipoDTO> listar(){

        return tS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TipoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody TipoDTO dto){
        ModelMapper m=new ModelMapper();
        Tipo v=m.map(dto,Tipo.class);
        tS.insert(v);
    }
    @GetMapping ("/{id}")
    public TipoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        TipoDTO dto = m.map(tS.listId(id), TipoDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody TipoDTO dto){
        ModelMapper m=new ModelMapper();
        Tipo v=m.map(dto,Tipo.class);
        tS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }


}
