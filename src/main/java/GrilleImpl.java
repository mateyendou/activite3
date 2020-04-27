import java.util.Scanner;
/**
*Implementation d'une grille.
*/
public class GrilleImpl implements Grille {
/**Déclaration du nombre de ligne de la grille.*/
private final int line;
/**Déclaration du nombre de colonne de la grille.*/
private final int col;
/**Déclaration de la taille du carré.*/
private final int sq;
/**Déclaration du caractère 'vide'.*/
static final char EMPTY = '@';
/**Déclaration des valeurs possibble pour la grille.*/
private char[] possible = new char[] {'1', '2', '3', '4', '5', '6',
'7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f' };
/**Déclaration d'une grille sudoku.*/
private char[][] sudoku;
/**Déclaration de constante.*/
static final int SUDOKU_9 = 9;
/**Déclaration de constante.*/
static final int SUDOKU_16 = 16;
/**Déclaration de constante.*/
static final int CARRE_3 = 3;
/**Déclaration de constante.*/
static final int CARRE_4 = 4;
/**Déclaration de constante.*/
static final int MAX_CHAR = 15;
/**
*Constructeur par défaut.
*@param x position x dans la grille.
*@param y position y dans la grille.
*@param box  le carré.
*dont le coin [haut, gauche] est [x,y].
*/
public GrilleImpl(int x,  int y, int box) {
this.line = x;
this.col = y;
this.sq = box;
this.sudoku = new char[line][col];
initializesudoku();
}
/**
 *La procédure pour initialiser une grille sudoku vide.
 */
private void initializesudoku() {
for (int x = 0; x < this.line; x++) {
for (int y = 0; y < this.col; y++) {
this.sudoku[x][y] = EMPTY;
}
}
}
/**
*@return vrai si l'indexe en paramètre est dans l'intervalle correcte.
*@param index entier.
*/
private boolean inrange(int index) {
return index <= this.line && index >= 0;
}
/**@return vrai si la valeur en paramètre figure.
*dans la lsite des caractères autorisée.
*@param valeur à comparer.*/
private boolean correspondance(char valeur) {
int i = 0;
boolean trouver = false;
while (i <= MAX_CHAR && trouver == false) {
if (valeur != possible[i]) {
trouver = false;
} else {
trouver = true;
}
i++;
}
return trouver;
}
/**
*@return vrai si la  valeur v est possible pour la ligne x.
*@param x position x dans la grille.
*@param v valeur à mettre dans la case.*/
private boolean lignePossible(int x, char v) {
if (x <= this.line) {
for (int y = 0; y < this.col; y++) {
if (this.sudoku[x][y] == v) {
return false;
}
}
}
return true;
}
/**
*@return vrai si la  valeur v est possible pour la colonne  y.
*@param y positiony y dans la grille.
*@param v valeur à mettre dans la case.*/
private boolean colonnePossible(int y,  char v) {
if (y <= this.col) {
for (int x = 0; x < this.line; x++) {
if (this.sudoku[x][y] == v) {
return false;
}
}
}
return true;
}
/**
*@return vrai si la  valeur v est possible pour le carré.
*dont le coin [haut, gauche] est [x,y].
*@param x position x dans la grille.
*@param y position y dans la grille.
*@param v valeur à mettre dans la case.*/
private boolean carrePossible(int x,  int y,  char v) {
int coinline = (x / this.sq) * this.sq;
int coincol = (y / this.sq) * this.sq;
for (int x1 = 0; x1 < this.sq; x1++) {
for (int y1 = 0; y1 < this.sq; y1++) {
if (this.sudoku[coinline + x1][coincol + y1] == v) {
return false;
}
}
}
return true;
}
/**@return largeur/hauteur de la grille*/
public int getDimension() {
return this.sudoku.length;
}
/**
* Affecte une valeur dans la grille.
* @param x  position x dans la grille
* @param y  position y dans la grille
* @param value valeur a mettre dans la case
* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
* @throws IllegalArgumentException si la valeur est interdite aux vues des
*        autres valeurs de la grille
* @throws IllegalArgumentException si value n'est pas un caractere autorise
*        ('1',...,'9')
*/
public void setValue(int x, int y, char value) throws IllegalArgumentException {
if (!this.inrange(x)) {
throw new IllegalArgumentException("x est hors bornes (0-8)");
}
if (!this.inrange(y)) {
throw new IllegalArgumentException("y est hors bornes (0-8)");
}
if (value == EMPTY) {
this.sudoku[x][y] = EMPTY;
} else {
if (!this.correspondance(value)) {
throw new IllegalArgumentException("(Valeur non autorise '1',...,'9')");
}
this.sudoku[x][y] = value;
}
}
/**
* Recupere une valeur de la grille.
* @param x      position x dans la grille
* @param y      position y dans la grille
* @return valeur dans la case x,y
* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
*/
public char getValue(int x,  int y) throws IllegalArgumentException {
if (!this.inrange(x)) {
throw new IllegalArgumentException("x est hors bornes (0-8)");
}
if (!this.inrange(y)) {
throw new IllegalArgumentException("y est hors bornes (0-8)");
}
return sudoku[x][y];
}
/**
* Test si une grille est terminee.
* @return true si la grille est complete
*/
public boolean complete() {
for (int x = 0; x < this.line; x++) {
for (int y = 0; y < this.col; y++) {
if (this.sudoku[x][y] == ' ') {
return false;
}
}
}
return true;
}
/**
* Test si une valeur est possible dans la grille par rapport a ce qu'elle.
* contient deja
* @return true si la valeur est possible dans la grille
* @param x     position x dans la grille
* @param y     position y dans la grille
* @param value
*            valeur a mettre dans la case
* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
* @throws IllegalArgumentException si value n'est pas un caractere autorise
*        ('1',...,'9',..)
*/
public boolean possible(int x,  int y,  char value)
throws IllegalArgumentException {
boolean possibl = false;
if (!this.inrange(x)) {
throw new IllegalArgumentException("x est hors bornes (0-8)");
}
if (!this.inrange(y)) {
throw new IllegalArgumentException("y est hors bornes (0-8)");
}
if (!this.correspondance(value)) {
throw new IllegalArgumentException("(Valeur non autorise '1',...,'9')");
}
if ((carrePossible(x, y, value))
&& (lignePossible(x, value))
&& (colonnePossible(y, value))) {
possibl = true;
} else {
possibl = false;
}
return possibl;
}
/**
* Affiche une grille sudoku complète.
*/
public void afficherGrille() {
for (int x = 0; x < this.line; x++) {
for (int y = 0; y < this.col; y++) {
System.out.print(" " + this.sudoku[x][y]);
}
System.out.println();
}
System.out.println();
}
/**
* le programme principal.
*/
public static void main() {
int dimension;
int box;
char val;
do {
Scanner input = new Scanner(System.in);
System.out.print("Nombre de cases de la grille [9 ou 16]: ");
dimension = input.nextInt();
}
while ((dimension != SUDOKU_9) && (dimension != SUDOKU_16));
if (dimension == SUDOKU_9) {
box = CARRE_3;
} else {
box = CARRE_4;
}
GrilleImpl sudoku = new GrilleImpl(dimension, dimension, box);
int max = sudoku.getDimension();
for (int i = 0; i < max; i++) {
for (int j = 0; j < max; j++) {
boolean suivant = false;
do {
int indiceligne = i + 1;
int indicecolonne = j + 1;
Scanner scanner = new Scanner(System.in);
System.out.println("Ligne ["
+ indiceligne + "] Colonne [" + indicecolonne + "] : ");
String str = scanner.nextLine();
if ((str == null) || (str.trim().isEmpty())) {
val = EMPTY;
} else {
val = str.charAt(0);
}
if (val != EMPTY) {
if (sudoku.possible(i, j, val)) {
sudoku.setValue(i, j, val);
suivant = true;
}
} else {
suivant = true;
}
}
while (!suivant);
}
}
if (sudoku.complete()) {
sudoku.afficherGrille();
} else {
System.out.println("Grille incomplete.");
}
}
}
