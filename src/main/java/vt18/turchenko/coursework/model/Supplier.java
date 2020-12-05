package vt18.turchenko.coursework.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "supplier")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 256, message = "Must be from 3 to 256 symbols")
    private String name;

    @Size(min = 3, max = 256, message = "Must be from 3 to 256 symbols")
    private String address;

    @Pattern(regexp = "^([+]?[\\s0-9]+)?(\\d{3}|[(]?[0-9]+[)])?([-]?[\\s]?[0-9])+$",
            message = "Must be a valid phone number")
    private String phone;

}
