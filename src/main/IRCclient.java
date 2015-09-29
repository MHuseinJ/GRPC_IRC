/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import io.grpc.ChannelImpl;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import irc_protobuf.*;
import irc_protobuf.chatIRC.Response;
import irc_protobuf.chatIRC.ResponseString;
/**
 *
 * @author mhusainj
 */
public class IRCclient {
  
  private static final Logger logger = Logger.getLogger(IRCclient.class.getName());
  private static String[] usernamelist = {"lalala", "randomize", "fafafa", "anehkuz", "kuzma", "borma", "zip"};
  private static List<String> channellist = new ArrayList<>();
  private static String user;
  private ChannelImpl channel;
  private ChatIRCGrpc.ChatIRCBlockingStub blockingStub;
  private static boolean tersambung;
  private static Scanner sc = new Scanner(System.in);

    /** Construct client connecting to HelloWorld server at {@code host:port}.
     * @param host
     * @param port */
    public IRCclient(String host, int port) {
        channel =
                NettyChannelBuilder.forAddress(host, port).negotiationType(NegotiationType.PLAINTEXT)
                        .build();
        blockingStub = ChatIRCGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    
    public Response registration(String name) {
        try {
            chatIRC.RegistrationRequest request = chatIRC.RegistrationRequest.newBuilder()
                    .setName(name)
                    .build();
            chatIRC.Response response = blockingStub.registration(request);
            return response;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }
    
    public ResponseString regularUpdate(String name) {
        try {
            chatIRC.UpdateRequest request = chatIRC.UpdateRequest.newBuilder()
                    .setName(name)
                    .build();
            ResponseString response = blockingStub.update(request);
            return response;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }
    public Response gabung(String name, String namec) {
        try {
            chatIRC.JoinRequest request = chatIRC.JoinRequest.newBuilder()
                    .setName(name)
                    .setChannel(namec)
                    .build();
            chatIRC.Response response = blockingStub.join(request);
            return response;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }
    public Response leave(String name, String namec) {
        try {
            chatIRC.LeaveRequest request = chatIRC.LeaveRequest.newBuilder()
                    .setName(name)
                    .setChannel(namec)
                    .build();
            chatIRC.Response response = blockingStub.leavechanel(request);
            return response;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }
    public Response message(String name, String namec, String message) {
        try {
            chatIRC.SendMessage request = chatIRC.SendMessage.newBuilder()
                    .setName(name)
                    .setChannel(namec)
                    .setMessage(message)
                    .build();
            chatIRC.Response response = blockingStub.send(request);
            return response;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }
    
    public Response logout(String name) {
        try {
            chatIRC.LogoutReq request = chatIRC.LogoutReq.newBuilder()
                    .setName(name)
                    .build();
            chatIRC.Response response = blockingStub.exit(request);
            return response;
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return null;
        }
    }
    
  public static void main(String[] args) throws Exception {
    final IRCclient client = new IRCclient("localhost", 50051);
    tersambung = true;
    try {
      /* Access a service running on the local machine on port 50051 */;
      Random rnd = new Random();
      int indeks = rnd.nextInt(usernamelist.length);
      String Randusername = usernamelist[indeks] + rnd.nextInt(100);  
        int res;
        res = client.registration(Randusername).getResponse();
        while (res!= 0){
          Randusername = usernamelist[indeks] + rnd.nextInt(100);
          res = client.registration(Randusername).getResponse(); 
        }
        user = Randusername;
        channellist.add("lounge");
        System.out.println("Anda Login Sebagai: " + Randusername);
            
            Runnable seeding = new Runnable() {
                @Override
                public void run(){
                    try {
                        Thread.sleep(100);
                        while (true){
                            String messages = client.regularUpdate(user).getResponse();
                            if ("err".equals(messages) || "empty".equals(messages)){
                                
                            }else{
                                System.out.println("Message(s): \n" + messages);
                            }
                            Thread.sleep(1000 * 60);
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            
            new Thread(seeding).start(); 
        while (tersambung) {
                String masukkan;
                masukkan = sc.next();
                if (masukkan.equals("JOIN")) {
                    String channel = sc.next();
                    
                    boolean found = false;
                    for(String str: channellist) {
                        if(str.trim().contains(channel)){
                            found = true;
                            break;
                        } 
                    }
                    if (found){
                        System.out.println(user+"sudah ada dalam "+channel);
                    }else{
                        client.gabung(user, channel);
                        channellist.add(channel);
                        System.out.println(user+" berhasil gabung ke "+channel);
                    }
                } else if (masukkan.equals("LEAVE")) {
                    String channel = sc.next();
                    int product = client.gabung(user,channel).getResponse();
                    if (channellist.contains(channel)){
                        channellist.remove(channellist.indexOf(channel));
                        client.leave(user, channel);
                        System.out.println(user+" berhasil keluar dari "+channel);
                    }else{
                        System.out.println(user+"tidak ada dalam "+channel);
                    }
                } else if (masukkan.equals("NICK")){
                    String uname = sc.next();
                    int product = client.registration(uname).getResponse();
                    if (product == 0){
                        client.logout(user);
                        user = uname;
                        client.gabung(user, "lounge");
                        System.out.println("Anda Login Sebagai: " + user);
                    }else{
                        System.out.println(uname + " sudah ada");       
                    }
                } else if (masukkan.equals("@")){                    
                    String channel = sc.next();
                    if (channellist.contains(channel)){
                        String mes = sc.nextLine();
                        int resp = client.message(user, channel, mes).getResponse();
                        if (resp == 0){
                            String messages = client.regularUpdate(user).getResponse();
                            if ("err".equals(messages) || "empty".equals(messages)){

                            }else{
                                System.out.println("Message(s): \n" + messages);
                            }
                        }else{
                            System.out.println("Error Mengirim pesan");
                        }
                    }else{
                        System.out.println("Anda Tidak terdaftar di " + channel);
                    }
                    
                } else if (masukkan.equals("EXIT")){
                    try {
                        client.logout(user);
                        System.out.println(user+" logout\n");
                        tersambung = false;
                        client.shutdown();
                        System.exit(0);
                    }catch(Exception x){
                        System.exit(0);
                    }
                }else {
                    masukkan += sc.nextLine();
                    System.out.println("Broadcasting Message . . . .");
                    for (int i = 0; i < channellist.size();i++){
                        int resp = client.message(user, channellist.get(i), masukkan).getResponse();
                    }
                    String messages = client.regularUpdate(user).getResponse();
                    if ("err".equals(messages) || "empty".equals(messages)){

                    }else{
                        System.out.println("Message(s): \n" + messages);
                    }
                }
            }
      
      
    } finally {
      client.shutdown();
    }
  }
}
/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/**
 * A simple client that requests a greeting from the {@link HelloWorldServer}.
 */


