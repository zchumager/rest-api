package com.itexico.restapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.persistence.*

/**
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  `business_phone` varchar(25) DEFAULT NULL,
  `home_phone` varchar(25) DEFAULT NULL,
  `mobile_phone` varchar(25) DEFAULT NULL,
  `fax_number` varchar(25) DEFAULT NULL,
  `address` longtext,
  `city` varchar(50) DEFAULT NULL,
  `state_province` varchar(50) DEFAULT NULL,
  `zip_postal_code` varchar(15) DEFAULT NULL,
  `country_region` varchar(50) DEFAULT NULL,
  `web_page` longtext,
  `notes` longtext,
  `attachments` longblob,
  PRIMARY KEY (`id`),
  KEY `city` (`city`),
  KEY `company` (`company`),
  KEY `first_name` (`first_name`),
  KEY `last_name` (`last_name`),
  KEY `zip_postal_code` (`zip_postal_code`),
  KEY `state_province` (`state_province`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8
 */

@Entity
@Table(schema = "northwind", name = "employees")
data class Employee (

    @Id @Column(name = "id")
    @JsonProperty("id")
    var id: Int ?= 0,

    @Column(name = "company")
    @JsonProperty("company")
    var company: String ?= "",

    @Column(name = "last_name")
    @JsonProperty("last_name")
    var lastName: String ?= "",

    @Column(name = "first_name")
    @JsonProperty("first_name")
    var firstName: String ?= "",

    @Column(name = "email_address")
    @JsonProperty("email_address")
    var emailAddress: String ?= "",

    @Column(name = "job_title")
    @JsonProperty("job_title")
    var jobTitle: String ?= "",

    @Column(name = "business_phone")
    @JsonProperty("business_phone")
    var businessPhone: String ?= "",

    @Column(name = "home_phone")
    @JsonProperty("home_phone")
    var homePhone: String ?= "",

    @Column(name = "mobile_phone")
    @JsonProperty("mobile_phone")
    var mobilePhone: String ?= "",

    @Column(name = "fax_number")
    @JsonProperty("fax_number")
    var faxNumber: String ?= "",

    @Column(name = "address")
    @JsonProperty("address")
    var address: String ?= "",

    @Column(name = "city")
    @JsonProperty("city")
    var city: String ?= "",

    @Column(name = "state_province")
    @JsonProperty("state_province")
    var stateProvince: String ?= "",

    @Column(name = "zip_postal_code")
    @JsonProperty("zip_postal_code")
    var zipPostalCode: String ?= "",

    @Column(name = "country_region")
    @JsonProperty("country_region")
    var countryRegion: String ?= "",

    @Column(name = "web_page")
    @JsonProperty("web_page")
    var webPage: String ?= "",

    @Column(name = "notes")
    @JsonProperty("notes")
    var notes: String ?= "",

    @Column(name = "attachments")
    @JsonProperty("attachments")
    var attachments: String ?= ""
)
