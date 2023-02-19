package com.cpan252.CpanTekken.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fighter {
    @NotBlank
    private String name;
    @NotBlank
    @Max(100)
    private int damagePerHit;
    @NotBlank
    @Min(1000)
    private double health;
    @NotBlank
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal resistance;
    @NotBlank
    private Anime animeFrom;

    public enum Anime {
        NARUTO("Naruto"), BLEACH("Bleach"), ONE_PIECE("One Piece"), TEKKEN("Tekken");
        
        private String title;
        private Anime(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}