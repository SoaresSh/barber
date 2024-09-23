package com.barber.api.infrastructure.repository

import com.barber.api.domain.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>

