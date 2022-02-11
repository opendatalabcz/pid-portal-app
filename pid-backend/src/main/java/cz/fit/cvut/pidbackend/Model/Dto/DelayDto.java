package cz.fit.cvut.pidbackend.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelayDto {
    private String date;
    private int delayMin;
}
