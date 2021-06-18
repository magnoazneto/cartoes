package br.zupedu.ot4.cartoes.criacao

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.validation.Valid

@KafkaListener(offsetReset = OffsetReset.EARLIEST, groupId = "cartoes")
@Validated
class PropostasKafkaConsumer(
    @Inject val cartaoRepository: CartaoRepository,
    @Inject val cartaoKafkaProducer: CartoesKafkaProducer
) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    @Topic("propostas-elegiveis")
    fun criarCartao(@KafkaKey idProposta: Long, @Valid proposta: PropostaKafkaMessage) {
        LOGGER.info("nova proposta elegivel publicada: $proposta")
        val novoCartao = proposta.toModel()
        cartaoRepository.save(novoCartao)
        LOGGER.info("novo cartao criado: ${novoCartao.numero}")
        cartaoKafkaProducer.novoCartao(novoCartao.id!!, CartaoKafkaMessage(novoCartao))
    }
}