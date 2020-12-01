package vt18.turchenko.coursework.model;

import lombok.*;

import javax.persistence.*;

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

    private String name;

    private String address;

    private String phone;

}
