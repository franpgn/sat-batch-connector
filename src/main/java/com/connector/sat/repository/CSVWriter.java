package com.connector.sat.repository;

import com.connector.sat.model.ResLote;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class CSVWriter {
    static String[] HEADERS = { "chave", "situacao"};

    public static void writeCSV(ResLote resLote) throws IOException {
        StringWriter sw = new StringWriter();

        Map<String, String> LOTE_DATA = new HashMap<>() {
            {
                put(resLote.getLote().getInfCfe().getCfe().getChave(), resLote.getLote().getInfCfe().getCfe().getSituacao());
            }
        };

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();

        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            LOTE_DATA.forEach((chave, situacao) -> {
                try {
                    printer.printRecord(chave, situacao);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
