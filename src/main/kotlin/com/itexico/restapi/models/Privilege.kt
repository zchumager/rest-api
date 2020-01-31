package com.itexico.restapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

/**
CREATE TABLE `privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
 */

@Entity
@Table(schema = "northwind", name = "privileges")
data class Privilege (
    @Column(name = "id") @Id @GeneratedValue
    @JsonProperty("id")
    var id: Int ?= 0,

    @Column(name = "privilege_name")
    @JsonProperty("privilege_name")
    var privilegeName: String ?= ""
)
