package com.grpctest.helloworldgrpc.server;


import com.grpctest.helloworldgrpc.GreeterGrpc;
import com.grpctest.helloworldgrpc.HelloRequest;
import com.grpctest.helloworldgrpc.HelloResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class GreeterServer extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver){
        String name = request.getName();
        String message = "Hello " + name + "!";
        HelloResponse response = HelloResponse.newBuilder().setMessage(message).build();

        //sending the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
