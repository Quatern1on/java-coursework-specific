package vt18.turchenko.coursework.services;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vt18.turchenko.coursework.model.SparePart;
import vt18.turchenko.coursework.model.Supplier;
import vt18.turchenko.coursework.repositories.SparePartRepository;
import vt18.turchenko.coursework.repositories.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;


    public List<Supplier> listAll() {
        return IterableUtils.toList(repository.findAll());
    }

    public void save(Supplier supplier) {
        repository.save(supplier);
    }

    public Supplier find(Long id) {
        return repository.findOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
