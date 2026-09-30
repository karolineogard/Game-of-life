


public class Rutenett {
    int antRader;
    int antKolonner;
    Celle [][]rutene;

    //lager et nytt rutenett, lar konstruktøren si hvor mange rader og kolonner
    public Rutenett(int r, int k){
        antRader=r;
        antKolonner=k;

        rutene = new Celle[r][k];
    }

    //putter en celle inn i en plass i rutenettet
    public void lagCelle(int rad, int kol){
        Celle celle = new Celle();
        
        if (Math.random() <=0.3333){    //gjør at det er en tredjedels sjanse for at cellen er levende
            celle.settLevende();
        }

        rutene [rad][kol]=celle;
    }

    //fyller hele rutenettet med tilfeldige celler
    public void fyllMedTilfeldigeCeller(){
        for(int i = 0; i<antRader; i++){
            for(int j = 0; j<antKolonner; j++){
                lagCelle(i,j);
            }
        }
    }

    //henter ut en celle på den spesifikke plassen i rutenettet som blir skrevet inn
    public Celle  hentCelle(int rad, int kol){
        for (int i = 0; i<antRader; i ++) {
            for (int j = 0; j<antRader; j ++){
                if ( i == rad && j == kol){
                    return rutene[rad][kol];
                }
            }
        }
        return null;}

        //tegner rutenettet med . og 0 utifra om cellene er død eller levende
    public void tegnRutenett(){
        for(int i = 0; i<antRader; i++){
            for(int j = 0; j<antKolonner; j++){
                System.out.print(rutene[i][j].hentStatusTegn());    
            }
        System.out.println();
        }

    }


    public void settNaboer(int rad, int kol){
        Celle celle = hentCelle(rad, kol);
        if (celle==null) return;    //avslutter om det ikke er en celle på plassen i rutenettet som bir oppgitt

        int indeks  = 0;
        Celle []naboer = new Celle [8];

        //går gjennom naboposisjonene til cellen 
        for ( int i = rad - 1; i<=rad+1; i++){
            for ( int j = kol -1; j<= kol+1; j++){
                //sjekker om posisjonen til naboen er utenfor grensene og unngår å legeg til seg selv som nabo
                if ( i>= 0 && i<antRader && j>=0 && j<antKolonner && !(i==rad && j ==kol)){
                    naboer[indeks++]=hentCelle(i,j);
   
                }
         }}
         //legger til ny naboene i listen
         for (int i = 0; i < indeks; i++) {
                celle.leggTilNabo(naboer[i]);}}

  
        
            //setter sammen naboene i hele rutenettet 
    public void kobleAlleCeller(){
        for (int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                settNaboer(i, j);
            }
        }
    }

    //bruker dobbel for-løkke for å gå gjennom alle plassene i rutenettet og ser om cellen er levende
    public int antallLevende(){
        int antallLevende=0;
        for (int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                Celle celle=rutene[i][j];
                if(celle.erLevende()){
                    antallLevende=antallLevende+1;          //øker antall levende hvis celler er levende
                }
            }
        
        
    }
    return antallLevende;
}

    
}
    

