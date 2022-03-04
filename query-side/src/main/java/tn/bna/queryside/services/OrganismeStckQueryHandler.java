package tn.bna.queryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import tn.bna.commun.queries.GetAllOrgStckQuery;
import tn.bna.commun.queries.GetOrgByIdQuery;
import tn.bna.queryside.entities.OrganismeStockeur;
import tn.bna.queryside.repositories.OrganismeStockeurRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OrganismeStckQueryHandler {
    public OrganismeStockeurRepository organismeStockeurRepository;
    @QueryHandler
    public List<OrganismeStockeur> findAll(GetAllOrgStckQuery query)
    {
        return organismeStockeurRepository.findAll();
    }
    @QueryHandler
    public  OrganismeStockeur getOrgById(GetOrgByIdQuery query)
    {
        return  organismeStockeurRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("organisme stockeur not found"));
    }
}
