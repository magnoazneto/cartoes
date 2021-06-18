package br.zupedu.ot4.cartoes.criacao

import br.zupedu.ot4.shared.annotations.CPForCNPJ
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
data class PropostaKafkaMessage(
    @field:CPForCNPJ @field:NotBlank val documento: String,
    @field:NotBlank val nome: String,
    @field:Positive val idProposta: Long
) {
    fun toModel() = Cartao(nome, idProposta, documento)
}