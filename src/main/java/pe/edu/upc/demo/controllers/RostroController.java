package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.CantidadRostroFormaDTO;
import pe.edu.upc.demo.dtos.RostroDTO;
import pe.edu.upc.demo.entities.Rostro;
import pe.edu.upc.demo.serviceinterfaces.IRostroService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rostros")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
public class RostroController {

    @Autowired
    private IRostroService rS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    public List<RostroDTO> listar(){

        return rS.list().stream().map(v-> {
            ModelMapper m = new ModelMapper();
            return m.map(v, RostroDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    public void insertar(@RequestBody RostroDTO dto){
        ModelMapper m = new ModelMapper();
        Rostro v = m.map(dto, Rostro.class);
        rS.insert(v);
    }

    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    public RostroDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RostroDTO dto = m.map(rS.listId(id), RostroDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    public void modificar(@RequestBody RostroDTO dto){
        ModelMapper m=new ModelMapper();
        Rostro v=m.map(dto,Rostro.class);
        rS.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USUARIO')")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }

    @GetMapping("/CantidadRostroSegunForma")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CantidadRostroFormaDTO> cantidadRostrosForma(){
        List<String[]>lista= rS.cantidadRostrosForma();
        List<CantidadRostroFormaDTO> listaDTO = new ArrayList<>();
        for(String[] columna:lista){
            CantidadRostroFormaDTO dto=new CantidadRostroFormaDTO();
            dto.setNombreForma(columna[0]);
            dto.setCantidadRostro(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
