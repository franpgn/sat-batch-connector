import com.fasterxml.jackson.databind.ObjectMapper;
import com.sat.sat.SATRequest;
import com.sat.sat.SOAPBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.*;
import java.util.Objects;

public class SATRequestTest {

    public void createSATRequest(SATRequest satRequest) {
        satRequest.setUf("35");
        satRequest.setNSerieSAT("999999999");
        satRequest.setDhInicial("01042015000000");
        satRequest.setDhFinal("30042015004400");
        satRequest.setChaveSeguranca("24bb6087-3a03-4581-9b1f-4e8332879369");
    }

    @Test
    public void testJSONRequestSuccess() throws IOException {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("request/json_request_query.json")).getFile()
        );
        ObjectMapper mapper = new ObjectMapper();
        SATRequest satRequest = mapper.readValue(file, SATRequest.class);

        Assertions.assertEquals("35", satRequest.getUf());
        Assertions.assertEquals("999999999", satRequest.getNSerieSAT());
        Assertions.assertEquals("01042015000000", satRequest.getDhInicial());
        Assertions.assertEquals("30042015004400", satRequest.getDhFinal());
        Assertions.assertEquals("24bb6087-3a03-4581-9b1f-4e8332879369", satRequest.getChaveSeguranca());
    }

    @Test
    public void testSOAPBuilderSuccess() throws IOException {
        SATRequest satRequest = new SATRequest();
        createSATRequest(satRequest);
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("request/xml_query.xml")).getFile()
        );
        Reader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while( line != null){
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        String request = stringBuilder.toString();

        bufferedReader.close();
        fileReader.close();

        Assertions.assertEquals(
                request.replaceAll("\\s", ""),
                SOAPBuilder.buildSATRequest(satRequest).replaceAll("\\s", "")
        );
    }
}
