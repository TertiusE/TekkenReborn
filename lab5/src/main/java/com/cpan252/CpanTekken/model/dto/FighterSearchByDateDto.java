package com.cpan252.CpanTekken.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FighterSearchByDateDto {
    private String name;
    private String startDate;
    private String endDate;
}