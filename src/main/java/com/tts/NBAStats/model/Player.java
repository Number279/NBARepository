package com.tts.NBAStats.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(notes = "The player's first name.")
    private String firstName;

    @ApiModelProperty(notes = "The player's last name.")
    private String lastName;

    @ApiModelProperty(notes = "The player's position.")
    private String position;

    @ApiModelProperty(notes = "The player's jersey number.")
    private int playerNumber;

    @ApiModelProperty(notes = "Total points scored by the player.")
    private int points;

    @ApiModelProperty(notes = "Total rebounds made by the player.")
    private Integer rebounds;

    @ApiModelProperty(notes = "Total assists made by the player.")
    private int assists;

    @ApiModelProperty(notes = "Total steals made by the player.")
    private int steals;

    @ApiModelProperty(notes = "Total blocks made by the player.")
    private int blocks;
}
