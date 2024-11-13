package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.TipoDTO;

import pe.edu.upc.demo.entities.Tipo;

import pe.edu.upc.demo.serviceinterfaces.ITipoService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CLIENTE')")
public class TipoController {
    @Autowired
    private ITipoService tS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CLIENTE')")
    public List<TipoDTO> listar(){

        return tS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TipoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody TipoDTO dto){
        ModelMapper m=new ModelMapper();
        Tipo v=m.map(dto,Tipo.class);
        tS.insert(v);
    }
    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CLIENTE')")
    public TipoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        TipoDTO dto = m.map(tS.listId(id), TipoDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody TipoDTO dto){
        ModelMapper m=new ModelMapper();
        Tipo v=m.map(dto,Tipo.class);
        tS.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }


}
