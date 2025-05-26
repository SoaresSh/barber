package com.barber.api.controller

import com.barber.api.domain.dtos.request.EnterpriseRequestDto
import com.barber.api.domain.dtos.response.EnterpriseResponseDto
import com.barber.api.domain.service.EnterpriseServiceInterface
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/enterprise")
@CrossOrigin("http://127.0.0.1:5500")
class EnterpriseController (
    val enterpriseService: EnterpriseServiceInterface
) {
    @PostMapping("/save")
    fun enterprise(@RequestBody enterpriseRequestDto: EnterpriseRequestDto): EnterpriseResponseDto {

        return enterpriseService.save(enterpriseRequestDto);
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody enterpriseRequestDto: EnterpriseRequestDto
    ): EnterpriseResponseDto {
        return enterpriseService.update(id, enterpriseRequestDto)

    }
}