package com.keduit.amigo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "production_company")
public class ProductionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

/*    @OneToMany(mappedBy = "companyId", fetch = FetchType.LAZY)
    private List<AdditionalInfo> additionalInfo;*/
}
