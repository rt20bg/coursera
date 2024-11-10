package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ReportInput {
    private Optional<List<String>> studentPins;
    private int minimumCredit;
    private LocalDate startDate;
    private LocalDate endDate;
    private Optional<String> outputFormat;
    private Path outputDirectory;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Method to gather and validate input
    public void gatherInput() {
        Scanner scanner = new Scanner(System.in);

        // Optional: Comma-separated student PINs
        System.out.println("Enter a comma-separated list of student PINs (or press Enter to include all): ");
        String pinsInput = scanner.nextLine();
        studentPins = pinsInput.isEmpty() ? Optional.empty()
                : Optional.of(Arrays.asList(pinsInput.split(",")));

        // Required: Minimum credit
        while (true) {
            System.out.print("Enter the required minimum credit: ");
            String creditInput = scanner.nextLine();
            try {
                minimumCredit = Integer.parseInt(creditInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer for minimum credit.");
            }
        }

        // Required: Start and end date
        while (true) {
            try {
                System.out.print("Enter the start date (yyyy-MM-dd): ");
                startDate = LocalDate.parse(scanner.nextLine(), DATE_FORMAT);
                System.out.print("Enter the end date (yyyy-MM-dd): ");
                endDate = LocalDate.parse(scanner.nextLine(), DATE_FORMAT);
                if (startDate.isAfter(endDate)) {
                    System.out.println("Start date must be before end date.");
                } else {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Please enter dates in the format yyyy-MM-dd.");
            }
        }

        // Optional: Output format
        System.out.println("Enter the output format (csv or html, or press Enter for both): ");
        String formatInput = scanner.nextLine().trim().toLowerCase();
        outputFormat = formatInput.isEmpty() ? Optional.empty() : Optional.of(formatInput);

        // Required: Output directory
        System.out.print("Enter the path to the directory where reports will be saved: ");
        outputDirectory = Paths.get(scanner.nextLine()).toAbsolutePath();
    }

    // Getters for each field
    public Optional<List<String>> getStudentPins() { return studentPins; }
    public int getMinimumCredit() { return minimumCredit; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Optional<String> getOutputFormat() { return outputFormat; }
    public Path getOutputDirectory() { return outputDirectory; }

    @Override
    public String toString() {
        return "ReportInput{" +
                "studentPins=" + studentPins +
                ", minimumCredit=" + minimumCredit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", outputFormat=" + outputFormat.orElse("both") +
                ", outputDirectory=" + outputDirectory +
                '}';
    }
}
