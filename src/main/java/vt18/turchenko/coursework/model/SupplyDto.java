package vt18.turchenko.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyDto {

    @NotNull(message = "You must specify supplier")
    @Min(message = "You must specify supplier", value = 0)
    private Long supplier;

    @NotNull(message = "You must specify spare part")
    @Min(message = "You must specify spare part", value = 0)
    private Long sparePart;

    @Past(message = "You cannot buy something in the future")
    @NotNull(message = "You must select valid date")
    private Date date;

    @Max(value = 999999, message = "Maximum value is 999999")
    @Min(value = 1, message = "You cannot by less then 1 part")
    @NotNull(message = "Can not be empty")
    private Integer quantity;
}
