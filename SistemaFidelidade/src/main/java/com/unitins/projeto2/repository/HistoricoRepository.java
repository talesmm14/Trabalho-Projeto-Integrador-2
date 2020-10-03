package com.unitins.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitins.projeto2.models.HistoricoTroca;

public interface HistoricoRepository extends JpaRepository<HistoricoTroca, Long> {

}
