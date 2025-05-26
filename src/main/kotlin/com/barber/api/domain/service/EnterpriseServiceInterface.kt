package com.barber.api.domain.service

import com.barber.api.domain.dtos.request.EnterpriseRequestDto
import com.barber.api.domain.dtos.response.EnterpriseResponseDto

interface EnterpriseServiceInterface {
    fun save(enterpriseRequestDto: EnterpriseRequestDto): EnterpriseResponseDto
    //fun delete(id:Long, enterpriseRequestDto: EnterpriseRequestDto): EnterpriseResponseDto
    fun update(id:Long, enterpriseRequestDto: EnterpriseRequestDto): EnterpriseResponseDto
}