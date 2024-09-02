package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.ItemDTO;
import pe.edu.upc.demo.entities.Item;
import pe.edu.upc.demo.serviceinterfaces.IItemService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private IItemService iR;
    @GetMapping
    public List<ItemDTO> listar(){

        return iR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ItemDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ItemDTO dto){
        ModelMapper m=new ModelMapper();
        Item v=m.map(dto, Item.class);
        iR.insert(v);
    }
    @GetMapping ("/{id}")
    public ItemDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ItemDTO dto = m.map(iR.listId(id), ItemDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody ItemDTO dto){
        ModelMapper m=new ModelMapper();
        Item v=m.map(dto,Item.class);
        iR.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        iR.delete(id);
    }
}
