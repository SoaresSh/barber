package com.barber.api.controller

import com.barber.api.domain.dtos.request.UserRequestDto
import com.barber.api.domain.dtos.response.UserResponseDto
import com.barber.api.domain.service.UserServiceInterface
import org.springframework.web.bind.annotation.*

//Tem como eu usar 1 controller para mais de 1 entidade

@RestController
@RequestMapping("/user")
@CrossOrigin("http://127.0.0.1:5500")
class UserController (
    val userService: UserServiceInterface
){
    @PostMapping("/save")
    fun user(@RequestBody userRequestDto: UserRequestDto): UserResponseDto {

        return userService.save(userRequestDto);

    }
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody userRequestDto: UserRequestDto
    ): UserResponseDto {
        return userService.update(id, userRequestDto)

    }
}

48 996684418