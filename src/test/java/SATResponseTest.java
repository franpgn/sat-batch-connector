import com.sat.sat.SATResponse;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Objects;

public class SATResponseTest {

    @Test
    public void readSATResponseSuccess() throws IOException, JAXBException {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("response/xml_response.xml")).getFile()
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

        System.out.println(SATResponse.extractCDATA(response));
    }
}
