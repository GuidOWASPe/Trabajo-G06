package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.CantidadEstiloColorFormaDTO;
import pe.edu.upc.demo.dtos.EstiloDTO;
import pe.edu.upc.demo.dtos.ReporteEstilosPorUsuarioDTO;
import pe.edu.upc.demo.entities.Estilo;
import pe.edu.upc.demo.serviceinterfaces.IEstiloService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estilos")
@PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
public class EstiloController {
    @Autowired
    private IEstiloService eS;

    @GetMapping
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public List<EstiloDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, EstiloDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody EstiloDTO dto){
        ModelMapper m=new ModelMapper();
        Estilo e=m.map(dto,Estilo.class);
        eS.insert(e);
    }

    @GetMapping ("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public EstiloDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstiloDTO dto = m.map(eS.listId(id), EstiloDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody EstiloDTO dto){
        ModelMapper m=new ModelMapper();
        Estilo v=m.map(dto,Estilo.class);
        eS.update(v);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        eS.delete(id);
    }


    @GetMapping("/PopularidadFormasYColoresEstilo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CantidadEstiloColorFormaDTO> cantidadEstiloColorForma(){
        List<String[]>lista= eS.cantidadEstiloColorForma();
        List<CantidadEstiloColorFormaDTO> listaDTO = new ArrayList<>();
        for(String[] columna:lista){
            CantidadEstiloColorFormaDTO dto=new CantidadEstiloColorFormaDTO();
            dto.setNombreForma(columna[0]);
            dto.setCodigoColor(columna[1]);
            dto.setCantidadEstilo(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }


    @GetMapping("/CantidadEstilosPorUsuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ReporteEstilosPorUsuarioDTO> cantidadEstilosPorUsuario(){
        List<String[]>lista= eS.cantidadEstilosPorUsuario();
        List<ReporteEstilosPorUsuarioDTO> listaDTO = new ArrayList<>();
        for(String[] columna:lista){
            ReporteEstilosPorUsuarioDTO dto=new ReporteEstilosPorUsuarioDTO();
            dto.setNickname_usuario(columna[0]);
            dto.setCantidad_estilos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }


}

