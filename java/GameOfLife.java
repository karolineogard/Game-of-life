

public class GameOfLife {
    int antGen;

    //lager en ny verden og en for-løkke som kjører programmet tre ganger
    public static void main (String[]args){
        int antGen=3;
        Verden verden = new Verden(8,12);
        for(int i=0; i<=antGen; i++){
            verden.tegn();
            verden.oppdatering();
        }


    }
    
}
