package industry40;

import java.io.*;
import java.net.Socket;

public class ConnessioneClient implements Runnable {
  private Socket connection = null;
  private ServerPuntiDiVerifica server;

                                                                           /* STREAM DI COMUNICAZIONE */
  private InputStreamReader in;
  private BufferedReader sIN;
  private OutputStream out;
  private PrintWriter sOUT;

  PuntoDiVerifica puntoDiVerifica;
  String risposta;
  String comandoRicevuto;



  public ConnessioneClient( Socket connessione, ServerPuntiDiVerifica server  ) {
    this.connection = connessione;
    this.server = server;

    try {
                                                                             /* INSTAURAZIONE DEI FLUSSI DI COMUNICAZIONE */
                                                                             // FLUSSI DI OUTPUT
      out = connessione.getOutputStream();
      sOUT = new PrintWriter( out );
                                                                              // FLUSSI DI INPUT
      in = new InputStreamReader( connessione.getInputStream() );
      sIN = new BufferedReader( in );
    } catch (IOException e) {
    }

    new Thread(this).start();
    System.out.println("@dicaprioale | SERVER: Connessione instaurata");


  }
  
  public void closeStreams() throws IOException {
      in.close();
      out.close();
      return;
  }
  
  

  @Override
  public void run() {
    try {
      System.out.println("Classe ConnessioneClient: thread in esecuzione");
      while( true ) {
                                                                                  // LETTURA DEL COMANDO RICEVUTO
        comandoRicevuto = sIN.readLine();
        System.out.println("Comando ricevuto > " + comandoRicevuto );

                                                                                  // CONTROLLO SE IL COMANDO E' DI CHIUSURA
        if( comandoRicevuto.equalsIgnoreCase(Comando.QUIT)) {
          break;
        }
                                                                                  // INTERPRETAZIONE DEL COMANDO INSERITO
        risposta = Protocollo.interpretaComando( comandoRicevuto, server, this );
        sOUT.println( risposta );
        sOUT.flush();

      }

      
      System.out.println( "@dicaprioale | SERVER:  Il client si è disconnesso" );

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
