package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.ItemUsuarioDTO;
import pe.edu.upc.demo.entities.ItemUsuario;
import pe.edu.upc.demo.serviceinterfaces.IItemUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itemUsuario")
public class ItemUsuarioController {

    @Autowired
    private IItemUsuarioService iS;

    @GetMapping
    public List<ItemUsuarioDTO> listar(){

        return iS.list().stream().map(v-> {
            ModelMapper m = new ModelMapper();
            return m.map(v, ItemUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ItemUsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        ItemUsuario v = m.map(dto, ItemUsuario.class);
        iS.insert(v);
    }

    @GetMapping ("/{id}")
    public ItemUsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ItemUsuarioDTO dto = m.map(iS.listId(id), ItemUsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody ItemUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        ItemUsuario v=m.map(dto,ItemUsuario.class);
        iS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        iS.delete(id);
    }
}