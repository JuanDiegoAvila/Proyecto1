import java.io.File;
import java.util.Scanner;

public class Lector {

    public String Archivo(String path){
        String LISP = "";
        try {
            Scanner input = new Scanner(new File(path));
            int cont = 0;
            while (input.hasNextLine()) {
                LISP = input.nextLine();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return LISP;
    }

}
