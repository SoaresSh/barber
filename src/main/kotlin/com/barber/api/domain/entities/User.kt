package com.barber.api.domain.entities

import jakarta.persistence.*

@Table(name = "users")
@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id:Long? = null,

    @Column(name = "first_name")
    var firstName:String? = null,

    @Column(name = "last_name")
    var lastName:String? = null,

    @Column(name = "email")
    var email:String? = null,

    @Column(name = "password")
    var password: String,

    @Column(name = "cpf")
    var cpf: String,

    @Column(name = "telefone")
    var telefone: String? = null,

    @Column(name = "endereco")
    var endereco: String? = null,

    @Column(name = "barber")
    var barber: Boolean,

    @Column(name = "code")
    var code: String,

    @Column(name = "profile_image", columnDefinition = "LONGBLOB")
    var profileImage: ByteArray? = null,

    @Column(name = "horario")
    var horario: String? = null,

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (barber != other.barber) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (cpf != other.cpf) return false
        if (telefone != other.telefone) return false
        if (endereco != other.endereco) return false
        if (code != other.code) return false
        if (profileImage != null) {
            if (other.profileImage == null) return false
            if (!profileImage.contentEquals(other.profileImage)) return false
        } else if (other.profileImage != null) return false
        if (horario != other.horario) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + barber.hashCode()
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + password.hashCode()
        result = 31 * result + cpf.hashCode()
        result = 31 * result + telefone.hashCode()
        result = 31 * result + endereco.hashCode()
        result = 31 * result + code.hashCode()
        result = 31 * result + (profileImage?.contentHashCode() ?: 0)
        result = 31 * result + (horario.hashCode())
        return result
    }
}