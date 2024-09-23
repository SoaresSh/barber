package com.barber.api.domain.entities

import jakarta.persistence.*

@Table(name = "enterprises")
@Entity
data class Enterprise(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id:Long? = null,

    @Column(name = "Name")
    var Name:String? = null,

    @Column(name = "Email")
    var email:String? = null,

    @Column(name = "password")
    var password: String,

    @Column(name = "Cnpj")
    var Cnpj: String,

    )