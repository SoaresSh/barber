package com.barber.api.domain.service

import com.barber.api.domain.dtos.request.LoginRequestDto
import com.barber.api.domain.dtos.request.UserRequestDto
import com.barber.api.domain.dtos.response.UserResponseDto
import com.barber.api.domain.entities.User
import com.barber.api.infrastructure.repository.UserRepository
import com.barber.api.util.CodeGeneratorUtil
import org.springframework.stereotype.Service
import java.nio.file.attribute.UserPrincipalNotFoundException

@Service
class UserServiceImp (
    private val userRepository: UserRepository,
    private val codeGeneratorUtil: CodeGeneratorUtil,
):UserServiceInterface {
    override fun save(userRequestDto: UserRequestDto): UserResponseDto {
        val existingUser = userRepository.findByCpf(userRequestDto.cpf)

        if (existingUser != null) {
            throw IllegalArgumentException("Já existe um usuário com o CPF ${userRequestDto.cpf}")
        }
        val user = userRepository.save(
            User(
                firstName = if (userRequestDto.firstName!!.isNotBlank()) userRequestDto.firstName else existingUser?.firstName,
                lastName = userRequestDto.lastName,
                email = userRequestDto.email,
                password = userRequestDto.password,
                cpf = userRequestDto.cpf,
                barber = userRequestDto.barber,
                code = codeGeneratorUtil.gerarProximoCodigo(),
                telefone = userRequestDto.telefone,
                endereco = userRequestDto.endereco,
                profileImage = userRequestDto.profileImage,
                horario = userRequestDto.horario
            )
        )
        return UserResponseDto(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            password = user.password,
            cpf = user.cpf,
            barber = user.barber,
            telefone = user.telefone,
            endereco = user.endereco,
            profileImage = user.profileImage,
            horario = user.horario
        )
    }

    override fun update(id:Long, userRequestDto: UserRequestDto): UserResponseDto {
        val user = userRepository.findById(id).orElseThrow{
            IllegalArgumentException("Erro");
        }

        user.firstName = if (userRequestDto.firstName.equals("")) user.firstName else userRequestDto.firstName
        user.lastName = if (userRequestDto.lastName.equals("")) user.lastName else userRequestDto.lastName
        user.email = if (userRequestDto.email.equals("")) user.email else userRequestDto.email
        user.password = if (userRequestDto.password.equals("")) user.password else userRequestDto.password
        user.cpf = if (userRequestDto.cpf.equals("")) user.cpf else userRequestDto.cpf
        user.telefone = if (userRequestDto.telefone.equals("")) user.telefone else userRequestDto.telefone
        user.endereco = if (userRequestDto.endereco.equals("")) user.endereco else userRequestDto.endereco
        user.profileImage = if (userRequestDto.profileImage?.equals("") == true) user.profileImage else userRequestDto.profileImage
        user.horario = if (userRequestDto.horario.equals("") == true) user.horario else userRequestDto.horario

        val userUpdate = userRepository.save(user)
        return UserResponseDto(
            id = userUpdate.id,
            firstName = userUpdate.firstName,
            lastName = userUpdate.lastName,
            email = userUpdate.email,
            password = userUpdate.password,
            cpf = userUpdate.cpf,
            barber = userUpdate.barber,
            telefone = userUpdate.telefone,
            endereco = userUpdate.endereco,
            profileImage = userUpdate.profileImage,
            horario = userUpdate.horario
        )
    }

    override fun delete(id: Long) {
        val deleteUser = userRepository.findById(id).orElseThrow {
            UserPrincipalNotFoundException("Usuário com ID $id não encontrado.")
        }
        userRepository.delete(deleteUser)
    }

    override fun authLoginClient(loginRequestDto: LoginRequestDto): Boolean {
        val user: User? = userRepository.findByCpf(loginRequestDto.cpfCnpj)

        return user != null && loginRequestDto.password == user.password
    }

    override fun getUserDataByCpf(cpf: String): User? {
        return userRepository.findByCpf(cpf)
    }

    fun getById(id: Long): User {
        return userRepository.findById(id).orElseThrow {
            UserPrincipalNotFoundException("Usuário não encontrado")
        }
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun verifyCamps(cpf: String): Boolean {
    return userRepository.existsByCpfAndTelefoneIsNotNullAndEnderecoIsNotNull(cpf)
    }

}