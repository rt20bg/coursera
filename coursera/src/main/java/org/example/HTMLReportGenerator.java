package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLReportGenerator implements ReportGenerator {

    @Override
    public void generateReport(ReportInput reportInput, DatabaseConnection databaseConnection, DatabaseDataSource databaseDataSource) throws IOException {

        System.out.println("Generating HTML report at: ");

    }
}
