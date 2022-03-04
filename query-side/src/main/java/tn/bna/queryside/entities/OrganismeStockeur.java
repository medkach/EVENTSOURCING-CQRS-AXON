package tn.bna.queryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
    public class OrganismeStockeur {
        @Id
        //@Column(name = "COD_ORGSTK_ORGSTK")
        private String codOrgstkOrgstk;
       // @Column(name = "LIB_ORGSTK_ORGSTK")
        private String libOrgstkOrgstk;
       // @Column(name = "LIB_SIGL_ORGSTK")
        private String libSiglOrgstk;
}
