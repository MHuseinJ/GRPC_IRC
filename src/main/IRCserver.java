package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mhusainj
 */
import io.grpc.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import irc_protobuf.ChatIRCGrpc;

import java.util.logging.Logger;

public class IRCserver {
  private static final Logger logger = Logger.getLogger(IRCserver.class.getName());

   /* The port on which the server should run */
    private int port = 50051;
    private ServerImpl server;
    private ChatIRCGrpc.ChatIRC impl;

    public IRCserver(ChatIRCGrpc.ChatIRC service) {
        this(service,50051);
    }

    public IRCserver (ChatIRCGrpc.ChatIRC service,int port) {
        this.impl = service;
        this.port = port;
    }


  private void start() throws Exception {
      server = NettyServerBuilder.forPort(port)
        .addService(ChatIRCGrpc.bindService(impl))
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        IRCserver.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws Exception {
    ChatIRCGrpc.ChatIRC impl = new IRChandler();
    final IRCserver server = new IRCserver(impl);
    server.start();
    server.blockUntilShutdown();
  }
}