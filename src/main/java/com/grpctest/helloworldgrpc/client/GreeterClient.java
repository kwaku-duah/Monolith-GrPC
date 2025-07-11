package com.grpctest.helloworldgrpc.client;

import com.grpctest.helloworldgrpc.GreeterGrpc;
import com.grpctest.helloworldgrpc.HelloRequest;
import com.grpctest.helloworldgrpc.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GreeterClient {
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public GreeterClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        this.blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public String sayHello(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response = blockingStub.sayHello(request);

        return response.getMessage();
    }
}
