


class Celle {
    boolean levende;
    int antLevendeNaboer;
    int antNaboer;
    Celle[] naboer;

    //oppretter  ny celle
    public Celle(){             
        levende=false;
        naboer=new Celle[8];
        antLevendeNaboer=0;
    }

    //setter status til død
    public void settDød(){
        levende=false;
    }

    //setter status til levende
    public void settLevende(){
        levende=true;
    }

    public boolean erLevende(){
        if (levende){
            return true;
        }
        else {return false;}
    }

    
    public char hentStatusTegn(){
        if(erLevende()){
            return 'O';
        }
        else{return '.';}
    }

    public void leggTilNabo(Celle nabo){
        if (antNaboer < 8){
        naboer[antNaboer]=nabo;}
        antNaboer++;
    }

    //sjekker om naboen til cellen er levende, og legge til antall levende naboer
    public void tellLevendeNaboer(){
        antLevendeNaboer=0;
        for(Celle nabo : naboer){
            if (nabo != null && nabo.erLevende()){
            antLevendeNaboer= antLevendeNaboer+1;
            }
        }
    }

    //oppdaterer statusen til cellen ut ifra spillreglene 
    public void oppdaterStatus(){
        if (erLevende()){
            if (antLevendeNaboer == 2 || antLevendeNaboer == 3){
                settLevende();
            }  else {settDød();}
        } else {
            if (antLevendeNaboer == 3){
                settLevende();
            } else {settDød();}
        }

    }


}
