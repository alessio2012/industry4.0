/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package industry40_swing_client;

import java.net.Socket;

/**
 *
 * @author Ale
 */
public class checkConnection implements Runnable {
    private Socket connessione;
    
    public void checkConnection( Socket connection ) {
        connessione = connection;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        while( true ) {
           System.out.println( connessione.isConnected() );
        }
        
    }
    
}
