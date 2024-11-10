package org.example;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CSVReportGenerator implements ReportGenerator {

    @Override
    public void generateReport(ReportInput reportInput, DatabaseConnection databaseConnection,  DatabaseDataSource databaseDataSource) throws IOException {

        System.out.println("Generating CSV report...");
    }
}
