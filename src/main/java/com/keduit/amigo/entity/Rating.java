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
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @Column(name = "rating_name")
    private String ratingName;

/*    @OneToMany(mappedBy = "ratingId", fetch = FetchType.LAZY)
    private List<AdditionalInfo> additionalInfos;*/
}
