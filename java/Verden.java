

public class Verden {
    int antRader;
    int antKolonner;
    Rutenett rutenett;
    int genNr;


    public Verden(int rad, int kol){
        rutenett = new Rutenett(rad, kol);
        antRader=rad;
        antKolonner=kol;
        genNr=0;
        //fyller et rutenett med tilfeldige celler og koblere de sammen
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();

    }

    //tegner rutenettet, og printer levende naboer og generasjonsnummer
    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Generasjonsnummer: " + genNr);
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
    }

        
    public void oppdatering(){
        for(int i = 0; i<antRader; i++){
            for (int j =0; j<antKolonner; j++){
                Celle celle=rutenett.hentCelle(i,j);        //bruker dobbel for-løkke for å gå gjennom og hente hver celle i rutenettet
                if (celle != null){
                rutenett.settNaboer(i, j);  
                celle.tellLevendeNaboer();//teller levende naboer til cellen
                }
  
            }
        }
        //oppdaterer statusen til cellen basert på levende naboer
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                Celle celle = rutenett.hentCelle(i,j);
                if (celle != null) {
                    celle.oppdaterStatus();}
            }
   
        }

        genNr++;        //øker generasjonsnummer
    }
}
