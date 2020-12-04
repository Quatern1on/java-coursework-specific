package vt18.turchenko.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "spare_part")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Null is for validation
    private Long id;

    @Column(name = "vendor_code")
    @Size(min = 3, max = 256, message = "Must be from 3 to 256 symbols")
    private String vendorCode;

    @Size(min = 3, max = 256, message = "Must be from 3 to 256 symbols")
    private String name;

    @Positive(message = "Must be positive")
    @Max(value = 999999, message = "Maximum value is 999999")
    @NotNull(message = "Can not be empty")
    private Float price;

    @Column(columnDefinition = "TEXT")
    @Size(max = 65536, message = "Can not be longer than 65536 symbols")
    private String note;
}
