package br.zupedu.ot4.cartoes.criacao

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Cartao(
    val titular: String,
    val idProposta: Long,
    val documento: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val numero: String = gerarNumero()
    val criadoEm = LocalDateTime.now()

    private fun gerarNumero() : String {
        var numero = ""
        for(j in 1..4){
            for(i in 1..4) numero += (Math.random()*10.0).toInt()
            if(j != 4) numero += "-"
        }
        return numero
    }
}