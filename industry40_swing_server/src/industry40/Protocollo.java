package industry40;
                                                                                        /* IMPORTAZIONE LIBRERIE */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import industry40.Comando;


public class Protocollo {
  protected static String interpretaComando(String comando, ServerPuntiDiVerifica server, ConnessioneClient client) {
    String output = "";

                                                                                            /* COMANDO : "LIST" */
    if (Comando.LIST.equalsIgnoreCase(comando)) {
      System.out.println("@dicaprioale | AZIONE: Il client ha eseguito il comando LIST" );

      System.out.println("" );
      for (PuntoDiVerifica pdv : server.elenco_pdv) {
        output += pdv.nome + ";";
      }
                                                                                            /* COMANDO : "ADD" */
    } else if (comando.indexOf(Comando.ADD) == 0) {
      System.out.println("@dicaprioale | AZIONE: Il client ha eseguito il comando ADD" );
      String nomePdv = comando.substring(Comando.ADD.length() + 1);                         // ACQUISIZIONE DEL NOME DEL NUOVO PUNTO DI VERIFICA DA GGIUNGERE
      boolean duplicato = false;
                                                                                            // SCORRIMENTO DI TUTTI I PUNTI PER INDIVIDUARE EVENTUALI DUPLICATI
      for (PuntoDiVerifica pdv : server.elenco_pdv) {
        if (pdv.nome.equals(nomePdv)) {                                                     // INDIVIDUAZIONE DI UN DUPLICATO ED USCITA DAL CICLO
          duplicato = true;
          break;
        }
      }

      if (!duplicato) {
        PuntoDiVerifica pdv = new PuntoDiVerifica();                                         // DUPLICATO INESISTENTE, CREAZIONE DI UN NUOVO PUNTO DI VERIFICA
        pdv.nome = nomePdv;
        pdv.eventi = new ArrayList<Evento>();
        server.elenco_pdv.add(pdv);
        output = nomePdv + " AGGIUNTO CON SUCCESSO";
        System.out.println("@dicaprioale | AZIONE: Un nuovo punto di verifica e' stato appena aggiunto" );
      } else {
        output = nomePdv + " E' GIA' PRESENTE NELLA LISTA";
      }
    }
                                                                                              /* COMANDO : "LOGIN" */
    else if (comando.indexOf(Comando.LOGIN) == 0) {
      System.out.println("@dicaprioale | AZIONE: Il client ha eseguito il comando LOGIN" );
      String nomePdv = comando.substring(Comando.ADD.length() + 3);                            // ACQUISIZIONE DEL NOME UTENTE CON CUI ACCEDERE ED AGGIUNGERE UN NUOVO EVENTO
      // System.out.println( nomePdv );
      boolean trovato = false;
                                                                                                // SCORRIMENTO DELLA LISTA ED INDIVIDUAZIONE DEL PUNTO DI VERIFICA A CUI AGGIUNGERE L-EVENTO
      for (PuntoDiVerifica pdv : server.elenco_pdv) {
        //System.out.println( pdv.nome );
                                                                                                // PUNTI DI VERIFICA INDIVIDUATO
        if (pdv.nome.equals(nomePdv)) {
          trovato = true;
          client.puntoDiVerifica = pdv;
          break;
        }

        if (trovato) {
          System.out.println("@dicaprioale | AZIONE: Il client ha fatto l'accesso sul profilo " + nomePdv );
          output = nomePdv + " LOGIN AVVENUTO CON SUCCESSO"; // LOG IN
        } else {
          output = nomePdv + " UTENTE INESISTENTE"; // ERROR LOG OUT
        }

      }

                                                                                                  /* COMANDO : "EVENT" */
    } else if (comando.indexOf(Comando.EVENT) == 0) {
      System.out.println("@dicaprioale | AZIONE: Il client ha eseguito il comando EVENT" );
      System.out.println( client.puntoDiVerifica );
                                                                                                  // contyrollo che IL CLIENT ABBIA EFFETTUATO L'ACCESSO SUL PROFILO DELLA LINEA
      if (client.puntoDiVerifica == null) {
        output = "@dicaprioale | SERVER: Errore!!! Per favore effettua l'accesso"; // stampa di cortesia
      } else {

        String dataEvento = comando.substring(Comando.EVENT.length() + 1, Comando.EVENT.length() + 10 ); // ACQUISIZIONE DELLE STRINGHE DI DATA E STATO DELLA LINEA
        String stato = comando.substring( Comando.EVENT.length() + 10 );
        System.out.println( dataEvento );
        System.out.println( stato );
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy"); // formattazione della data

        try {
          Date data = formattedDate.parse( dataEvento );
          Evento e = new Evento();
          e.dataOraEvento = data; // acquisizione della data
          e.stato = stato;
          client.puntoDiVerifica.eventi.add( e ); // definizione del nuovo evento
          System.out.println("@dicaprioale | AZIONE: Il client ha aggiunto un nuovo evento" );
          System.out.println("AZIONE: Evento:" + stato );
          System.out.println("AZIONE: Data:" + data );
          System.out.println("AZIONE: Pdv:" + client.puntoDiVerifica );

          output = " Evento aggiunto"; // stampa di cortesia
        } catch (ParseException e) {
          e.printStackTrace();
          output = " Data evento non riconosciuta"; // errore nella data
        }
      }
                                                                                                        /* COMANDO PER LA STAMPA DELLA CRONOLOGIA DELLA LINEA D-EVENTO */
    } else if (comando.indexOf(Comando.CRON) == 0) {
      if (client.puntoDiVerifica == null) {
        output = "@dicaprioale | SERVER: Errore!!! Per favore, accedi";
      } else {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy"); // formattazione della data
        for( Evento e: client.puntoDiVerifica.eventi ) {   // aggiornamento dell'evento
          output += formattedDate.format( e.dataOraEvento ) + "#" + e.stato + ";";
        }
      }
    }

    else if (comando.indexOf(Comando.HELP) == 0) {
      System.out.println("@dicaprioale | AZIONE: Il client ha eseguito il comando HELP" );
      output = "> HELP; CRONO; ADD; LOGIN [ PDV ]*; EVENT [ data ] [ status ]*; LIST";
    }

    return output;
  }
}