package vt18.turchenko.coursework.services;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vt18.turchenko.coursework.model.SparePart;
import vt18.turchenko.coursework.model.Supplier;
import vt18.turchenko.coursework.model.Supply;
import vt18.turchenko.coursework.model.SupplyDto;
import vt18.turchenko.coursework.repositories.SparePartRepository;
import vt18.turchenko.coursework.repositories.SupplierRepository;
import vt18.turchenko.coursework.repositories.SupplyRepository;

import java.util.List;

@Service
public class SupplyService {

    @Autowired
    private SupplyRepository repository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SparePartRepository sparePartRepository;


    public List<Supply> listAll() {
        return IterableUtils.toList(repository.findAll());
    }

    public void save(Supply supply) {
        repository.save(supply);
    }

    public void save(SupplyDto supplyDto) {
        repository.save(dto2Entity(supplyDto));
    }

    public void save(SupplyDto supplyDto, Long id) {
        Supply supply = dto2Entity(supplyDto);
        supply.setId(id);
        repository.save(supply);
    }

    public Supply find(Long id) {
        return repository.findOne(id);
    }

    public SupplyDto findDto(Long id) {
        return entity2Dto(repository.findOne(id));
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    private Supply dto2Entity(SupplyDto dto) {
        SparePart part = sparePartRepository.findOne(dto.getSparePart());
        return Supply.builder()
                .date(dto.getDate())
                .quantity(dto.getQuantity())
                .price(part.getPrice())
                .sparePart(part)
                .supplier(supplierRepository.findOne(dto.getSupplier()))
                .build();
    }

    private SupplyDto entity2Dto(Supply entity) {
        return SupplyDto.builder()
                .date(entity.getDate())
                .quantity(entity.getQuantity())
                .sparePart(entity.getSparePart().getId())
                .supplier(entity.getSupplier().getId())
                .build();
    }
}
