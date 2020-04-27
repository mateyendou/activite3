import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**Les fonctions pour tester la grille de Sudoku.*/
public class GrilleTest {
/**Déclaration de constance entier '1'.*/
public static final int INT_1 = 1;
/**Déclaration de constance entier '3'.*/
public static final int INT_3 = 3;
/**Déclaration de constance entier '4'.*/
public static final int INT_4 = 4;
/**Déclaration de constance entier '5'.*/
public static final int INT_5 = 5;
/**Déclaration de constance entier '6'.*/
public static final int INT_6 = 6;
/**Déclaration de constance entier '7'.*/
public static final int INT_7 = 7;
/**Déclaration de constance entier '8'.*/
public static final int INT_8 = 8;
/**Déclaration de constance entier '9'.*/
public static final int INT_9 = 9;
/**Déclaration de constance entier '10'.*/
public static final int INT_10 = 10;
/**Déclaration de constance entier '11'.*/
public static final int INT_11 = 11;
/**Déclaration du caractère '1'.*/
public static final char VAL_1 = '1';
/**Déclaration du caractère '2'.*/
public static final char VAL_2 = '2';
/**Déclaration du caractère '3'.*/
public static final char VAL_3 = '3';
/**Déclaration du caractère '4'.*/
public static final char VAL_4 = '4';
/**Déclaration du caractère '5'.*/
public static final char VAL_5 = '5';
/**Déclaration du caractère '6'.*/
public static final char VAL_6 = '6';
/**Déclaration du caractère '7'.*/
public static final char VAL_7 = '7';
/**Déclaration du caractère '8'.*/
public static final char VAL_8 = '8';
/**Déclaration du caractère '9'.*/
public static final char VAL_9 = '9';
/**Déclaration du caractère 'Z'.*/
public static final char VAL_Z = 'z';
/**Déclaration de la taille de la grille de référence.*/
static final int GRID_SIZE = 9;
/**Déclaration de la taille du carré de référence.*/
static final int GRID_BOX = 3;
/**Déclaration du caractère 'vide'.*/
static final char EMPTY = '@';
/**Déclaration de la  grille sudoku de référence.*/
private char[][] sudokutest = {
      {VAL_8, VAL_6, EMPTY, EMPTY, VAL_2, EMPTY, EMPTY, EMPTY, EMPTY},
      {EMPTY, EMPTY, EMPTY, VAL_7, EMPTY, EMPTY, EMPTY, VAL_5, VAL_9},
      {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
      {EMPTY, EMPTY, EMPTY, EMPTY, VAL_6, EMPTY, VAL_8, EMPTY, EMPTY},
      {EMPTY, VAL_4, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
      {EMPTY, EMPTY, VAL_5, VAL_3, EMPTY, EMPTY, EMPTY, EMPTY, VAL_7},
      {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
      {EMPTY, VAL_2, EMPTY, EMPTY, EMPTY, EMPTY, VAL_6, EMPTY, EMPTY},
      {EMPTY, EMPTY, VAL_7, VAL_5, EMPTY, VAL_9, EMPTY, EMPTY, EMPTY}
};
/**Creation d'une grille de test vide.*/
private GrilleImpl  grille = new GrilleImpl(INT_9, INT_9, INT_3);
/**test de validation de la fonction Getdimension.*/
@Test
public void testGetDimension() {
assertEquals(GRID_SIZE, grille.getDimension());
}
/**test de la fonction setvalue.*/
@Test
public void testSetvalue() {
grille.setValue(INT_4, INT_1, VAL_4);
assertEquals(VAL_4, grille.getValue(INT_4, INT_1));
}
/**test de l'exception 'x' de la  fonction setvalue.*/
@Test
public void testSetvalueX() {
Exception e = assertThrows(Exception.class,
() -> grille.setValue(INT_10, INT_5, VAL_9));
assertEquals("x est hors bornes (0-8)", e.getMessage());
}
/**test de l'exception 'y' de la  fonction setvalue.*/
 @Test
public void teststevalueY() {
Exception e = assertThrows(Exception.class,
() -> grille.setValue(INT_8, INT_11, VAL_9));
assertEquals("y est hors bornes (0-8)", e.getMessage());
}
 /**test de l'exception 'valeur' de la  fonction setvalue.*/
@Test
public void testsetvalueVal() {
Exception e = assertThrows(Exception.class,
() -> grille.setValue(INT_1, INT_3, VAL_Z));
assertEquals("(Valeur non autorise '1',...,'9')", e.getMessage());
}
/**test de validation de la fonction getvalue.*/
@Test
public void testGetvalue() {
grille.setValue(INT_1, INT_7, VAL_5);
assertEquals(VAL_5, grille.getValue(INT_1, INT_7));
}
/**test de l'exception 'x' de la  fonction getValue.*/
@Test
public void testGetvalueX() {
Exception e = assertThrows(Exception.class,
() -> grille.getValue(INT_10, INT_5));
assertEquals("x est hors bornes (0-8)", e.getMessage());
}
/**test de l'exception 'y' de la  fonction getValue.*/
@Test
public void testgetvalueY() {
Exception e = assertThrows(Exception.class,
() -> grille.getValue(INT_8, INT_11));
assertEquals("y est hors bornes (0-8)", e.getMessage());
}
/**test de la fonction possible.*/
@Test
public void testpossible() {
assertTrue(grille.possible(INT_3, INT_6, VAL_2));
}
/**test de l'exception 'x' de la  fonction possible.*/
@Test
public void testpossibleX() {
Exception e = assertThrows(Exception.class,
() -> grille.possible(INT_10, INT_5, VAL_9));
assertEquals("x est hors bornes (0-8)", e.getMessage());
}
/**test de l'exception 'y' de la  fonction possible.*/
@Test
public void testpossibleY() {
Exception e = assertThrows(Exception.class,
() -> grille.possible(INT_8, INT_11, VAL_9));
assertEquals("y est hors bornes (0-8)", e.getMessage());
}
/**test de l'exception 'valeur' de la  fonction possible.*/
@Test
public void testpossibleVal() {
Exception e = assertThrows(Exception.class,
() -> grille.possible(INT_1, INT_3, VAL_Z));
assertEquals("(Valeur non autorise '1',...,'9')", e.getMessage());
}
/**Test de la fonction complet.*/
@Test
public void testcomplet() {
assertTrue(grille.complete());
}
}
