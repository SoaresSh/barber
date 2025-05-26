package com.barber.api.domain.entities

import jakarta.persistence.*

@Table(name = "enterprise")
@Entity
data class Enterprise(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id: Long?,

    @Column(name = "name")
    var name:String?,

    @Column(name = "email")
    var email:String?,

    @Column(name = "password")
    var password: String,

    @Column(name = "cnpj")
    var cnpj: String,

    @Column(name = "endereco")
    var endereco: String,

    )