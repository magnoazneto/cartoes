package br.zupedu.ot4.cartoes.criacao

import java.time.LocalDateTime

data class CartaoKafkaMessage(
    val documento: String,
    val idProposta: Long,
    val numero: String,
    val criadoEm: LocalDateTime,
    val titular: String
) {
    constructor(cartao: Cartao) : this(
        cartao.documento,
        cartao.idProposta,
        cartao.numero,
        cartao.criadoEm,
        cartao.titular
    ){

    }
}