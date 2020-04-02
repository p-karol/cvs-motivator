
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class App{
    public static void main(String args[]) throws IOException {

        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        PersistenciaVeiculos p = new PersistenciaVeiculos();
        veiculos = p.carregaVeiculos(); 
       
        
        System.out.println("Lendo arquivo CSV veiculos.dat"); 
        for (Veiculo v : veiculos){
            System.out.println(v.toString());
        }  

        if(p.persisteVeiculos(veiculos)){
            System.out.println("Gravando arquivo CSV veiculos_novo.dat \n");
        }

        List<Motorista> motoristas = new ArrayList<Motorista>();
        PersistenciaMotoristas pm = new PersistenciaMotoristas();
        motoristas = pm.carregaMotoristas(); 
        
        System.out.println("Lendo arquivo CSV veiculos.dat");
        for (Motorista m : motoristas){
            System.out.println(m.toString());
        } 

     }
}