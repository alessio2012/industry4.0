/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package industry40_swing_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Ale
 */
public class Industry40_swing_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket connessione = null;
        String server = "localhost";
        int port = 49151;
        InputStreamReader input, in;
        BufferedReader sIN, inTastiera;
        OutputStream out;
        PrintWriter sOUT;

        String comandoInviare;
        String rispostaRicevuta;

        try {
          connessione = new Socket( server, port );
          System.out.println( "@dicaprioale | CLIENT: Connesso al server" );
          System.out.println("Indirizzo: " + server + ":" + port );
          System.out.println("Connessione: " + connessione + "\n" );



        } catch (UnknownHostException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }

        try {
          in = new InputStreamReader( connessione.getInputStream() );
          sIN = new BufferedReader( in );

          out = connessione.getOutputStream();
          sOUT = new PrintWriter( out );

          input = new InputStreamReader( System.in );
          inTastiera = new BufferedReader( input );
          System.out.println( "@dicaprioale | CLIENT: Inizializzazione completata" );

          while( true ) {
            System.out.println( "@dicaprioale | CLIENT: Immettere un comando [ Quit per uscire ]" );
            comandoInviare = inTastiera.readLine();

            sOUT.println( comandoInviare );
            sOUT.flush();

            rispostaRicevuta = sIN.readLine();
            System.out.println( "@dicaprioale | CLIENT:  " + rispostaRicevuta );

            if( comandoInviare.equalsIgnoreCase("QUIT") ) {
              break;
            }
          }

          connessione.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
}
