package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.ColorDTO;
import pe.edu.upc.demo.entities.Color;
import pe.edu.upc.demo.serviceinterfaces.IColorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colores")
public class ColorController {
    @Autowired
    private IColorService cS;

    @GetMapping
    @PreAuthorize("hasAuthority('USUARIO')")
    public List<ColorDTO> listar(){

        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ColorDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ColorDTO dto){
        ModelMapper m=new ModelMapper();
        Color v=m.map(dto,Color.class);
        cS.insert(v);
    }
    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ColorDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ColorDTO dto = m.map(cS.listId(id), ColorDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ColorDTO dto){
        ModelMapper m=new ModelMapper();
        Color v=m.map(dto,Color.class);
        cS.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
    
}
