

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvFileReader {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader(args[0]);
        Iterable<CSVRecord> records = CSVFormat.Builder.create()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setCommentMarker('#')
                .build().parse(in);
        for (CSVRecord record : records) {
            var text = "%s:%s %15s %4s x %s".formatted(
                    record.get("txID"),
                    record.get("txTS"),
                    record.get("product"),
                    record.get("quantity"),
                    record.get("unitPrice")
            );
            System.out.println(text);
        }
    }
}