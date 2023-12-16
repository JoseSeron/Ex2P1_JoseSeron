package examen2p1_joseseron;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jose Seron
 */
public class Examen2P1_JoseSeron {

    /**
     * FOKIN EXAMEN 2 POR FIN TE QUIERO MEMITO
     *
     * Ubicacion Fila 2 Silla 8
     *
     *
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner(System.in);
    public static Scanner strinput = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        // TODO code application logic here

        /**
         *
         */

        //Personaje(String nombre, int HP, int MP, int DP, int ATK
        //Items(String nombre, int HPpoints, int MPpoints)
        Personaje Sora = new Personaje("Sora", 300, 300, 75, 15);
        Personaje Donald = new Personaje("Donald", 150, 450, 45, 10);
        Personaje Goofy = new Personaje("Goofy", 450, 100, 150, 50);
        Personaje Mickey = new Personaje("Mickey", 100, 500, 150, 35);
        Personaje Roxas = new Personaje("Roxas", 300, 300, 15, 75);
        Personaje Kairi = new Personaje("Kairi", 200, 200, 50, 15);
        Items Pocion = new Items("Pocion", 50, 0);
        Items Ether = new Items("Ether", 0, 50);
        Items Elixir = new Items("Elixir", 100, 100);

        ArrayList<Items> mochila = new ArrayList<>();
        ArrayList<Personaje> party = new ArrayList<>();
        ArrayList<Personaje> reservas = new ArrayList<>();

        //lista party comienza con sora donald y goofy
        party.add(Sora);
        party.add(Donald);
        party.add(Goofy);

        //lista reserva comienza con los otros personajes
        reservas.add(Mickey);
        reservas.add(Roxas);
        reservas.add(Kairi);

        //mochila debe empezar con uno de cada item
        mochila.add(Pocion);
        mochila.add(Ether);
        mochila.add(Elixir);

        int numeroCuartos = 20;
        int cuarto = 0;

