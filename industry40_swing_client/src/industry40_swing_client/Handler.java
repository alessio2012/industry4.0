/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package industry40_swing_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ale
 */
public class Handler implements Runnable {
    private BufferedReader sIN;
    private PrintWriter sOUT;
    private Thread executer;
    
    
    public void commandHandle( BufferedReader serverInput, PrintWriter serverOutput ) {
        sIN = serverInput;
        sOUT = serverOutput;
        executer = new Thread( this );
        executer.start();
    }
    
    public String sendCommand( String command ) {
        String rispostaRicevuta = null;
        
        System.out.println("Ho letto questo comando: " + command );
        sOUT.println( command );
        sOUT.flush();
        System.out.println("Ho inviato il comando " + command );

        try {
            System.out.println("Ho ricevuto questa risposta " + rispostaRicevuta );
            rispostaRicevuta = sIN.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rispostaRicevuta;
    }
    
    @Override
    public void run() {
        System.out.println( "@dicaprioale | CLIENT: Immettere un comando [ Quit per uscire ]" );
    }
    
}


