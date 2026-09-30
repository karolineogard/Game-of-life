from random import randint
from celle import Celle

class Rutenett:
    def __init__(self, rader, kolonner):
        self._ant_rader=rader
        self._ant_kolonner=kolonner
        self._rutenett=self._lag_tomt_rutenett()

    def _lag_tomt_rutenett(self):
        tomt_rutenett=[]
        for i in range(self._ant_rader):
            tomt_rutenett.append(self._lag_tom_rad())
        return tomt_rutenett


    def _lag_tom_rad(self):
        tom_rad=[]
        for i in range(self._ant_kolonner):
            tom_rad.append(None)
        return tom_rad


    def fyll_med_tilfeldige_celler(self):
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                celle=self.lag_celle(rad, kol)
                # self._rutenett[rad][kol] = celle
                
                # tall=randint(1,3)
                # if tall == 1:
                #     celle.sett_levende()
                # else:
                #     celle.sett_doed()

    def lag_celle(self, rad, kol):
        celle=Celle()
        self._rutenett[rad][kol] = celle
                
        tall=randint(1,3)
        if tall == 1:
            celle.sett_levende()
        else:
            celle.sett_doed()


    def hent_celle(self, rad, kol):
        if rad < 0 or rad>=self._ant_rader:
            return None
        if kol < 0 or kol>=self._ant_kolonner:
            return None
        return self._rutenett[rad][kol]
            

    def tegn_rutenett(self):
        for rad in self._rutenett:
            for kol in rad:
                print(kol.hent_status_tegn(), end='')
            print()


    def _sett_naboer(self, rad, kol):

        naboer=[]  
        for i in range(rad-1,rad+2):
            for j in range(kol-1,kol+2):
                nabo=self.hent_celle(i, j)
                if i == rad and j == kol:
                    nabo=None
                if nabo is not None:
                    naboer.append(nabo)             
    
        celle = self.hent_celle(rad, kol)                  
    
        for nabo in naboer:
            celle.legg_til_nabo(nabo)
                
    def koble_celler(self):
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                self._sett_naboer(rad, kol)
        return self._rutenett

    def hent_alle_celler(self):
        self._alle_celler=[]
        for rad in self._rutenett:
            for celle in rad:
                self._alle_celler.append(celle)
        return self._alle_celler

    def antall_levende(self):
        teller=0
        for i in self.hent_alle_celler():
            if i.er_levende() is True:
                teller+=1
        return teller

