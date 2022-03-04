package tn.bna.queryside.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.bna.queryside.entities.OrganismeStockeur;

import java.util.List;


public interface OrganismeStockeurRepository extends JpaRepository<OrganismeStockeur, String> {

    //List<OrganismeStockeur> findByNumSeqPers(Long numSeqPers);
    //List<OrganismeStockeur> findByLibOrgstkOrgstkLike(String name);
}
