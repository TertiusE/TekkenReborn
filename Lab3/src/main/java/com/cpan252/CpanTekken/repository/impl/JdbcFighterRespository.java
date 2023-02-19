package com.cpan252.CpanTekken.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cpan252.CpanTekken.model.Fighter;
import com.cpan252.CpanTekken.repository.FighterRepository;

@Repository
public class JdbcFighterRespository implements FighterRepository{
    private JdbcTemplate jdbcTemplate;

    public JdbcFighterRespository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Fighter> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Fighter> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Fighter save(Fighter fighter) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
