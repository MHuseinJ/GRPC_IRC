package irc_protobuf;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class ChatIRCGrpc {

  // Static method descriptors that strictly reflect the proto.
  public static final io.grpc.MethodDescriptor<irc_protobuf.chatIRC.JoinRequest,
      irc_protobuf.chatIRC.Response> METHOD_JOIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc_protobuf.ChatIRC", "join",
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.JoinRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.Response.parser()));
  public static final io.grpc.MethodDescriptor<irc_protobuf.chatIRC.RegistrationRequest,
      irc_protobuf.chatIRC.Response> METHOD_REGISTRATION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc_protobuf.ChatIRC", "registration",
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.RegistrationRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.Response.parser()));
  public static final io.grpc.MethodDescriptor<irc_protobuf.chatIRC.LeaveRequest,
      irc_protobuf.chatIRC.Response> METHOD_LEAVECHANEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc_protobuf.ChatIRC", "leavechanel",
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.LeaveRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.Response.parser()));
  public static final io.grpc.MethodDescriptor<irc_protobuf.chatIRC.LogoutReq,
      irc_protobuf.chatIRC.Response> METHOD_EXIT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc_protobuf.ChatIRC", "exit",
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.LogoutReq.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.Response.parser()));
  public static final io.grpc.MethodDescriptor<irc_protobuf.chatIRC.SendMessage,
      irc_protobuf.chatIRC.Response> METHOD_SEND =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc_protobuf.ChatIRC", "send",
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.SendMessage.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.Response.parser()));
  public static final io.grpc.MethodDescriptor<irc_protobuf.chatIRC.UpdateRequest,
      irc_protobuf.chatIRC.ResponseString> METHOD_UPDATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc_protobuf.ChatIRC", "update",
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.UpdateRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(irc_protobuf.chatIRC.ResponseString.parser()));

  public static ChatIRCStub newStub(io.grpc.Channel channel) {
    return new ChatIRCStub(channel);
  }

  public static ChatIRCBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatIRCBlockingStub(channel);
  }

  public static ChatIRCFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatIRCFutureStub(channel);
  }

  public static interface ChatIRC {

    public void join(irc_protobuf.chatIRC.JoinRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver);

    public void registration(irc_protobuf.chatIRC.RegistrationRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver);

    public void leavechanel(irc_protobuf.chatIRC.LeaveRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver);

    public void exit(irc_protobuf.chatIRC.LogoutReq request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver);

    public void send(irc_protobuf.chatIRC.SendMessage request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver);

    public void update(irc_protobuf.chatIRC.UpdateRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.ResponseString> responseObserver);
  }

  public static interface ChatIRCBlockingClient {

    public irc_protobuf.chatIRC.Response join(irc_protobuf.chatIRC.JoinRequest request);

    public irc_protobuf.chatIRC.Response registration(irc_protobuf.chatIRC.RegistrationRequest request);

    public irc_protobuf.chatIRC.Response leavechanel(irc_protobuf.chatIRC.LeaveRequest request);

    public irc_protobuf.chatIRC.Response exit(irc_protobuf.chatIRC.LogoutReq request);

    public irc_protobuf.chatIRC.Response send(irc_protobuf.chatIRC.SendMessage request);

    public irc_protobuf.chatIRC.ResponseString update(irc_protobuf.chatIRC.UpdateRequest request);
  }

  public static interface ChatIRCFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> join(
        irc_protobuf.chatIRC.JoinRequest request);

    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> registration(
        irc_protobuf.chatIRC.RegistrationRequest request);

    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> leavechanel(
        irc_protobuf.chatIRC.LeaveRequest request);

    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> exit(
        irc_protobuf.chatIRC.LogoutReq request);

    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> send(
        irc_protobuf.chatIRC.SendMessage request);

    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.ResponseString> update(
        irc_protobuf.chatIRC.UpdateRequest request);
  }

  public static class ChatIRCStub extends io.grpc.stub.AbstractStub<ChatIRCStub>
      implements ChatIRC {
    private ChatIRCStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatIRCStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatIRCStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatIRCStub(channel, callOptions);
    }

    @java.lang.Override
    public void join(irc_protobuf.chatIRC.JoinRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_JOIN, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void registration(irc_protobuf.chatIRC.RegistrationRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_REGISTRATION, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void leavechanel(irc_protobuf.chatIRC.LeaveRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LEAVECHANEL, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void exit(irc_protobuf.chatIRC.LogoutReq request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void send(irc_protobuf.chatIRC.SendMessage request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_SEND, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void update(irc_protobuf.chatIRC.UpdateRequest request,
        io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.ResponseString> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_UPDATE, callOptions), request, responseObserver);
    }
  }

  public static class ChatIRCBlockingStub extends io.grpc.stub.AbstractStub<ChatIRCBlockingStub>
      implements ChatIRCBlockingClient {
    private ChatIRCBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatIRCBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatIRCBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatIRCBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public irc_protobuf.chatIRC.Response join(irc_protobuf.chatIRC.JoinRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_JOIN, callOptions), request);
    }

    @java.lang.Override
    public irc_protobuf.chatIRC.Response registration(irc_protobuf.chatIRC.RegistrationRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_REGISTRATION, callOptions), request);
    }

    @java.lang.Override
    public irc_protobuf.chatIRC.Response leavechanel(irc_protobuf.chatIRC.LeaveRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LEAVECHANEL, callOptions), request);
    }

    @java.lang.Override
    public irc_protobuf.chatIRC.Response exit(irc_protobuf.chatIRC.LogoutReq request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request);
    }

    @java.lang.Override
    public irc_protobuf.chatIRC.Response send(irc_protobuf.chatIRC.SendMessage request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_SEND, callOptions), request);
    }

    @java.lang.Override
    public irc_protobuf.chatIRC.ResponseString update(irc_protobuf.chatIRC.UpdateRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_UPDATE, callOptions), request);
    }
  }

  public static class ChatIRCFutureStub extends io.grpc.stub.AbstractStub<ChatIRCFutureStub>
      implements ChatIRCFutureClient {
    private ChatIRCFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatIRCFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatIRCFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatIRCFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> join(
        irc_protobuf.chatIRC.JoinRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_JOIN, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> registration(
        irc_protobuf.chatIRC.RegistrationRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_REGISTRATION, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> leavechanel(
        irc_protobuf.chatIRC.LeaveRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LEAVECHANEL, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> exit(
        irc_protobuf.chatIRC.LogoutReq request) {
      return futureUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.Response> send(
        irc_protobuf.chatIRC.SendMessage request) {
      return futureUnaryCall(
          channel.newCall(METHOD_SEND, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<irc_protobuf.chatIRC.ResponseString> update(
        irc_protobuf.chatIRC.UpdateRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_UPDATE, callOptions), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final ChatIRC serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("irc_protobuf.ChatIRC")
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_JOIN,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                irc_protobuf.chatIRC.JoinRequest,
                irc_protobuf.chatIRC.Response>() {
              @java.lang.Override
              public void invoke(
                  irc_protobuf.chatIRC.JoinRequest request,
                  io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
                serviceImpl.join(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_REGISTRATION,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                irc_protobuf.chatIRC.RegistrationRequest,
                irc_protobuf.chatIRC.Response>() {
              @java.lang.Override
              public void invoke(
                  irc_protobuf.chatIRC.RegistrationRequest request,
                  io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
                serviceImpl.registration(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LEAVECHANEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                irc_protobuf.chatIRC.LeaveRequest,
                irc_protobuf.chatIRC.Response>() {
              @java.lang.Override
              public void invoke(
                  irc_protobuf.chatIRC.LeaveRequest request,
                  io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
                serviceImpl.leavechanel(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_EXIT,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                irc_protobuf.chatIRC.LogoutReq,
                irc_protobuf.chatIRC.Response>() {
              @java.lang.Override
              public void invoke(
                  irc_protobuf.chatIRC.LogoutReq request,
                  io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
                serviceImpl.exit(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_SEND,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                irc_protobuf.chatIRC.SendMessage,
                irc_protobuf.chatIRC.Response>() {
              @java.lang.Override
              public void invoke(
                  irc_protobuf.chatIRC.SendMessage request,
                  io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.Response> responseObserver) {
                serviceImpl.send(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_UPDATE,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                irc_protobuf.chatIRC.UpdateRequest,
                irc_protobuf.chatIRC.ResponseString>() {
              @java.lang.Override
              public void invoke(
                  irc_protobuf.chatIRC.UpdateRequest request,
                  io.grpc.stub.StreamObserver<irc_protobuf.chatIRC.ResponseString> responseObserver) {
                serviceImpl.update(request, responseObserver);
              }
            }))).build();
  }
}
