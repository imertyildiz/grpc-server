package com.imertyildiz.grpcserver.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imertyildiz.grpcproto.HelloWorldRequest;
import com.imertyildiz.grpcproto.HelloWorldResponse;
import com.imertyildiz.grpcproto.HelloWorldServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreeterServer extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(GreeterServer.class);

    @Override
    public void helloWorld(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
        HelloWorldResponse setResponseMessage = HelloWorldResponse.newBuilder()
                .setResponseMessage("Hello " + request.getClientName() + " !!!").build();
        logger.info(String.format("%1s sent a message: %1s", request.getClientName(),request.getRequestMessage()));
        responseObserver.onNext(setResponseMessage);
        responseObserver.onCompleted();
    }

}