package com.barber.api.domain.service

import com.barber.api.domain.dtos.request.UserRequestDto
import com.barber.api.domain.dtos.response.UserResponseDto
import com.barber.api.domain.entities.User

interface UserServiceInterface {
    fun save(userRequestDto: UserRequestDto): UserResponseDto
    //fun delete(id:Long, userRequestDto: UserRequestDto): UserResponseDto
    fun update(id:Long, userRequestDto: UserRequestDto): UserResponseDto
}