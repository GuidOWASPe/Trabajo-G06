package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.EstiloDTO;
import pe.edu.upc.demo.dtos.ReporteItemsPorUsuarioDTO;
import pe.edu.upc.demo.entities.Estilo;
import pe.edu.upc.demo.serviceinterfaces.IEstiloService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estilos")
public class EstiloController {
    @Autowired
    private IEstiloService eS;

    @GetMapping
    public List<EstiloDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, pe.edu.upc.demo.dtos.EstiloDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EstiloDTO dto){
        ModelMapper m=new ModelMapper();
        Estilo e=m.map(dto,Estilo.class);
        eS.insert(e);
    }
    @GetMapping ("/{id}")
    public EstiloDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstiloDTO dto = m.map(eS.listId(id), EstiloDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody EstiloDTO dto){
        ModelMapper m=new ModelMapper();
        Estilo v=m.map(dto,Estilo.class);
        eS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        eS.delete(id);
    }
    @GetMapping("/estilos_por_usuarios")
    public List<ReporteItemsPorUsuarioDTO> EstilosPorUsuarios(){
        List<String[]> lista=eS.EstilosPorUsuarios();
        List<ReporteItemsPorUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna:lista) {
            ReporteItemsPorUsuarioDTO dto=new ReporteItemsPorUsuarioDTO();
            dto.setPaisUsuario(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}

