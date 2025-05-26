package com.barber.api.infrastructure.repository

import com.barber.api.domain.entities.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByCpf(cpf: String): User?
    fun findTopByOrderByCodeDesc(): User?
    fun existsByCpfAndTelefoneIsNotNullAndEnderecoIsNotNull(cpf: String): Boolean
}
