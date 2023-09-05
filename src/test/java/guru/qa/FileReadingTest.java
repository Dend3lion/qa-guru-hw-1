package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import guru.qa.model.GameModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileReadingTest {
    ClassLoader cl = FileReadingTest.class.getClassLoader();

    private InputStream getInputStreamForFileFromZip(String fileExtension) throws Exception {
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("Archive.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            if (entry.getName().contains(fileExtension)) {
                return is;
            }
        }
        throw new Exception("Archive doesn't contain any " + fileExtension + " files");
    }

    @DisplayName("Zip archive contains valid .xlsx file")
    @Test
    void xlsxContentTests() throws Exception {
        try (InputStream zis = getInputStreamForFileFromZip(".xlsx")) {
            XLS xls = new XLS(zis);
            Assertions.assertEquals(
                    "Germany",
                    xls.excel.getSheetAt(0)
                            .getRow(4)
                            .getCell(1)
                            .getStringCellValue());
        }
    }

    @DisplayName("Zip archive contains valid .pdf file")
    @Test
    void pdfContentTests() throws Exception {
        try (InputStream zis = getInputStreamForFileFromZip(".pdf")) {
            PDF pdf = new PDF(zis);
            Assertions.assertTrue(pdf.text.contains("Вечер добрый"));
        }
    }

    @DisplayName("Zip archive contains valid .csx file")
    @Test
    void csvContentTests() throws Exception {
        try (InputStream zis = getInputStreamForFileFromZip(".csv")) {
            Reader reader = new InputStreamReader(zis);
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> content = csvReader.readAll();

            Assertions.assertEquals(6, content.size());
            Assertions.assertArrayEquals(new String[]{"Jack", "McGinnis", "220 hobo Av.", "Phila", " PA", "09119"}, content.get(1));
            Assertions.assertArrayEquals(new String[]{"John \"Da Man\"", "Repici", "120 Jefferson St.", "Riverside", " NJ", "08075"}, content.get(2));
            Assertions.assertArrayEquals(new String[]{"Stephen", "Tyler", "7452 Terrace \"At the Plaza\" road", "SomeTown", "SD", " 91234"}, content.get(3));
        }
    }

    @DisplayName("Json file contains valid data")
    @Test
    void jsonContentTests() throws Exception {
        try (Reader reader = new InputStreamReader(cl.getResourceAsStream("game.json"))) {
            ObjectMapper mapper = new ObjectMapper();
            GameModel gameModel = mapper.readValue(reader, GameModel.class);

            Assertions.assertEquals("Starfield", gameModel.getName());
            Assertions.assertEquals("Bethesda", gameModel.getPublisher());
            Assertions.assertEquals(6, gameModel.getRelease().getDay());
            Assertions.assertEquals(9, gameModel.getRelease().getMonth());
            Assertions.assertEquals(2023, gameModel.getRelease().getYear());

        }
    }
}
