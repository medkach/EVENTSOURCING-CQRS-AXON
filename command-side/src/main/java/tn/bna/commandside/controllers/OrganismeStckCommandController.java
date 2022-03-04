package tn.bna.commandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;
import tn.bna.commun.commands.CreateOrganismeStockeurCommand;
import tn.bna.commun.dtos.OrganismeStockeurRequestDTO;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/organisme")
public class OrganismeStckCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;
    @PostMapping("/create")
    public CompletableFuture<String> newOrganismeStck(@RequestBody OrganismeStockeurRequestDTO organismeStockeurRequestDTO)
    {
        CompletableFuture<String> response=commandGateway.send(new CreateOrganismeStockeurCommand(organismeStockeurRequestDTO.getId(),organismeStockeurRequestDTO.getLibOrgstkOrgstk(),organismeStockeurRequestDTO.getLibSiglOrgstk()));
        return response;
    }
    @GetMapping("/eventStore/{id}")
public Stream eventStore(@PathVariable(name = "id")String id)
    {
        return eventStore.readEvents(id).asStream();
    }
}
