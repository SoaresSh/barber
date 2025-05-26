package com.barber.api.domain.dtos.response

data class EnterpriseResponseDto(
    val id: Long?,
    val name: String?,
    val email: String?,
    val password: String,
    val cnpj: String,
    val endereco: String,
)
