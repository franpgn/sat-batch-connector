import com.connector.sat.dao.SATResponseDAO;
import com.connector.sat.model.ResLote;
import com.connector.sat.service.Cupom;
import com.connector.sat.service.CupomDTO;
import com.connector.sat.service.SATResponse;
import com.connector.sat.service.SATResponseDTO;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SATResponseTest {

    @Test
    public void readSATResponseSuccess() throws IOException{
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

        try {
            //arrumar e fazer bateria de testes!!!
            ResLote resLote = SATResponse.unmarshal(response).getCfeConsultarLotesResult().getResLote();
            System.out.println(resLote.getMensagem());
            List<Cupom> cupomList = new ArrayList<>();
            cupomList.add(new Cupom(
                    resLote.getLote().getNRec(),
                    resLote.getLote().getInfCfe().getCfe().getChave(),
                    Integer.getInteger(resLote.getLote().getInfCfe().getCfe().getNCupom()),
                    resLote.getLote().getInfCfe().getCfe().getSituacao()
            ));
            SATResponse satResponse = new SATResponse(
                    resLote.getLote().getNRec(),
                    resLote.getLote().getDhProcessamento(),
                    resLote.getLote().getDhEnvioLote(),
                    Integer.getInteger(resLote.getLote().getQtdeCupoms()),
                    resLote.getLote().getSituacaoLote(),
                    cupomList
            );

            SATResponseDAO satResponseDAO = new SATResponseDAO();
            satResponseDAO.save(satResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
