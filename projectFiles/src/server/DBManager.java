package server;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DBManager {
    
    //inizializzazione variabili 
    private static Document doc;
    
    //TBE
    private final int UserNotFound = 0;
    private final int WrongPassword = 1;
    private final int PasswordChecked = 2;
    
    private final int UserDuplicated = 0;
    private final int SignUpChecked = 1;
    
    private DocumentBuilder builder;
    Connection conn;


     // costruttore
    public DBManager(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
        try{
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            
            String driver ="com.mysql.jdbc.Driver";
            Class.forName(driver);
            
            String url ="jdbc:mysql1://localhost:3306/chatdb";
            String user = "root";
            String psw = "";
            conn =  DriverManager.getConnection(url,user,psw);
               
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //metodo checkuser 
    public synchronized int CheckUser(String usr, String psw){
        int result = UserNotFound;
       
        try 
        {
            String query="SELECT NickName FROM users WHERE NickName='"+usr+"' AND PASSWORD= '"+psw+"';";
            ResultSet res = conn.createStatement().executeQuery(query);
            if(res.next()){
                result = PasswordChecked;
            }
            else
            {
                result = WrongPassword;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        return result;
    }

    //metodo addUserToDB 
    public synchronized int addUserToDB(String usr,String psw){
        int result = UserDuplicated;
        
        try
        {
            String inserInto= "INSERT INTO  utenti (NickName,password) VALUES ('"+usr+"','"+psw+"')";
            //ritorna 0 no 1 si
            int res = conn.createStatement().executeUpdate(inserInto);
            if(res>=1)
            {
                result = SignUpChecked;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       
        return result;
    }

    //metodo UpdateDB, per aggiungere messaggi
    public synchronized boolean UpdateDB(Element msg){
        Boolean result = false;
        
        try {

            //estrapolazione di sender e receiver dal pacchetto messagio
            String send = msg.getElementsByTagName("Sender").item(0).getTextContent();
            String receive = msg.getElementsByTagName("Receiver").item(0).getTextContent();
            
            String query = "SELECT id_chat FROM chat WHERE (user1='"+send+"' AND user2='"+receive+"') OR (user1='"+receive+"' AND user2='"+send+"')";
            
            ResultSet res= conn.createStatement().executeQuery(query);
            if(!res.next())
            {
                String InsertInto = "INSERT INTO chat (id_chat,user1,user2) VALUES (NULL, '"+send+"','"+receive+"')";
                int resInsert = conn.createStatement().executeUpdate(InsertInto);
                if(resInsert == 0){
                    throw new Exception("Inserimento non riuscito");
                }
                res = conn.createStatement().executeQuery(query);
                res.next();
            }
            
            String insert = "INSERT INTO messaggio(id_chat,id_messaggio,receiver,sender,testo) VALUES ("+res.getInt("id_chat")+",NULL,'"+send+"','"+receive+"','"+msg.getElementsByTagName("Content").item(0).getTextContent()+"')";
            conn.createStatement().executeUpdate(insert);

            //operazioni svolte con successo
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
        //metodo per raccogliere dati (messaggi) dal database

        public synchronized NodeList GetDSInfo(String usr_a,String usr_b){
            NodeList chatMsg = null;
            //uso il metodo per ritrovare l'elemento chat
            Element chat = GetChatFromDB(usr_a,usr_b);
            //uso quell'elemento per ricavare la NodeList dei messaggi
            if(chat!=null){
                chatMsg = chat.getChildNodes();
            }
            return chatMsg;
        }

        //metodo per cercare la chat nel database con input gli user

        public synchronized Element GetChatFromDB(String usr_a,String usr_b){
            //cerco elemento con id i due user
            Element chat = db.getElementById(usr_a+"-"+usr_b);
            if (chat == null) {
                //se non lo trovo,inverso gli user
                chat = db.getElementById(usr_b+"-"+usr_a);
            }
            return chat;
        }

        //metodo per rimuovere gli spazi bianchi (NOT EDITED)

        public synchronized static void removeWhitespaces(Element element){
            NodeList children = element.getChildNodes();
            for(int i = children.getLength()-1;i>=0;i--){
                Node child = children.item(i);
                if (child instanceof Text && ((Text) child).getData().trim().isEmpty()) {
                    element.removeChild(child);
                }else if(child instanceof Element){
                    removeWhitespaces((Element)child);
                }
            }
        }

        //metodo per ottenere la lista di tutti i contatti

        public synchronized NodeList GetContacts(String usr){
            NodeList contacts = db.getElementsByTagName("user");
            return contacts;
        }

        private synchronized static void saveXmlDocument(Document document, String filePath) throws Exception {
            // Salva il documento XML aggiornato
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //modifica proprietà per aggiungere dtd e indentazione automatica
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, DTD_FILE_PATH);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        }
}