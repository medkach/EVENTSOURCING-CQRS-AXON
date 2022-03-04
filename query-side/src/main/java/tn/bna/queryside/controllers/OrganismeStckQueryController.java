package tn.bna.queryside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bna.commun.queries.GetAllOrgStckQuery;
import tn.bna.commun.queries.GetOrgByIdQuery;
import tn.bna.queryside.entities.OrganismeStockeur;
import tn.bna.queryside.repositories.OrganismeStockeurRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/query")
public class OrganismeStckQueryController {
    //private OrganismeStockeurRepository organismeStockeurRepository;
    private QueryGateway queryGateway;
    @GetMapping("/all")
    public CompletableFuture<List<OrganismeStockeur>> all(){
return  queryGateway.query(new GetAllOrgStckQuery(), ResponseTypes.multipleInstancesOf(OrganismeStockeur.class));
    }
    @GetMapping("/byId/{id}")
    public CompletableFuture<OrganismeStockeur> getOtgById(@PathVariable  String id)
    { // Emmetre une requete dans Query Bus pour retourner une réponse De type "OrganismeStockeur"
        //IL faut Systématiquement Créer un query handler dans la quelle on va faire les traitements nécessaire pour récupére la réponse
        return queryGateway.query(new GetOrgByIdQuery(id),ResponseTypes.instanceOf(OrganismeStockeur.class));
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> exceptionHandle(Exception e)
    {
       ResponseEntity<String> responseE=new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseE;
    }
}
