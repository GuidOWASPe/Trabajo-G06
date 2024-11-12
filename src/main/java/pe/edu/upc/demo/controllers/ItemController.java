package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.ItemDTO;
import pe.edu.upc.demo.dtos.MaxNroUsosItemDTO;
import pe.edu.upc.demo.entities.Item;
import pe.edu.upc.demo.serviceinterfaces.IItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@PreAuthorize("hasAuthority('ADMIN')")
public class ItemController {
    @Autowired
    private IItemService iR;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ItemDTO> listar() {

        return iR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ItemDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody ItemDTO dto) {
        ModelMapper m = new ModelMapper();
        Item v = m.map(dto, Item.class);
        iR.insert(v);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ItemDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ItemDTO dto = m.map(iR.listId(id), ItemDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ItemDTO dto) {
        ModelMapper m = new ModelMapper();
        Item v = m.map(dto, Item.class);
        iR.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id) {
        iR.delete(id);
    }


    @GetMapping("/ItemMasUsadoPorUsuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MaxNroUsosItemDTO> ItemMasUsado() {
        List<String[]> lista = iR.ItemMasUsado();
        List<MaxNroUsosItemDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            MaxNroUsosItemDTO dto = new MaxNroUsosItemDTO();
            dto.setNombreItem(columna[0]);
            dto.setNroUsosItem(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
