import java.util.Random;

public class Parole {
    String[] parole = {"anno", "giorno", "tempo", "uomo", "volta", "casa", "vita", "parte", "cosa", "donna"
            , "mondo", "lavoro", "ora", "mese,", "modo", "problema", "persona", "presidente",
            "punto", "paese", "caso", "storia", "momento", "figlio", "mano", "governo", "stato", "parola", "famiglia",
            "gruppo", "padre", "occhio", "lira", "strada", "bambino", "ragazzo", "posto", "amico", "legge", "film",
            "fatto", "sera", "ministro", "numero", "nome", "partito", "amore", "notte", "centro", "acqua", "sistema",
            "rapporto", "madre", "conto", "idea", "gente", "settimana", "forza", "fine", "voce", "capo", "libro",
            "consiglio", "situazione", "campo", "piano", "moglie", "testa", "guerra", "gioco", "squadra", "servizio",
            "terra", "ragazza", "minuto", "risultato", "senso", "corpo", "tipo", "bisogno", "programma", "scuola",
            "zona", "mercato", "morte", "automobile", "immagine", "ragione", "aria", "successo", "forma", "politica",
            "risposta", "metro", "porta", "marito", "giovane", "studio", "direttore", "opera", "luce", "colpo", "scelta",
            "condizione", "luogo", "sindaco", "serie", "piede", "ufficio", "polizia", "paura", "giudice", "interesse",
            "crisi", "spazio", "camera", "ordine", "periodo", "macchina", "intervento", "domanda", "progetto", "titolo",
            "ruolo", "cuore", "potere", "diritto", "incontro", "ricerca", "valore", "linea", "mattina",
            "prova", "personaggio", "genitore", "lettera", "mare", "pagina", "scena", "signore", "controllo",
            "arte", "passo", "passato", "colore", "azione", "giornata", "fondo", "prezzo", "signora"};

    public String randomWord(){
        int index = new Random().nextInt(parole.length);
        return parole[index];
    }
}
