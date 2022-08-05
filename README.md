#PROGETTO FILM#

##Gestione model
-All'interno della classe Film ho inserito un campo id, questo è stato fatto in modo da rendere più agevole una 
futura implementazione (ad esempio se dobbiamo creare una classe regista e procedere con una relazione manyToMany)
-La proprietà boxOfficeReceipts viene trattata come una stringa e non come un double in quanto la traccia prevede
che esso venga criptato, e il metodo BCrypt restituisce un oggetto di tipo stringa

##Gestione Dao
-la traccia che ci e stata data prevedeva un solo metodo per la ricerca del film tramite il regista (producer),
 per fare esercizio ho voluto implementare anche i metodi per il delete e l'update del film
 
 Per quanto riguarda la gestione della ricerca tramite regista ho gestito la gestione del case sensitive facendo sì
 che sia il nome del regista impostato quando inserima un film sia il nome che usiamo per la ricerca siano trasformati
 in lowercase. 
 
 per separare il nome e il cognome del regista sulla barra Url basta inserire il carattere speciale %20
 es: http:localhost:8080/BE_ProgettoSettimana09-0.0.1-SNAPSHOT/film/findbyregista/mel%20brooks
 
 di seguito riporto gli indirizzi per i servizi rest
** inserimento nuovo film **
http:localhost:8080/BE_ProgettoSettimana09-0.0.1-SNAPSHOT/film/insert

** Ricerca film per regista **
http:localhost:8080/BE_ProgettoSettimana09-0.0.1-SNAPSHOT/film/findbyregista/{producer}

** eliminazione di un film **
http:localhost:8080/BE_ProgettoSettimana09-0.0.1-SNAPSHOT/film/delete/{id}

** modifica di un film **
http:localhost:8080/BE_ProgettoSettimana09-0.0.1-SNAPSHOT/film/update/{id}

** lista completa di tutti i film nel db **
http:localhost:8080/BE_ProgettoSettimana09-0.0.1-SNAPSHOT/film/getallfilms
