package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.ItemUsuarioDTO;
import pe.edu.upc.demo.dtos.ItemsMasUsadosDTO;
import pe.edu.upc.demo.entities.ItemUsuario;
import pe.edu.upc.demo.serviceinterfaces.IItemUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itemUsuario")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
public class ItemUsuarioController {

    @Autowired
    private IItemUsuarioService iS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ItemUsuarioDTO> listar(){

        return iS.list().stream().map(v-> {
            ModelMapper m = new ModelMapper();
            return m.map(v, ItemUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    public void insertar(@RequestBody ItemUsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        ItemUsuario v = m.map(dto, ItemUsuario.class);
        iS.insert(v);
    }

    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ItemUsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ItemUsuarioDTO dto = m.map(iS.listId(id), ItemUsuarioDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ItemUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        ItemUsuario v=m.map(dto,ItemUsuario.class);
        iS.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        iS.delete(id);
    }

    @GetMapping("/ListarItemsPorNroUsos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ItemsMasUsadosDTO> ItemsPorNroUso() {
        List<String[]> lista = iS.ItemsPorNroUso();
        List<ItemsMasUsadosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ItemsMasUsadosDTO dto = new ItemsMasUsadosDTO();
            dto.setNombreItem(columna[0]);
            dto.setNrUsos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}