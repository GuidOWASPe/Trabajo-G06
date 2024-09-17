package pe.edu.upc.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demo.dtos.*;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar(){

        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uS.insert(u);
    }

    @GetMapping ("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listId(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.update(u);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("/CantidadUsuarioXGenero")
    public List<CantidadUsuarioSegunEdadGeneroDTO> usuarioSegunEdadGenero(){
        List<String[]>lista= uS.cantidadUsuarioEdadGenero();
        List<CantidadUsuarioSegunEdadGeneroDTO> listaDTO = new ArrayList<>();
        for(String[] columna:lista){
            CantidadUsuarioSegunEdadGeneroDTO dto=new CantidadUsuarioSegunEdadGeneroDTO();
            dto.setRangoEdad(columna[0]);
            dto.setGenero(columna[1]);
            dto.setCantidadUsuario(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/PorcenUsuariosXGenero")
    public List<PorcentUsuariosporGeneroDTO> usuariosporgenero(){
        List<String []>lista=uS.usuariosporgeneroservice();
        List<PorcentUsuariosporGeneroDTO>listDTO=new ArrayList<>();
        for (String[] columna:lista) {
            PorcentUsuariosporGeneroDTO dto=new PorcentUsuariosporGeneroDTO();
            dto.setGenero(columna[0]);
            dto.setCantidadusuarios(Integer.parseInt(columna[1]));
            dto.setPorcentaje(Double.parseDouble(columna[2]));
            listDTO.add(dto);
        }
        return listDTO;
    }
    @GetMapping("/PorcenUsuariosregistrados")
    public List<PorcentUsuariosMesDTO> usuariosregistrados(){
        List<String []>lista=uS.mesderegistrosusuarios();
        List<PorcentUsuariosMesDTO>listDTO=new ArrayList<>();
        for (String[] columna:lista) {
            PorcentUsuariosMesDTO dto=new PorcentUsuariosMesDTO();
            dto.setMesregistro(LocalDate.parse(columna[0]+ "-01"));
            dto.setUsuariosregistrados(Integer.parseInt(columna[1]));
            dto.setPorcentaje(Double.parseDouble(columna[2]));
            listDTO.add(dto);
        }
        return listDTO;
    }
    @GetMapping("/PaisesPorUsuario")
    public List<ReportePaisesPorUsuarioDTO> PaisesPorUsuario(){
        List<String[]> lista= uS.PaisesPorUsuario();
        List<ReportePaisesPorUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna:lista) {
            ReportePaisesPorUsuarioDTO dto=new ReportePaisesPorUsuarioDTO();
            dto.setNickname_usuario(columna[0]);
            dto.setCantidad_estilos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
