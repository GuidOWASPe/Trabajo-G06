package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Forma;
import pe.edu.upc.demo.entities.Item;
import pe.edu.upc.demo.repositories.IItemRepository;
import pe.edu.upc.demo.serviceinterfaces.IItemService;

import java.util.List;

@Service
public class ItemServiceImplement implements IItemService {
    @Autowired
    private IItemRepository iR;

    @Override
    public List<Item> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Item i) {
        iR.save(i);
    }

    @Override
    public Item listId(int id) {
        return iR.findById(id).orElse(new Item());
    }

    @Override
    public void update(Item i) {
        iR.save(i);
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public List<String[]> maxNroUsos() {return iR.maxNroUsos();}

}

