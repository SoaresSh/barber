package com.barber.api.domain.service

import com.barber.api.domain.dtos.request.UserRequestDto
import com.barber.api.domain.dtos.response.UserResponseDto
import com.barber.api.domain.entities.User
import com.barber.api.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImp (
    private val userRepository: UserRepository
):UserServiceInterface {
    override fun save(userRequestDto: UserRequestDto): UserResponseDto {
        val user = userRepository.save(
            User(
                firstName = userRequestDto.firstName,
                lastName = userRequestDto.lastName,
                //birthdate = userRequestDto.birthDate,
                email = userRequestDto.email,
                password = userRequestDto.password,
                cpfCnpj = userRequestDto.cpfCnpj,
            )
        )
        return UserResponseDto(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            //birthdate = user.birthDate,
            email = user.email,
            password = user.password,
            cpfCnpj = user.cpfCnpj,
        )
    }

    override fun update(id:Long, userRequestDto: UserRequestDto): UserResponseDto {
        val user = userRepository.findById(id).orElseThrow{
            IllegalArgumentException("Erro");
        }


        user.firstName = userRequestDto.firstName
        user.lastName = userRequestDto.lastName
        //birthdate = userRequestDto.birthDate
        user.email = userRequestDto.email
        user.password = userRequestDto.password
        user.cpfCnpj = userRequestDto.cpfCnpj

        val userUpdate = userRepository.save(user)
        return UserResponseDto(
            id = userUpdate.id,
            firstName = userUpdate.firstName,
            lastName = userUpdate.lastName,
            //birthdate = userUpdate.birthDate,
            email = userUpdate.email,
            password = userUpdate.password,
            cpfCnpj = userUpdate.cpfCnpj,
        )
    }

//    override fun delete(id: Long, userRequestDto: UserRequestDto): UserResponseDto {
//        TODO("Not yet implemented")
//    }
}