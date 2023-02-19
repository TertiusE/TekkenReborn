package com.cpan252.CpanTekken.repository;
import com.cpan252.CpanTekken.model.Fighter;
import java.util.Optional;

public interface FighterRepository {
    Iterable<Fighter> findAll();
    Optional<Fighter> findById(Long id);
    Fighter save(Fighter fighter);
}