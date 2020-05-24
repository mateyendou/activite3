import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class GrilleParser {
    public static void parse(InputStream in, Grille grille) throws IOException {
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

    public static void parse(File f, Grille grille) throws IOException {
        parse(new FileInputStream(f), grille);
    }

}
