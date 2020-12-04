package vt18.turchenko.coursework.services;

import javassist.bytecode.Descriptor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vt18.turchenko.coursework.model.SparePart;
import vt18.turchenko.coursework.repositories.SparePartRepository;

import java.util.List;

@Service
public class SparePartService {

    @Autowired
    private SparePartRepository repository;


    public List<SparePart> listAll() {
        return IterableUtils.toList(repository.findAll());
    }

    public void save(SparePart part) {
        //Round to 2 decimal places before save
        part.setPrice(Math.round(part.getPrice() * 100.0f) / 100.0f);
        repository.save(part);
    }

    public SparePart find(Long id) {
        return repository.findOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
