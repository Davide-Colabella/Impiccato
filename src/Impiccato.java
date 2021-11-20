import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Impiccato {

    public static Parole listaParole = new Parole();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        gioco();
        boolean result = true;
        do {
            System.out.println("Vuoi continuare il gioco? [S/N]");
            input = in.nextLine().toUpperCase();
            switch (input) {
                case "N" -> {
                    System.exit(0);
                }
                case "Y" -> {
                    gioco();
                }
                default -> {
                    System.out.println("Input non valido.");
                    result = false;
                }
            }
        } while (!result);

    }

    public static void gioco() {
        String parola = listaParole.randomWord().toLowerCase();
        int tentativi = 6;
        String input;
        char[] parolaVuota = new char[parola.length()];
        ArrayList<Character> lettereIndovinate = new ArrayList<Character>();
        ArrayList<Character> lettereSbagliate = new ArrayList<Character>();
        ArrayList<String> paroleProvate = new ArrayList<>();
        boolean indovinata = false;
        for (int i = 0; i < parola.length(); i++) {
            parolaVuota[i] = '_';
        }
        System.out.println("Giochiamo all'impiccato.");
        while (!indovinata && tentativi > 0) {
            System.out.println("Tentativi rimasti: " + tentativi);
            System.out.println(stampa_impiccato(tentativi));
            System.out.println(parolaVuota);
            System.out.println("Lettere sbagliate: " + lettereSbagliate + " || Parole sbagliate: " + paroleProvate);
            System.out.println("Inserisci una lettera oppure una parola: ");
            input = in.nextLine().trim().toLowerCase();
            if (input.contains("[0-9]+")) {
                System.out.println("Carattere non valido.");
            } else if (input.length() == 1) {
                char inputChar = input.charAt(0);
                if (lettereSbagliate.contains(inputChar))  //metto questo prima anziché l'else if perché se giò immessa riscrive lettera presente nella parola
                    System.out.println("Lettera già indovinata.");
                else if (parola.contains(input)) {
                    System.out.println("Lettera presente nella parola.");
                    lettereIndovinate.add(inputChar);
                    int[] indexes = new int[parola.length()];
                    int counter = 0;
                    int idx = parola.indexOf(input), j = 0;
                    while (idx >= 0) {
                        indexes[j] = idx;
                        idx = parola.indexOf(input, idx + 1);
                        counter++;
                        j++;
                        if (idx == -1)
                            break;
                    }
                    for (int i = 0; i < counter; i++) {
                        parolaVuota[indexes[i]] = inputChar;
                    }
                    if (parola.equals(new String(parolaVuota))) {
                        System.out.println("Parola indovinata.");
                        indovinata = true;
                    }
                } else {
                    System.out.println("Lettera non presente nella parola.");
                    lettereSbagliate.add(inputChar);
                    tentativi--;
                }
            } else {
                if (paroleProvate.contains(input))
                    System.out.println("Hai già provato questa parola.");
                else if (input.equals(parola)) {
                    System.out.println("Hai indovinato la parola.");
                    indovinata = true;
                } else {
                    System.out.println("Parola sbagliata.");
                    paroleProvate.add(input);
                    tentativi--;
                }
            }
        }
        if (tentativi == 0)
            System.out.println("Hai esaurito i tentativi, la parola era: " + parola);
    }

    public static String stampa_impiccato(int tentativi) {
        String[] stages = {
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / \\
                   -
                """,

                """
                           --------
                           |      |
                           |      O
                           |     \\|/
                           |      |
                           |     / 
                           -
                        """,

                """
                           --------
                           |      |
                           |      O
                           |     \\|/
                           |      |
                           |      
                           -
                        """,

                """
                           --------
                           |      |
                           |      O
                           |     \\|
                           |      |
                           |     
                           -
                        """,

                """
                           --------
                           |      |
                           |      O
                           |      |
                           |      |
                           |     
                           -
                        """,

                """
                           --------
                           |      |
                           |      O
                           |    
                           |      
                           |     
                           -
                        """,

                """
                           --------
                           |      |
                           |      
                           |    
                           |      
                           |     
                           -
                        """
        };
        return stages[tentativi];
    }

}
