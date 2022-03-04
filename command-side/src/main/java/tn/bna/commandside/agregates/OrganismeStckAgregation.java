package tn.bna.commandside.agregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import tn.bna.commun.commands.CreateOrganismeStockeurCommand;
import tn.bna.commun.events.OrganismeStockeurCreatedEvent;
@Aggregate
@Slf4j
public class OrganismeStckAgregation {
    @AggregateIdentifier
    private String id;
    private String libOrgstkOrgstk;
    private String libSiglOrgstk;

    //AGREGAT : c’est le domaine sur lequel en va appliquer la logique métier
    public OrganismeStckAgregation() {
        //required by axon
    }
    @CommandHandler
    public  OrganismeStckAgregation(CreateOrganismeStockeurCommand command) {
        log.info("CreateOrganismeStockeurCommand received");
        //Au niveau de l’agrégat la méthode de décision annoté par commandHandler reste en écoute pour récupérer la commande, ensuite
        ///implémenter régle métier ,par la suite
        // émettre une liste d’événement dans le bus-évènement et le stocker dans Event_Store
        AggregateLifecycle.apply(new OrganismeStockeurCreatedEvent(command.getId(),command.getLibOrgstkOrgstk(),command.getLibSiglOrgstk()));

    }
    //Muter l’état de l’application dans le même agrégat, une autre méthode dévolution annoté par EventSourcingHandler reste en écoute
    // et récupère l’évènement pour muter l’état de l’application (effet de bord) (L’état de l’application et représenter par l’agrégat)
    @EventSourcingHandler
    public void on(OrganismeStockeurCreatedEvent event){
        log.info("OrganismeStockeurCreatedEvent occured");
        this.id=event.getId();
        this.libOrgstkOrgstk=event.getLibOrgstkOrgstk();
        this.libSiglOrgstk= event.getLibSiglOrgstk();

        //ACTION : une commande interne Si la décision se fait on plusieurs étapes, plusieurs opération métier qui doit être transactionnelle
    }

}
