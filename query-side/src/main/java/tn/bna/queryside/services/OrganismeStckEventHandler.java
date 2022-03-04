package tn.bna.queryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import tn.bna.commun.events.OrganismeStockeurCreatedEvent;
import tn.bna.queryside.entities.OrganismeStockeur;
import tn.bna.queryside.repositories.OrganismeStockeurRepository;

@Service
@AllArgsConstructor
@Slf4j
public class OrganismeStckEventHandler {
    private OrganismeStockeurRepository organismeStockeurRepository;
    @EventHandler
    public void on(OrganismeStockeurCreatedEvent event)
    {
        OrganismeStockeur organismeStockeur=new OrganismeStockeur();
        organismeStockeur.setCodOrgstkOrgstk(event.getId());
        organismeStockeur.setLibOrgstkOrgstk(event.getLibOrgstkOrgstk());
        organismeStockeur.setLibSiglOrgstk(event.getLibSiglOrgstk());
        organismeStockeurRepository.save(organismeStockeur);

    }
}
