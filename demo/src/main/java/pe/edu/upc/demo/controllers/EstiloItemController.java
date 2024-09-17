package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.EstiloItemDTO;
import pe.edu.upc.demo.entities.EstiloItem;
import pe.edu.upc.demo.serviceinterfaces.IEstiloItemService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estilosItems")
public class EstiloItemController {
    @Autowired
    private IEstiloItemService eS;

    @GetMapping
    public List<EstiloItemDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, EstiloItemDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EstiloItemDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloItem e=m.map(dto,EstiloItem.class);
        eS.insert(e);
    }
    @GetMapping ("/{id}")
    public EstiloItemDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstiloItemDTO dto = m.map(eS.listId(id), EstiloItemDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody EstiloItemDTO dto){
        ModelMapper m=new ModelMapper();
        EstiloItem v=m.map(dto,EstiloItem.class);
        eS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        eS.delete(id);
    }

}
