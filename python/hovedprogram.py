from verden import Verden
from rutenett import Rutenett

def hovedprogram():
    rader=int(input('hvor mange rader skal spillbrettet ha? '))
    kolonner=int(input('hvor mange kolonner skal spillbrettet ha? '))
    verden=Verden(rader, kolonner)
    fortsette=input('skriv q eller enter')
    while fortsette !='q':
        verden.oppdatering()
        verden.tegn()
        print(f'generasjonsnummer: {verden.oppdatering()} - antall levende celler: {verden.tegn()}')
        fortsette=input('skriv q eller enter')



        

        

# starte hovedprogrammet
hovedprogram()