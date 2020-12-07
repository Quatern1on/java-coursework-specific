package vt18.turchenko.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "supply")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne()
    @JoinColumn(name = "spare_part_id")
    private SparePart sparePart;

    @Column(name = "supply_date")
    private Date date;

    private Float price;

    private Integer quantity;

}
