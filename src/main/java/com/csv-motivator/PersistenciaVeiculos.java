
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class PersistenciaVeiculos{
    
    private static final String sample_csv_file_path = "./veiculos.dat";
  
    public List<Veiculo> carregaVeiculos() throws IOException{
        
        try (
            Reader reader = Files.newBufferedReader(Paths.get(sample_csv_file_path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
   
            List<Veiculo> lista = new ArrayList<Veiculo>();

            for (CSVRecord csvRecord : csvParser) {
                    // Accessing Values by Column Index
                    String Placa = csvRecord.get(0);
                    String Marca = csvRecord.get(1);
                    String Cor = csvRecord.get(2);
                    String Categoria = csvRecord.get(3);
                    System.out.println("Record No - " + csvRecord.getRecordNumber());
                    System.out.println("---------------");
                    System.out.println("Placa : " + Placa);
                    System.out.println("Marca : " + Marca);
                    System.out.println("Cor : " + Cor);
                    System.out.println("Categoria : " + Categoria);
                    System.out.println("---------------\n\n");                    


                    Veiculo v = new Veiculo(Placa, Marca, Cor, Categoria);
                    
                    lista.add(v);
            }
        return lista;
        } 
    } 
}