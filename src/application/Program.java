package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		String name;
		double annualIncome;

		System.out.print("Enter the number of tax payers:");
		int input = sc.nextInt();

		for (int i = 0; i < input; i++) {
			System.out.printf("Tax payer #%d data:%n", i + 1);
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			switch (ch) {
			case 'i':
				sc.nextLine();
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Anual income: ");
				annualIncome = sc.nextDouble();
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditures));
				break;
			case 'c':
				sc.nextLine();
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Anual income: ");
				annualIncome = sc.nextDouble();
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, annualIncome, numberOfEmployees));
				break;

			}

		}

		System.out.println("\nTAXES PAID:");
		for (TaxPayer element : list) {
			System.out.println(element.toString());
		}

		double sum = 0.0;
		for (TaxPayer element : list) {
			sum += element.tax();
		}

		System.out.printf("\nTOTAL TAXES: $ %.2f%n", sum);

		sc.close();
	}

}
