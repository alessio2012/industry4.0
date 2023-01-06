package industry40;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class ServerPuntiDiVerifica implements Runnable {
  protected List<PuntoDiVerifica> elenco_pdv;
  private int port;
  private volatile boolean stopServer = false;
  private Thread executer;
  
  ServerSocket serverSocket;                                       // Variabili di connessione
  Socket connection = null;                                        // Connessione
    
  public ServerPuntiDiVerifica() {

  }
  
  public void startServer( int tmpPort ) {
      port = tmpPort;
      executer = new Thread( this );
      executer.start();
  }



  public void run() {
    
    elenco_pdv = new ArrayList<PuntoDiVerifica>();                   // Allocazione ed inizializzazione della lista "elenco_pdf"

                                                                    /* CONTROLLO RICHIESTE */

      System.out.println("Thread in esecuzione \n");
      try {
        serverSocket = new ServerSocket( port );                        // Apertura socket
        System.out.println("@dicaprioale | SERVER: Socket aperta");
        System.out.println("@dicaprioale | SERVER: In attesa di nuove connessioni" );
        System.out.println( stopServer );


        while( true ) {

          connection = serverSocket.accept();
          System.out.println("@dicaprioale | SERVER: Ho individuato una richiesta. Connessione avvenuta con successo");
          ConnessioneClient connessioneClient = new ConnessioneClient( connection, this );                 

        }


      }catch(IOException e ) { System.out.println( e ); }
       try{ connection.close(); } catch ( IOException e ) { System.out.println( e ); }  

  }
  
  public void stopServer() throws IOException { 
      executer.interrupt(); 
      System.out.println("Server chiuso");
      serverSocket.close();
      try{ 
          if( connection == null ) {
              System.out.println("@dicaprioale | SERVER: Non c'è nessuna connessione stabilita");
              return;
          } else {
              connection.close(); 
              System.out.println("@dicaprioale | SERVER: Tutte le connessioni sono state chiuse");
              return;
          }
          
      } catch ( IOException e ) { System.out.println( e ); }  
  }


}
