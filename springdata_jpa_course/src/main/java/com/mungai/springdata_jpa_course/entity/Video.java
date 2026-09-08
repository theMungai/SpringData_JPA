package com.mungai.springdata_jpa_course.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
//@PrimaryKeyJoinColumn(name = "video_id") // Used to customize the foreign key column name || Only works with JOINED_TABLE strategy
//@DiscriminatorValue("V") -> Only used in SINGLE_TABLE
//@Polymorphism(type = PolymorphismType.EXPLICIT)  Excludes this entity from implicit polymorphic queries against its parent entity.
public class Video extends Resource{
    private int length;
}
