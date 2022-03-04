package tn.bna.commun.events

abstract class BaseEvent<T>(
        open val id:T
)
data class OrganismeStockeurCreatedEvent(
        override val id:String,
        val libOrgstkOrgstk:String,
        val libSiglOrgstk :String
):BaseEvent<String>(id)

data class OrganismeStockeurUpdatedEvent(
        override val id:String,
        val libOrgstkOrgstk:String,
        val libSiglOrgstk :String
):BaseEvent<String>(id)