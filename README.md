# Projecte de Programació en Java

## Descripció
Aquest projecte conté diversos exercicis de programació en Java. Utilitza Eclipse o IntelliJ per desenvolupar-los.

Segueix el document de bones pràctiques detallat a l'Sprint 0 per complir les normes en les entregues dels repositoris de GitHub. Pots construir projectes amb Maven, Gradle o només amb Java. El codi ha d'estar escrit en anglès.

---

## Exercicis

### Nivell 1

#### Exercici 1: Classe Producte i Venda
Crea una classe `Producte` amb els atributs:
- `nom` (String)
- `preu` (double)

Crea també una classe `Venda` amb els atributs:
- Col·lecció de productes
- Preu total de la venda

Afegeix un mètode `calcularTotal()` que llança una excepció personalitzada `VendaBuidaException` si la col·lecció de productes està buida. Si té productes, calcula la suma dels preus i l'assigna al preu total.

Crea i captura una excepció `IndexOutOfBoundsException`.

---

### Nivell 2

#### Exercici 1: Classe Entrada
Crea una classe `Entrada` per gestionar excepcions en l'entrada de dades per teclat amb `Scanner`.

**Mètodes per gestionar `InputMismatchException`:**
- `public static byte llegirByte(String missatge);`
- `public static int llegirInt(String missatge);`
- `public static float llegirFloat(String missatge);`
- `public static double llegirDouble(String missatge);`

**Mètodes amb excepcions personalitzades:**
- `public static char llegirChar(String missatge);`
- `public static String llegirString(String missatge);`
- `public static boolean llegirSiNo(String missatge);` (Retorna `true` per "s" i `false` per "n").

Quan es produeixi un error de format, el programa ha de tornar a demanar la dada.

---

### Nivell 3

#### Exercici 1: Reserva de Seients en un Cinema
Desenvolupa una aplicació per a la reserva de seients en un cinema.

**Menú de l'aplicació:**
1. Mostrar totes les butaques reservades.
2. Mostrar les butaques reservades per una persona.
3. Reservar una butaca.
4. Anul·lar la reserva d’una butaca.
5. Anul·lar totes les reserves d’una persona.
0. Sortir.

**Classes principals:**
- `Butaca`: Representa una butaca reservada.
- `Cine`: Gestiona les dades del cinema i inicia l'aplicació.
- `GestioCine`: Controla la lògica de gestió del cinema.
- `GestioButaques`: Gestiona la llista de butaques reservades.

**Excepcions personalitzades:**
- `ExcepcioNomPersonaIncorrecte`
- `ExcepcioFilaIncorrecta`
- `ExcepcioSeientIncorrecte`
- `ExcepcioButacaOcupada`
- `ExcepcioButacaLliure`

L'aplicació demanarà les dades inicials de la sala de cinema i gestionarà les reserves seguint les opcions del menú.

---

## Requeriments
- Java 8 o superior
- Eclipse/IntelliJ
- Coneixements de programació orientada a objectes

## Autor
Desenvolupat com a part de les pràctiques d'aprenentatge en Java.

