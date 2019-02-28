# finanzservice

Beispiel eines RESTful-Webservices für den Finanzservice.

## Tests 

Nutzen Sie ein Browser-Addon wie beispielsweise RESTer, um REST-Anfragen an Ihren Service abzusetzen wie zum Beispiel:

* `POST` `http://localhost:8081/konto`
* `POST` `http://localhost:8081/transaktion`
* `GET` `http://localhost:8081/konto/4800`
* `GET` `http://localhost:8081/transaktion/850e9830-9be2-a716-09d4-987152009823`

### Beispiele für zu übermittelnde JSON-Objekte:

#### Konto
````json
{
    "kontoNr" : 4800,
    "bezeichnung" : "Mehrwertsteuer",
    "stand" : 100
}
````

````json
{
    "kontoNr" : 5001,
    "bezeichnung" : "Umsatzerlöse",
    "stand" : 100
}
````

````json
{
    "kontoNr" : 24000000000001,
    "bezeichnung" : "Fordungen aus Lieferungen und Leistungen (Fa. Schenker)",
    "stand" : 100
}
````

````json
{
    "kontoNr" : 44000000000001,
    "bezeichnung" : "Verbindlichkeiten (Betreiber Xyz)",
    "stand" : 100
}
````

#### Transaktion
````json
{
    "text" : "Maut-Rechnung Nr. 280976 vom 28.02.2019",
    "buchungspositionen" : 
    [
        {
            "buchungsNr" : 1,
            "kontoNr" : 5001,
            "betrag" : 1000
        },
        {
            "buchungsNr" : 2,
            "kontoNr" : 44000000000001,
            "betrag" : 9000
        },
        {
            "buchungsNr" : 3,
            "kontoNr" : 4800,
            "betrag" : 1900
        },
        {
            "buchungsNr" : 4,
            "kontoNr"  : 24000000000001,
            "betrag" : -11900
        }
    ]
}
````


