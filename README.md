# MediCare
Repository contenente il progetto realizzato durante il corso di "Ingegneria del software" tenuto dal Prof. Carmine Gravino presso l'Università degli studi di Salerno

## Chi siamo
- [@astappetto02](https://github.com/Astappetto02)
- [@gfavale1](https://github.com/gfavale1)
- [@gi0NZ](https://github.com/Gi0NZ)
- [@gisolfi02](https://github.com/gisolfi02)

# Cos'è MediCare?
MediCare è stato concepito e sviluppato con l'obiettivo principale di migliorare l'esperienza nel settore sanitario, cercando di risolvere le inefficienze e migliorare l'accessibilità e l'intuitività per utenti di tutte le età. L'idea è di avvicinare i giovani al contesto medico, coinvolgendo allo stesso tempo anche gli adulti, incentivandone la consapevolezza della propria salute e delle risorse disponibili negli ospedali.

## Contenuto dell'applicazione
MediCare consente agli utenti di poter effettuare la registrazione all'aplicazione e successivamente il Login. Prevede poi le possibilità di:
- Prenotazione di una visita medica presso un medico specializzato
- Ricerca di ospedali tramite Google Maps e tramite inserimento della località
- Utilizzo di un chatbot per poter avere una prima diagnosi non ufficiale sulla possibile malattia dell'utente
- Visualizzare lo storico delle prenotazioni effettuate
- Visualizzare le informazioni relative alle prenotazioni effettuate
- Modificare prenotazioni ancora in corso
- Eliminare prenotazioni ancora in corso
- Eliminare l'account

# Come iniziare
## Requisiti
I requisiti necessari all'avvio dell'applicazione sono:
- IDE (consigliamo [Intellij IDEA](https://www.jetbrains.com/idea/))
- MySQL WorkBench
- MySQL
## Configurazione
Per poter utilizzare l'applicazione MediCare, il primo passo da eseguire è quello di clonare la repository sul proprio IDE, con il comando:
```bash
git clone https://github.com/gisolfi02/MediCare.git
```
Una volta clonata la repository, modificare nella classe "ConPool" il collegamento al database, inserendo come password la propria password di SQL. Successivamente, aprire SQLWorkBench e creare il database copiando il file contenuto nella directory Database della repository.
## Avvio
Una volta eseguiti tutti i passaggi sopra riportati avviare il file "Main" dal vostro IDE.
