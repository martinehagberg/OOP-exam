import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main_del1 {
    public static void main(String[] args) {
        Program_del1 program = new Program_del1();
        try{
            program.readFile();
        } catch (SQLException e){
            System.out.println("SQL Exception: "+e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e){
            System.out.println("FileNotFound Exception: "+e.getMessage());
            e.printStackTrace();
        }
    }
}