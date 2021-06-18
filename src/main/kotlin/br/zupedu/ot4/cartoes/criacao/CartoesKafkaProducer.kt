package br.zupedu.ot4.cartoes.criacao

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient("cartoes-client")
interface CartoesKafkaProducer {

    @Topic("novo-cartao")
    fun novoCartao(@KafkaKey idCartao: Long, cartaoKafkaMessage: CartaoKafkaMessage)

}