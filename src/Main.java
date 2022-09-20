
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] hoelzer = new int[] { 1, 3, 5, 7 };
        int spieler = 1;

        do
        {
            ausgabe(hoelzer);
            werIstDran(spieler);
            zugMachen(hoelzer);
            spielerWechseln(spieler);

        } while (!habeGewinner(hoelzer));

        gewinnerAnzeigen(spieler);
    }

    public static void werIstDran(int spieler)
    {
        System.out.println();

        System.out.println("Spieler " + spieler + " ist am Zug");
        spieler = +1;
    }

    public static void ausgabe(int[] hoelzer)
    {

        System.out.println("---------------------------------------------");

        int anzahlHaufen = hoelzer.length;

        for (int i = 0; i < anzahlHaufen; i++)
        {
            System.out.println("Haufen: " + (i + 1) + "...");
            for (int j = 0; j < ((2 * anzahlHaufen) - hoelzer[i]) / 2; j++)
            {
                System.out.print(" ");
            }

            for (int j = 0; j < hoelzer[i]; j++)
            {
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static boolean eingabeIsOk(int[] hoelzer, int haufen, int anzahl)
    {
        int anzahlHaufen = hoelzer.length;

        if (haufen > anzahlHaufen || haufen < 0) return false;
        if (anzahl > 3 || anzahl < 1) return false;
        if (hoelzer[haufen - 1] < anzahl) return false;

        return true;
    }

    public static void zugMachen(int[] hoelzer)
    {
        int haufen = 0;
        int anzahl = 0;
        boolean userInputIsOk = false;

        do
        {
            System.out.println("Streichhoelzer von welchem Haufen entfernen? ");

            boolean inputOk = false;

            do
            {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();

                try {
                    haufen = Integer.parseInt(input);
                    inputOk = true;
                }
                catch(Exception ex)
                {
                    System.out.println("Ungueltige Eingabe. Bitte nur Zahlen eingeben!");
                    System.out.println("Streichhoelzer von welchem Haufen entfernen? ");
                    ex.printStackTrace();
                    inputOk = false;
                }
            } while (!inputOk);

            System.out.println("Wieviele Hoelzer entfernen? ");

            inputOk = false;
            do
            {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                try {
                    anzahl = Integer.parseInt(input);
                    inputOk = true;
                }
                catch (Exception ex)
                {
                    System.out.println("Ungueltige Eingabe. Bitte nur Zahen eingeben!");
                    System.out.println("Wieviele Hoelzer entfernen? ");
                    ex.printStackTrace();
                    inputOk = false;
                }
            } while (!inputOk);

            userInputIsOk = eingabeIsOk(hoelzer, haufen, anzahl);

            if (userInputIsOk)
            {
                hoelzer[haufen - 1] -= anzahl;
            }
            else
            {
                System.out.println("Ungueltige Eingabe!");
            }

        } while (!userInputIsOk);
    }

    public static void spielerWechseln(int spieler)
    {
        spieler = (spieler == 1 ? 2 : 1);
    }

    public static void gewinnerAnzeigen(int Spieler)
    {
        System.out.println();

        switch (Spieler)
        {
            case 1:
                System.out.println("Spieler 1 gewinnt!");
                break;

            default:
                System.out.println("Spieler 2 gewinnt");
                break;
        }
        System.out.println();
    }

    public static boolean habeGewinner(int[] hoelzer)
    {
        for (int i = 0; i < hoelzer.length; i++)
        {
            if (hoelzer[i] > 0) return false;
        }
        return true;
    }

    // Hallo test
}
