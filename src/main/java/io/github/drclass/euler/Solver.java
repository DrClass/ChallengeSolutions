package io.github.drclass.euler;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;
import org.reflections.Reflections;
import picocli.CommandLine;

@CommandLine.Command(name = "solver",
		mixinStandardHelpOptions = true,
		description = "Solve Project Euler problems.",
		subcommands = {Solver.SolveCommand.class, Solver.ListCommand.class})
public class Solver implements Runnable {

	private static final Map<String, Class<? extends Problem>> problemMap = new HashMap<>();

	static {
		Reflections reflections = new Reflections("io.github.drclass.euler.problems");
		Set<Class<? extends Problem>> classes = reflections.getSubTypesOf(Problem.class);

		for (Class<? extends Problem> clazz : classes) {
			problemMap.put(clazz.getSimpleName(), clazz);
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			interactiveMode();
		} else {
			int exitCode = new CommandLine(new Solver()).execute(args);
			System.exit(exitCode);
		}
	}

	@Override
	public void run() {
		CommandLine.usage(this, System.out);
	}

	@CommandLine.Command(name = "solve", description = "Solve a specific problem by number (e.g., solve 1).")
	static class SolveCommand implements Callable<Integer> {

		@CommandLine.Parameters(index = "0", description = "Problem number to solve.")
		private int problemNumber;

		@Override
		public Integer call() {
			String problemKey = String.format("Problem%04d", problemNumber);
			Class<? extends Problem> problemClass = problemMap.get(problemKey);

			if (problemClass == null) {
				System.err.println("No solution found for " + problemKey + ". Use 'list' to see available problems.");
				return 1;
			}

			try {
				Problem problem = problemClass.getDeclaredConstructor().newInstance();
				long start = System.nanoTime();
				Result<?> result = problem.solve();
				long stop = System.nanoTime();

				System.out.println("=======================================");
				System.out.printf("Problem: %s%n", problem.getName());
				System.out.println("---------------------------------------");
				System.out.printf("Result: %s%n", result.formatted());
				System.out.printf("Executed in: %s%n", formatDuration(Duration.ofNanos(stop - start)));
				System.out.println("=======================================\n");

			} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				System.err.println("Failed to instantiate problem class.");
				e.printStackTrace();
				return 2;
			}

			return 0;
		}
	}

	@CommandLine.Command(name = "list", description = "List all available problems.")
	static class ListCommand implements Runnable {

		@Override
		public void run() {
			System.out.println("Available problems:");
			problemMap.keySet().stream()
					.sorted()
					.forEach(name -> System.out.println(" - " + name));
			System.out.println();
		}
	}

	private static void interactiveMode() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Type 'solve <number>', 'list', or 'exit':");
			String input = scanner.nextLine().trim();

			if (input.equalsIgnoreCase("exit") || input.equals("0")) {
				break;
			}

			String[] args = input.split("\\s+");
			int exitCode = new CommandLine(new Solver()).execute(args);

			if (exitCode != 0) {
				System.err.println("Command failed. Type 'list' to see problems or 'exit' to quit.");
			}
		}

		scanner.close();
	}
	
	private static String formatDuration(Duration duration) {
		return String.format("%d.%09d seconds", duration.getSeconds(), duration.getNano());
	}
}
