import com.connector.sat.service.SATResponse;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Objects;

public class SATResponseTest {

    @Test
    public void readSATResponseSuccess() throws IOException{
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("response/xml_sat_invalido.xml")).getFile()
        );
        Reader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        String response = stringBuilder.toString();

        bufferedReader.close();
        fileReader.close();

        try {
            //arrumar e fazer bateria de testes!!!
            System.out.println(SATResponse.unmarshal(response).getCfeConsultarLotesResult().getResLote().getMensagem());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
