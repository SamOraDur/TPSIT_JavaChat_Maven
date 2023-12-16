package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import interfaces.ClientBLInterface;

public class ChatClientThread extends Thread{
    private Socket skt;
    private ClientBLInterface clientInterface;
    private boolean destroy;

    //richiesta socket e interfaccia del client
    public ChatClientThread(Socket skt,ClientBLInterface clientInterface){
        this.skt = skt;
        this.clientInterface = clientInterface;
        this.destroy = false;
    }

    //distruzione del thread
    public void destroy(){
        destroy = true;
    }

    public void run(){
        try{
            //apertura canali di comunicazione in/out
            ObjectOutputStream oos = new ObjectOutputStream(skt.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(skt.getInputStream());
            
            //finchè non viene distrutto dal client
            while(!destroy){
                
                //aspetta l'arrivo di un pacchetto
                Document pkt;
                pkt=(Document) ois.readObject();

                //recupero l'operazione da eseguire dal pacchetto
                String operation = pkt.getElementsByTagName("Operation").item(0).getTextContent();
                
                //si utilizza l'approccio a eventi, in base a quello che succede, dovrà accadere un determinato evento
                switch (operation) {
                    //,,,
                    case "ChatLoading":{
                        
                        //tutti i messaggi della chat nel pacchetto XML
                        NodeList chat = pkt.getElementsByTagName("XMLMsg");

                        //creo un arraylist di tutti i messaggi
                        ArrayList<Message> chatMsgs = new ArrayList<Message>();
                        for(int i = 0; i < chat.getLength(); i++){
                            
                            Element e = (Element)chat.item(i);
                            chatMsgs.add(new Message(e.getElementsByTagName("Content").item(0).getTextContent(),e.getElementsByTagName("Sender").item(0).getTextContent()));

                        }

                        //mandiamo all'interfaccia l'arraylist dei messaggi (a sua volta un arraylist con messaggio,sender e receiver)
                        clientInterface.LoadingChat(chatMsgs);
                        
                        break;
                    }
                    //,,,
                    case "SendMsg":{
                        //prendiamo il messaggio dal pacchetto xml e lo mandiamo all'interfaccia della chat
                        Element e = (Element) pkt.getElementsByTagName("XMLMsg");
                        Message msg = new Message(e.getElementsByTagName("Content").item(0).getTextContent(),e.getElementsByTagName("Sender").item(0).getTextContent());
                        clientInterface.GetSendMessage(msg);
                        
                        break;
                    }
                    //,,,
                    case "AckSentMsg":{

                        clientInterface.getSentMsgAck();
                        
                        break;
                    }

                }
            }
        }catch(ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }
}