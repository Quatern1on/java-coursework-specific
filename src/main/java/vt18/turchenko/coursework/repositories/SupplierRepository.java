package vt18.turchenko.coursework.repositories;

import org.springframework.data.repository.CrudRepository;
import vt18.turchenko.coursework.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}