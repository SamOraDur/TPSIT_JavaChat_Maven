# TPSIT_ChatSocket

# TO-DO
/*

# SERVER 

DBManager.java : (Classe per utilizzo del database) (tutti i metodi devono essere synchronized)
  creazione file xml se non esiste
  metodo CheckUser per verificare (user hanno attributo nickname e element password, così getElementById è utilizzabile):
    se non trova si usa costante UserNotFound
    si controlla se la password è giusta
  metodo per aggiungere un messaggio
  metodo per prendere i messaggi dal database (che utilizza un metodo getChat)

ServerChat.java : (implementa le interfaccie)
  metodo login (usa il check user del database che gli ritorna 0 1 2)
  metodo loadChat (usa getchatmessages)
  metodo sendMessage (aggiunge messagio al file xml e ritorna il receiver per interrogare la mappa,prendere il socket e inviare il messaggio al destinatario)

ServerChatSkeleton.java : ()
  metodo costruttore (prende in input il serverchatreale, instanzia l'hashtable e il semaforo per l'hashtable)
  metodo Skeleton (stessa cosa del server reale per la gestione del socket, creo un thread con socket, skeleton (con attributo this) sevono anche semaforo e hashmap ma li posso prendere con i getter)

ServerChatThread.java : ()
  metodo costruttore con stessi parametri nello skeleton
  metodo run (while !esci (quando : ))
    si crea bufferin e bufferout
    mi arriva un pacchetto xml (document)
    da questo prendo l'operazione
    switch case con
      login
        vuole user e password che dà un metodo del server skeleton che lo da al server vero
        il risultato del login lo invio in output al client (loggato,no password,nonesiste)
        se tutto apposto apro sezione critica e aggiungo user all'hashmap
        altrimenti chiudo sia il socket che il buffer (il client deve fare un altra richiesta di connessione)
      loadChat
        prendo i nickname dei due utenti (chi ricerca e di cui sto cercando la chat)
        prendo i messaggi tramite il loadChat del server vero (tramite skeleton che lo passa al server vero)
        tutta la lista al buffer di output (anche con sender e receiver)
      sendMessage
        dal pacchetto prendo solo l'elemento del messaggio
        chiamo il metodo sendMessagge (tramite skeleton che lo passa al server concreto)
        questo mi da la stringa del receiver che lo uso per ricevere il socket dalla hashmap (dentro i semafori)
        mando il messaggio dal buffer di output
      registrazione
        simile al login (se già risulta errore, se no aggiunge all'xml)

# CLIENT

 login
   creo il socket (ip,porta)
   crea un thread che aspetta il buffer di input per i messaggi che potrebbero arrivare
   l'oggetto del thread può essere utilizzato per fare i logout

*/
