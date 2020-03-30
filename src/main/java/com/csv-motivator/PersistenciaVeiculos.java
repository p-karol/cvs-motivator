
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
                    Veiculo v = new Veiculo(Placa, Marca, Cor, Categoria);
                    lista.add(v);
            }
        return lista;
        } 
    } 

    public boolean persisteVeiculos(List<Veiculo> Veiculos) {
        try {
            // create a writer
            //Writer writer = Files.newBufferedWriter(Paths.get(sample_csv_file_path));
            Writer writer = Files.newBufferedWriter(Paths.get("./veiculos_novo.dat"));
        
            // write CSV file placa,marca,cor,categoria
            CSVPrinter printer = CSVFormat.DEFAULT.withHeader("placa", "marca", "cor", "categoria").print(writer);
        
            // write list to file
            printer.printRecords(Veiculos);
        
            // flush the stream
            printer.flush();
        
            // close the writer
            writer.close();

            return true;
        
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }    
}