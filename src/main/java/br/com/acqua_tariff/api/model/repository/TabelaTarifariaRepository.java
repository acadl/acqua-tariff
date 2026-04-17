package br.com.acqua_tariff.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acqua_tariff.api.model.domain.TabelaTarifaria;

@Repository
public interface TabelaTarifariaRepository extends JpaRepository<TabelaTarifaria, Integer>  {
	
	    List<TabelaTarifaria> findByAtivoTrue();
	
}
