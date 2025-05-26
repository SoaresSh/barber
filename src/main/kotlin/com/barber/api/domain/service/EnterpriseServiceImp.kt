package com.barber.api.domain.service

import com.barber.api.domain.dtos.request.EnterpriseRequestDto
import com.barber.api.domain.dtos.response.EnterpriseResponseDto
import com.barber.api.domain.entities.Enterprise
import com.barber.api.infrastructure.repository.EnterpriseRepository
import org.springframework.stereotype.Service

@Service
class EnterpriseServiceImp (
    private val enterpriseRepository: EnterpriseRepository
):EnterpriseServiceInterface {
    override fun save(enterpriseRequestDto: EnterpriseRequestDto): EnterpriseResponseDto {
        val enterprise = enterpriseRepository.save(
            Enterprise(
                id = enterpriseRequestDto.id,
                name = enterpriseRequestDto.name,
                email = enterpriseRequestDto.email,
                password = enterpriseRequestDto.password,
                cnpj = enterpriseRequestDto.cnpj,
                endereco = enterpriseRequestDto.endereco,
            )
        )
        return EnterpriseResponseDto(
            id = enterprise.id,
            name = enterprise.name,
            email = enterprise.email,
            password = enterprise.password,
            cnpj = enterprise.cnpj,
            endereco = enterprise.endereco

        )
    }

    override fun update(id:Long, enterpriseRequestDto: EnterpriseRequestDto): EnterpriseResponseDto {
        val enterprise = enterpriseRepository.findById(id).orElseThrow{
            IllegalArgumentException("Erro");
        }


        enterprise.name = enterpriseRequestDto.name
        enterprise.email = enterpriseRequestDto.email
        enterprise.password = enterpriseRequestDto.password
        enterprise.cnpj = enterpriseRequestDto.cnpj

        val enterpriseUpdate = enterpriseRepository.save(enterprise)
        return EnterpriseResponseDto(
            id = enterpriseUpdate.id,
            name = enterpriseUpdate.name,
            email = enterpriseUpdate.email,
            password = enterpriseUpdate.password,
            cnpj = enterpriseUpdate.cnpj,
            endereco = enterpriseUpdate.endereco
        )
    }


}