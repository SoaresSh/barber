package com.barber.api.util

import com.barber.api.infrastructure.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class CodeGeneratorUtil(
    private val userRepository: UserRepository
) {

    fun gerarProximoCodigo(): String {
        val ultimoCliente = userRepository.findTopByOrderByCodeDesc()
        val ultimoCodigo = ultimoCliente?.code?.removePrefix("CLI-")?.toIntOrNull() ?: 0
        return "CLI-${(ultimoCodigo + 1).toString().padStart(5, '0')}"
    }
}

