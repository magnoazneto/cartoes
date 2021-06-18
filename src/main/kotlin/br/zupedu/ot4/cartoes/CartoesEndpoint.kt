package br.zupedu.ot4.cartoes

import br.zupedu.ot4.CartoesServiceGrpc
import br.zupedu.ot4.ConsultaCartaoRequest
import br.zupedu.ot4.ConsultaCartaoResponse
import io.grpc.stub.StreamObserver

import io.micronaut.validation.Validated
import javax.inject.Singleton

@Singleton
@Validated
class CartoesEndpoint(

) : CartoesServiceGrpc.CartoesServiceImplBase() {

    override fun consultar(
        request: ConsultaCartaoRequest,
        responseObserver: StreamObserver<ConsultaCartaoResponse>
    ) {
        super.consultar(request, responseObserver)
    }
}