package com.imertyildiz.grpcserver.Service;

import com.imertyildiz.grpcproto.HelloWorldRequest;
import com.imertyildiz.grpcproto.HelloWorldResponse;
import com.imertyildiz.grpcproto.HelloWorldServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreeterServer extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void helloWorld(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
        HelloWorldResponse setResponseMessage = HelloWorldResponse.newBuilder()
                .setResponseMessage("Hello " + request.getClientName() + " !!!").build();
        System.out.println(request.getClientName() + " sent a message: " + request.getRequestMessage());
        responseObserver.onNext(setResponseMessage);
        responseObserver.onCompleted();
    }

}