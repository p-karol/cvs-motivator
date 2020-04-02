
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class PersistenciaPassageiros{
    private static final String SAMPLE_CSV_FILE_PATH = "passageiros.dat";

    public List<Passageiro> carregaPassageiros() throws IOException{
        
        List<Passageiro> lista = new ArrayList<Passageiro>();
        
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180.withFirstRecordAsHeader());
        ) {
   
        for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String CPF = csvRecord.get(0);
                String Nome = csvRecord.get(1);
                String Pagamento = csvRecord.get(2);
                String Nro_cartao = csvRecord.get(3);
                Passageiro p = new Passageiro(CPF, Nome, Pagamento, Nro_cartao);
                lista.add(p);
        }
       } 

        return lista;
    }

    public boolean persistePassageiros(List<Passageiro> Passageiros) {
        try {
            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("./passageiros_novo.dat"));
        
            CSVPrinter printer = CSVFormat.DEFAULT.withHeader("CPF", "Nome", "Pagamento", "Nro_cartao").print(writer);
        
            // write list to file
            printer.printRecords(Passageiros);

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