# 🚗 Scrapyard System – Object-Oriented Programming

Et Java-basert program utviklet som eksamensprosjekt i objektorientert programmering.  
Programmet leser data fra fil og lagrer informasjon om kjøretøy i en MySQL-database.

---

## Funksjonalitet

- Leser kjøretøydata fra fil
- Lagrer data i MySQL-database via JDBC
- Håndterer ulike typer kjøretøy:
  - ElectricCar
  - FossilCar
  - Motorcycle
- Strukturert med objektorienterte prinsipper

---

## Teknologier

- Java
- JDBC
- MySQL

---

## Objektorienterte prinsipper

### Innkapsling
- Bruk av private variabler
- Gettere og settere for kontrollert tilgang til data
- Beskytter objektenes tilstand

### Arv
- Abstrakt superklasse: `Vehicle`
- Subklasser:
  - `ElectricCar`
  - `FossilCar`
  - `Motorcycle`
- Felles egenskaper gjenbrukes for å unngå duplisering

### Polymorfisme
- Bruk av `List<Vehicle>` for å håndtere flere typer objekter
- Gir fleksibel og skalerbar kode

---

## Hva jeg har lært

Gjennom dette prosjektet har jeg lært:

- Hvordan bruke objektorienterte prinsipper i praksis
- Strukturering av kode med arv og abstrakte klasser
- Bruk av JDBC for å koble Java til database
- Hvordan lese og håndtere data fra filer
- Hvordan organisere større programmer på en ryddig måte

---

## Min løsning

- Implementerte en tydelig klasse-struktur med arv
- Brukte DAO (Data Access Object) for databasehåndtering
- Sikret god separasjon mellom data og logikk

---

## Utfordringer

- Problemer med å håndtere sletting av data i databasen
- Løsningen ble å resette databasen manuelt mellom kjøringer
- Lærte viktigheten av kontrollert databaseflyt

---

## Om prosjektet

Dette prosjektet ble utviklet som en del av eksamen i objektorientert programmering.  
Fokuset var å demonstrere forståelse av OOP-prinsipper og databaseintegrasjon.

---
