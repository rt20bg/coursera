package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {

        DatabaseConnection conn = new DatabaseConnection();
        DatabaseDataSource databaseDataSource = new DatabaseDataSource(conn);

        ReportInput reportInput = new ReportInput();
        reportInput.gatherInput();
        System.out.println("Input received: " + reportInput);

        CSVReportGenerator csvGenerator = new CSVReportGenerator();
        HTMLReportGenerator htmlGenerator = new HTMLReportGenerator();

        Optional<String> outputFormat = reportInput.getOutputFormat();

        // If no output format is specified, generate both reports by default
        if (!outputFormat.isPresent() || outputFormat.get().isEmpty()) {
            // Generate both CSV and HTML reports
            csvGenerator.generateReport(reportInput, conn,   databaseDataSource);
            htmlGenerator.generateReport(reportInput, conn,  databaseDataSource);
        }
        // If CSV is selected
        else if (outputFormat.get().equals("csv")) {
            csvGenerator.generateReport(reportInput, conn,  databaseDataSource);
        }
        // If HTML is selected
        else if (outputFormat.get().equals("html")) {
            htmlGenerator.generateReport(reportInput, conn,databaseDataSource);
        }
    }
}
