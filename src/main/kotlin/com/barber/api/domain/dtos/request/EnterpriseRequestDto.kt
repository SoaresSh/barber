package com.barber.api.domain.dtos.request

data class EnterpriseRequestDto (
    val id: Long?,
    val name: String?,
    val email: String?,
    val password: String,
    val cnpj: String,
    val endereco: String
    )