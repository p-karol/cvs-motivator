
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
            System.out.println("\n Arquivo CSV veiculos_novo.dat gravado com sucesso \n");
        }

        List<Motorista> motoristas = new ArrayList<Motorista>();
        PersistenciaMotoristas pm = new PersistenciaMotoristas();
        motoristas = pm.carregaMotoristas(); 
        
        System.out.println("Lendo arquivo CSV motoristas.dat");
        for (Motorista m : motoristas){
            System.out.println(m.toString());
        } 
        
        if(pm.persisteMotoristas(motoristas)){
            System.out.println("\n Arquivo CSV motoristas_novo.dat gravado com sucesso \n");
        }

        List<Passageiro> passageiros = new ArrayList<Passageiro>();
        PersistenciaPassageiros pp = new PersistenciaPassageiros();
        passageiros = pp.carregaPassageiros(); 

        System.out.println("Lendo arquivo CSV passageiros.dat");
        for (Passageiro pa : passageiros){
            System.out.println(pa.toString());
        } 
        
        if(pp.persistePassageiros(passageiros)){
            System.out.println("\n Arquivo CSV passageiros_novo.dat gravado com sucesso \n");
        } 





     }
}