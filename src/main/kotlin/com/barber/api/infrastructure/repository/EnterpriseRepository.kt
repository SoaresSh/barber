package com.barber.api.infrastructure.repository

import com.barber.api.domain.entities.Enterprise
import org.springframework.data.repository.CrudRepository

interface EnterpriseRepository : CrudRepository<Enterprise, Long>

