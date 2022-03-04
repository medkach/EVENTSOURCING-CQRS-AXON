package tn.bna.commun.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id:T
)
data class CreateOrganismeStockeurCommand(
        override val id:String,
        val libOrgstkOrgstk:String,
        val libSiglOrgstk :String
):BaseCommand<String>(id)

data class UpdateOrganismeStockeurCommand(
        override val id:String,
        val libOrgstkOrgstk:String,
        val libSiglOrgstk :String
):BaseCommand<String>(id)