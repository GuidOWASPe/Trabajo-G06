package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.EstiloItemDTO;
import pe.edu.upc.demo.dtos.EstiloUsuarioConPCDTO;
import pe.edu.upc.demo.dtos.EstiloUsuarioDTO;
import pe.edu.upc.demo.entities.EstiloUsuario;
import pe.edu.upc.demo.serviceinterfaces.IEstiloUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estiloUsuario")
public class EstiloUsuarioController {
    @Autowired
    private IEstiloUsuarioService eS;
    @GetMapping
    public List<EstiloUsuarioDTO> listar(){

        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,EstiloUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EstiloUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloUsuario v=m.map(dto,EstiloUsuario.class);
        eS.insert(v);
    }
    @GetMapping ("/{id}")
    public EstiloUsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstiloUsuarioDTO dto = m.map(eS.listId(id), EstiloUsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody EstiloUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloUsuario v=m.map(dto,EstiloUsuario.class);
        eS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        eS.delete(id);
    }


    @GetMapping("/ListarEstiloDeUsuarioConPeorCalifiacion")
    public List<EstiloUsuarioConPCDTO> estiloUsuarioConPeorCalifiacion(){
        List<String[]> lista=eS.estiloUsuarioConPC();
        List<EstiloUsuarioConPCDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            EstiloUsuarioConPCDTO dto=new EstiloUsuarioConPCDTO();
            dto.setId_estilo_fav(Integer.parseInt(columna[0]));
            dto.setNickname_usuario(columna[1]);
            dto.setNombre_estilo(columna[2]);
            dto.setCalificacion_estilo(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