        //for controla los cuartos o rondas
        for (int i = 0; i < numeroCuartos; i++) {
            cuarto++;
            System.out.println("Entraste en el cuarto " + cuarto + "\n");
            int quehayenelfokincuarto = random.nextInt(1, 6);

            switch (quehayenelfokincuarto) {
                case 1: // belico el asunto

                    int HPHeartless = 0;
                    int cuantosHeartless = random.nextInt(1, 4);
                    HPHeartless = 75 * cuantosHeartless;
                    int attackHeartless = 25;

                    System.out.println("\nTe encontraste " + cuantosHeartless + " Heartless");

                    while ((HPHeartless > 0) || (party.size() > 0)) {
                        
                        Personaje personajeelegido = personaje(party);
                        System.out.println("");
                        
//                        System.out.println(personajeelegido.toString());

                        int menu = menu();
                        switch (menu) {
                            case 1: //attack
                                System.out.println(personajeelegido.nombre+" ataco!");
                                System.out.println(personajeelegido.nombre+" recibio el golpe");
                                
                                
                                //reducir vida de los heartless por el attak de el personaje
                                HPHeartless=HPHeartless-personajeelegido.ATK;
                                
                                //recibir golpe de heartless
                                personajeelegido.setHP(personajeelegido.HP-((25*cuantosHeartless)*(personajeelegido.DP/100)));
                               
                                System.out.println("A los Heartless les queda: " +HPHeartless);
                                break;
                            case 2: //magic 
                                System.out.println("magic");
                                //imprimir el menu de magia y alterar esos datos 


                                int opcionmagic = menumagic();
                                switch (opcionmagic) {
                                    case 1:
                                        System.out.println(personajeelegido.nombre + " uso Blizzard");
                                        System.out.println(personajeelegido.nombre + " recibio el golpe");
                                        personajeelegido.setMP(personajeelegido.MP - 40);
                                        HPHeartless = HPHeartless - 50;
                                        personajeelegido.setHP(personajeelegido.HP - ((25 * cuantosHeartless) * (personajeelegido.DP / 100)));
                                        System.out.println("A los Heartless les queda: " + HPHeartless);
                                        break;
                                    case 2:
                                        System.out.println(personajeelegido.nombre + " uso Firaga");
                                        System.out.println(personajeelegido.nombre + " recibio el golpe");
                                        personajeelegido.setMP(personajeelegido.MP - 25);
                                        HPHeartless = HPHeartless - 25;
                                        //recibir golpe de heartless
                                        personajeelegido.setHP(personajeelegido.HP - ((25 * cuantosHeartless) * (personajeelegido.DP / 100)));
                                        System.out.println("A los Heartless les queda: " + HPHeartless);
                                        break;
                                    case 3:
                                        System.out.println(personajeelegido.nombre + " uso Gravity");
                                        System.out.println(personajeelegido.nombre + " recibio el golpe");
                                        personajeelegido.setMP(personajeelegido.MP - 75);
                                        HPHeartless = HPHeartless - 100;
                                        //recibir golpe de heartless
                                        personajeelegido.setHP(personajeelegido.HP - ((25 * cuantosHeartless) * (personajeelegido.DP / 100)));
                                        System.out.println("A los Heartless les queda: " + HPHeartless);
                                        break;
                                    default:
                                        throw new AssertionError();
                                }

                                break;

                            case 3: // items usar item
                                System.out.println("Elija que item desea usar:");
                                printMochila(mochila);
                                System.out.println("Ingrese el item que desea usar: ");
                                int usarItem = input.nextInt();

                                if (mochila.get(usarItem - 1).nombre.equalsIgnoreCase("pocion")) {
                                    personajeelegido.setHP(personajeelegido.HP + Pocion.getHPpoints());
                                    //recibir golpe de heartless
                                    personajeelegido.setHP(personajeelegido.HP - ((25 * cuantosHeartless) * (personajeelegido.DP / 100)));
                                    System.out.println(personajeelegido.nombre + " recibio el golpe");
                                    System.out.println("A los Heartless les queda: " + HPHeartless);
                                } else if (mochila.get(usarItem - 1).nombre.equalsIgnoreCase("Ether")) {
                                    personajeelegido.setMP(personajeelegido.getHP() + Ether.MPpoints);
                                    //recibir golpe de heartless
                                    personajeelegido.setHP(personajeelegido.HP - ((25 * cuantosHeartless) * (personajeelegido.DP / 100)));
                                    System.out.println(personajeelegido.nombre + " recibio el golpe");
                                    System.out.println("A los Heartless les queda: " + HPHeartless);
                                } else if (mochila.get(usarItem - 1).nombre.equalsIgnoreCase("Elixir")) {
                                    personajeelegido.setHP(personajeelegido.HP + Elixir.getHPpoints());
                                    personajeelegido.setMP(personajeelegido.getHP() + Elixir.MPpoints);
                                    //recibir golpe de heartless
                                    personajeelegido.setHP(personajeelegido.HP - ((25 * cuantosHeartless) * (personajeelegido.DP / 100)));
                                    System.out.println(personajeelegido.nombre + " recibio el golpe");
                                    System.out.println("A los Heartless les queda: " + HPHeartless);
                                }

                                mochila.remove(usarItem-1);
                                System.out.println("Ha usado: "+mochila.get(usarItem-1).getNombre());
                                
                                break;
                            case 4: //party cambiar personaje
                                
                                printParty(party);
                                System.out.println("Elija el personaje que quiere enviar a la reserva: ");
                                int personajeareserva = input.nextInt();
                                
                                
                                printParty(reservas);
                                System.out.println("Elija el personaje que quiere sacar a batallar: ");
                                int personajeaparty = input.nextInt();
                                
                                party.remove(personajeareserva-1);
                                party.add(reservas.get(personajeaparty-1));
                                reservas.remove(personajeaparty-1);
                                reservas.add(party.get(personajeareserva-1));
                                
                                break;
                            default:
                                throw new AssertionError();
                        }
                        
       
                    }
                    if (HPHeartless >= 0) {
                        System.out.println("Venciste a los Heartless!");

                    } else if (party.size() == 0) {
                        System.out.println("Los Heartless derrotaron a toda to party. Perdiste.");
                        break;
                        
                    }

                    
                    break;
                case 2: // cofre pocion
                    System.out.println("¡Enhorabuena! ¡Te encontraste una Pocion!");
                    mochila.add(Pocion);
                    printMochila(mochila);
                    break;
                case 3: // cofre ether
                    System.out.println("¡Enhorabuena! ¡Te encontraste un Ether!");
                    mochila.add(Ether);
                    printMochila(mochila);
                    break;
                case 4: // cogre elixir
                    System.out.println("¡Enhorabuena! ¡Te encontraste un Elixir!");
                    mochila.add(Elixir);
                    printMochila(mochila);
                    break;
                case 5: // amigos pobres quieren una inversion para emprender
                    System.out.println("Te encontraste amigos pobres");

                    if (mochila.size() == 0 || mochila.size() == 1) {
                        System.out.println("No tienes Items para regalar. Tus amigos ya no te aprecian.");
                    } else {

                        int cuantositemsvasaregalar = random.nextInt(1, mochila.size());

                        for (int j = 0; j < cuantositemsvasaregalar; j++) {
                            mochila.remove(0);
                        }

                        System.out.println("Les has regalado " + cuantositemsvasaregalar + " Items");
                        printMochila(mochila);
                    }

                    break;
                default:
                    throw new AssertionError();
            } // fin que hay en el fokin cuarto

            System.out.println("");

            if (cuarto == 20) {
                System.out.println("Saliste de la castillo. ¡Ganaste!");
            } else {
                System.out.println("Continuar al siguiente cuarto?");
                input.next();

                System.out.println("");
            }
        } // fin fokin for principal

    }

    public static void printMochila(ArrayList<Items> mochila) {

        System.out.println("\nITEMS: ");
        for (int i = 0; i < mochila.size(); i++) {
            System.out.println((i + 1) + ".- " + mochila.get(i).toString());
        }
    }
    
    


    public static void printParty(ArrayList<Personaje> party) {
        System.out.println("Party: ");
        for (int i = 0; i < party.size(); i++) {
            System.out.println((i + 1) + ".- " + party.get(i).toString());
        }
    }

    public static int menu() {

        System.out.println("Menu");
        System.out.println("1.- Attack");
        System.out.println("2.- Magic");
        System.out.println("3.- Items");
        System.out.println("4.- Party");
        int opcion;

        do {
            System.out.println("Ingrese la opcion que desea: ");
            opcion = strinput.next().charAt(0);
        } while (opcion < 49 || opcion > 53);

        if (opcion == 49) {
            opcion = 1;
        } else if (opcion == 50) {
            opcion = 2;
        } else if (opcion == 51) {
            opcion = 3;
        }else if (opcion == 52) {
            opcion = 4;
        }

        return opcion;
    }
    
    public static int menumagic() {

        System.out.println("Menu");
        System.out.println("1.- Blizzard   40MP  -  50DMG");
        System.out.println("2.- Firaga     25MP  -  25DMG");
        System.out.println("3.- Gravity    75MP  -  100DMG");

        int opcion;

        do {
            System.out.println("Ingrese la opcion que desea: ");
            opcion = strinput.next().charAt(0);
        } while (opcion < 49 || opcion > 51);

        if (opcion == 49) {
            opcion = 1;
        } else if (opcion == 50) {
            opcion = 2;
        } else if (opcion == 51) {
            opcion = 3;
        }

        return opcion;
    }

    public static Personaje personaje(ArrayList<Personaje> party) {
        System.out.println(1 + ".-" + party.get(0).toString()+"\n");
        System.out.println(2 + ".-" + party.get(1).toString()+"\n");
        System.out.println(2 + ".-" + party.get(2).toString()+"\n");

        int opcion;
        
        do {
            System.out.println("Elija un personaje: ");
            opcion = strinput.next().charAt(0);
        } while (opcion < 49 || opcion > 51);
        
        if (opcion==49) {
            opcion=1;
        }else if (opcion == 50 ) {
            opcion=2;
        }else if (opcion == 51) {
            opcion=3;
        }
        
        Personaje personaje = null;
        personaje = party.get(opcion-1);

        
        return personaje;
    }

}
