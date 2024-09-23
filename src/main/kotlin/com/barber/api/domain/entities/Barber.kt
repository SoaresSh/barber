package com.barber.api.domain.entities

import jakarta.persistence.*

@Table(name = "barbers")
@Entity
data class Barber(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id:Long? = null,

    @Column(name = "FirstName")
    var firstName:String? = null,

    @Column(name = "LastName")
    var lastName:String? = null,

    //@Column(name = "birthDate")
    //var birthDate:String? = null,

    @Column(name = "Email")
    var email:String? = null,

    @Column(name = "password")
    var password: String,

    @Column(name = "cpf")
    var cpf: String,

    )