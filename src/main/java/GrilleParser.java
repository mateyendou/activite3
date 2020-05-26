import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
/**
*Classe utilitaire pour lire un fichier.
*et remplir une grille sudoku
*/
class GrilleParser {
/**
*Constructeur par defaut.
*@param in le fichier à lire.
*@param grille la grille sudoku à remplir.
*@throws IOException si le fichier
*ne peut etre lu*/
public static void parse(final InputStream in, final Grille grille) throws IOException {
Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
int dimension = grille.getDimension();
char[] buffer = new char[dimension];
for (int line = 0; line < dimension; line++) {
    int lus = reader.read(buffer);
    if (lus != dimension) {
        throw new EOFException("format incorrect");
}
for (int i = 0; i < dimension; i++) {
    grille.setValue(line, i, buffer[i]);
}
lus = reader.read(new char[1]);
if (lus != 1) {
    throw new EOFException("pas de fin de ligne ? ligne=" + line);
    }
}
reader.close();
}
/**
*methode pour lire les données et remplir la grille.
*@param f le fichier à lire.
*@param grille la grille sudoku à remplir.
*@throws IOException si le fichier
*ne peut etre lu*/
public static void parse(final File f, final Grille grille) throws IOException {
    parse(new FileInputStream(f), grille);
}

}
