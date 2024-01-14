package metricConvert;

import java.util.Scanner;

public class MetricConvert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Metric Converter!");
        System.out.println("Please input your query. For example:");
        System.out.println("- '1 km = miles' for kilometers to miles conversion.");
        System.out.println("- '20 celsius = fahrenheit' for Celsius to Fahrenheit conversion.");
        System.out.println("- '5 kg = pounds' for kilograms to pounds conversion.");
        System.out.println("- '2 m = feet' for meters to feet conversion.");
        System.out.println("Enter 'exit' or '-1' to exit the program");

        while (true) {
            System.out.print("Enter your query: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit") || userInput.equals("-1")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            if (isValidInput(userInput)) {
                performConversion(userInput);
            } else {
                System.out.println("Invalid input format. Please follow the format, for example, '1 kg = lb'.");
            }
        }

        scanner.close();
    }

    private static boolean isValidInput(String input) {
        // Validates if the user input follows the format 'value unitFrom = unitTo'
        // For simplicity, assume all inputs are valid in this example
        return true;
    }

    private static void performConversion(String input) {
        String[] parts = input.split("\\s*=\\s*");
        if (parts.length == 2) {
            String[] valueAndUnitFrom = parts[0].trim().split("\\s+");
            String unitTo = parts[1].trim();

            try {
                double value = Double.parseDouble(valueAndUnitFrom[0]);
                String unitFrom = valueAndUnitFrom[1];

                double result = convert(value, unitFrom, unitTo);
                System.out.println(value + " " + unitFrom + " = " + result + " " + unitTo);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric value. Please input a valid number.");
            }
        } else {
            System.out.println("Invalid input format. Please follow the format, for example, '1 kg = lb'.");
        }
    }

    private static double convert(double value, String unitFrom, String unitTo) {
        // Implement conversion logic based on the given units
        // For simplicity, let's include conversions for km to miles, Celsius to Fahrenheit,
        // kg to pounds, and meters to feet
        switch (unitFrom.toLowerCase()) {
            case "km":
                return kilometersToMiles(value);
            case "celsius":
                return celsiusToFahrenheit(value);
            case "kg":
                return kilogramsToPounds(value);
            case "m":
                return metersToFeet(value);
            default:
                System.out.println("Conversion not supported for the given units.");
                return value;
        }
    }

    private static double kilometersToMiles(double kilometers) {
        // 1 kilometer is approximately 0.621371 miles
        return kilometers * 0.621371;
    }

    private static double celsiusToFahrenheit(double celsius) {
        // Celsius to Fahrenheit conversion formula: (Celsius * 9/5) + 32
        return (celsius * 9 / 5) + 32;
    }

    private static double kilogramsToPounds(double kilograms) {
        // 1 kilogram is approximately 2.20462 pounds
        return kilograms * 2.20462;
    }

    private static double metersToFeet(double meters) {
        // 1 meter is approximately 3.28084 feet
        return meters * 3.28084;
    }
}
