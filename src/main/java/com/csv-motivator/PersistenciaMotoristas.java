
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


public class PersistenciaMotoristas{
    private static final String SAMPLE_CSV_FILE_PATH = "motoristas.dat";

    //cpf,nome,veiculo,pagamento
    //00742165035,Priscilla,ABC1J23,CARTAO
    //String CPF,String Nome, Veiculo Veiculo, FormaPagamento Pagament


    public List<Motorista> carregaMotoristas() throws IOException{
        
        List<Motorista> lista = new ArrayList<Motorista>();
        PersistenciaVeiculos p = new PersistenciaVeiculos();
        
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180.withFirstRecordAsHeader());
        ) {
   
        for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String CPF = csvRecord.get(0);
                String Nome = csvRecord.get(1);
                Veiculo Veiculo = p.getVeiculoByPlaca(csvRecord.get(2));
                String Pagamento = csvRecord.get(3);
                Motorista m = new Motorista(CPF, Nome, Veiculo, Pagamento);
                lista.add(m);
        }
       } 

        return lista;
    }

    public boolean persisteMotoristas(List<Motorista> Motoristas) {
        try {
            // create a writer
            //Writer writer = Files.newBufferedWriter(Paths.get(sample_csv_file_path));
            Writer writer = Files.newBufferedWriter(Paths.get("./motoristas_novo.dat"));
        
            // write CSV file placa,marca,cor,categoria
            CSVPrinter printer = CSVFormat.DEFAULT.withHeader("CPF", "Nome", "Veiculo_Categoria", "Veiculo_Cor", "Veiculo_Marca", "Veiculo_Placa", "FormaPagamento").print(writer);
        
            // write list to file
            printer.printRecords(Motoristas);

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