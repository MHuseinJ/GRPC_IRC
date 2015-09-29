/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import io.grpc.stub.StreamObserver;
import irc_protobuf.ChatIRCGrpc;
import irc_protobuf.chatIRC;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mhusainj
 */
public class IRChandler implements ChatIRCGrpc.ChatIRC{

    @Override
    public void join(chatIRC.JoinRequest request, StreamObserver<chatIRC.Response> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registration(chatIRC.RegistrationRequest request, StreamObserver<chatIRC.Response> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leavechanel(chatIRC.LeaveRequest request, StreamObserver<chatIRC.Response> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exit(chatIRC.LogoutReq request, StreamObserver<chatIRC.Response> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void send(chatIRC.SendMessage request, StreamObserver<chatIRC.Response> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(chatIRC.UpdateRequest request, StreamObserver<chatIRC.ResponseString> responseObserver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
