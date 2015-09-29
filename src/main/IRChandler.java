/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import io.grpc.stub.StreamObserver;
import irc_protobuf.ChatIRCGrpc;
import irc_protobuf.chatIRC;
import irc_protobuf.chatIRC.JoinRequest;
import irc_protobuf.chatIRC.LeaveRequest;
import irc_protobuf.chatIRC.LogoutReq;
import irc_protobuf.chatIRC.RegistrationRequest;
import irc_protobuf.chatIRC.Response;
import irc_protobuf.chatIRC.ResponseString;
import irc_protobuf.chatIRC.SendMessage;
import irc_protobuf.chatIRC.UpdateRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mhusainj
 */
public class IRChandler implements ChatIRCGrpc.ChatIRC{
    
    private static final List<User> userList = new <User>ArrayList();
    
    private static final Logger logger = Logger.getLogger(IRChandler.class.getName());
    private ChatIRCGrpc.ChatIRCBlockingStub blockingStub;
    
    public chatIRC.Response registration(RegistrationRequest request) {
        String username = request.getName();
        userList.add(new User(username));
	System.out.println(username + " enters the server.");
        return Response.newBuilder().setResponse(0).build();
    }
    
    public ResponseString update(UpdateRequest request){
        String username = request.getName();
        
        String retval = "";
	for (User user : userList) {
		if (user.getName().equals(username)) {
			List<String> messages = user.getMessages();
			if (messages.isEmpty()){
				retval = "empty";
			} else {
				for (String message : messages) {
					retval = retval + message + "\n";
				}
			}
		}
	}
	return ResponseString.newBuilder().setResponse(retval).build();
    }
    
    public Response leavechan(LeaveRequest request){
        String channelname = request.getChannel();
        String username = request.getName();
        int retval = 1;
	for (User user : userList) {
		if (user.getName().equals(username)) {
			retval =  user.leave(channelname);
			System.out.println(username + " leaves " + channelname);
		}
	}
	return Response.newBuilder().setResponse(retval).build();
    }
    
    public Response gabung(JoinRequest request){
        String channelname = request.getChannel();
        String username = request.getName();
        for (User user : userList) {
		if (user.getName().equals(username)) {
			user.join(channelname);
			System.out.println(username + " joined "+ channelname);
		}
	}
	return Response.newBuilder().setResponse(0).build();
    } 
    
    public Response logout(LogoutReq request){
        String username = request.getName();
        int retval = 1;
        if (userList.contains(new User(username))){
            userList.remove(userList.indexOf(new User(username)));
            retval = 0;
            System.out.println(username + " exits the server.");
          //System.out.println(user+" berhasil keluar dari "+channel);
        }else{
         try {   
            for (User user : userList) {
			if (user.getName().equals(username)) {
				userList.remove(user);
				retval = 0;
				System.out.println(username + " has exit site.");
                        }
		
		}
         }catch(Exception e){
             
         }
            //System.out.println(username+"tidak ada ");
        }
//		for (User user : userList) {
//			if (user.getName().equals(username)) {
//				userList.remove(user);
//				retval = 0;
//				System.out.println(username + " exits the server.");
//			}
//		}
	return Response.newBuilder().setResponse(retval).build();
    }
    
    public Response message(SendMessage request){
        String username = request.getName();
        String channelname = request.getChannel();
        String msg = request.getMessage();
        for (User user : userList) {
		user.Broadcast(channelname, "[" + channelname + "] (" + username + ") " + msg);
	}
	return Response.newBuilder().setResponse(0).build();
    }
    
    @Override
    public void join(chatIRC.JoinRequest request, StreamObserver<chatIRC.Response> responseObserver) {
        responseObserver.onValue(gabung(request));
        responseObserver.onCompleted();
    }

    @Override
    public void registration(chatIRC.RegistrationRequest request, StreamObserver<chatIRC.Response> responseObserver) {
        responseObserver.onValue(registration(request));
        responseObserver.onCompleted();
    }

    @Override
    public void leavechanel(chatIRC.LeaveRequest request, StreamObserver<chatIRC.Response> responseObserver) {
        responseObserver.onValue(leavechan(request));
        responseObserver.onCompleted();
    }

    @Override
    public void exit(chatIRC.LogoutReq request, StreamObserver<chatIRC.Response> responseObserver) {
        responseObserver.onValue(logout(request));
        responseObserver.onCompleted();
    }

    @Override
    public void send(chatIRC.SendMessage request, StreamObserver<chatIRC.Response> responseObserver) {
        responseObserver.onValue(message(request));
        responseObserver.onCompleted();
    }

    @Override
    public void update(chatIRC.UpdateRequest request, StreamObserver<chatIRC.ResponseString> responseObserver) { 
        responseObserver.onValue(update(request));
        responseObserver.onCompleted();
    }
    
}
