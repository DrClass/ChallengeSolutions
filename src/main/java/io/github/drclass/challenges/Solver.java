package io.github.drclass.challenges;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.Callable;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;
import org.reflections.Reflections;
import picocli.CommandLine;

@CommandLine.Command(name = "solver",
		mixinStandardHelpOptions = true,
		description = "Solve problems from multiple sources (euler, rosalind, ...).",
		subcommands = {Solver.SolveCommand.class, Solver.ListCommand.class})
public class Solver implements Runnable {

	private static final Map<String, Map<String, Class<? extends Problem>>> sourceMap = new HashMap<>();

	static {
		// Euler
		sourceMap.put("euler", loadProblems("io.github.drclass.challenges.problems.euler"));

		// Rosalind
		sourceMap.put("rosalind", loadProblems("io.github.drclass.challenges.problems.rosalind"));

		// Future sources can be added here easily
	}

	private static Map<String, Class<? extends Problem>> loadProblems(String pkg) {
		Map<String, Class<? extends Problem>> map = new HashMap<>();
		Reflections reflections = new Reflections(pkg);
		Set<Class<? extends Problem>> classes = reflections.getSubTypesOf(Problem.class);

		for (Class<? extends Problem> clazz : classes) {
			map.put(clazz.getSimpleName(), clazz);
		}
		return map;
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

	@CommandLine.Command(name = "solve", description = "Solve a problem from a source (e.g., solve euler 22 or solve rosalind DNA).")
	static class SolveCommand implements Callable<Integer> {

		@CommandLine.Parameters(index = "0", description = "Source name (euler, rosalind, etc.)")
		private String source;

		@CommandLine.Parameters(index = "1", description = "Problem ID (e.g., 22 or DNA)")
		private String problemId;

		@Override
		public Integer call() {
			Map<String, Class<? extends Problem>> problems = sourceMap.get(source.toLowerCase());

			if (problems == null) {
				System.err.printf("Unknown source: '%s'. Use 'list' to see available sources and problems.%n", source);
				return 1;
			}

			String problemKey;

			if (source.equalsIgnoreCase("euler")) {
				// Euler IDs are integers, mapped to ProblemXXXX
				try {
					int num = Integer.parseInt(problemId);
					problemKey = String.format("Problem%04d", num);
				} catch (NumberFormatException e) {
					System.err.println("Euler problem ID must be an integer.");
					return 1;
				}
			} else {
				// Rosalind and future — assume direct string
				problemKey = "Problem" + problemId.toUpperCase();
			}

			Class<? extends Problem> problemClass = problems.get(problemKey);

			if (problemClass == null) {
				System.err.printf("Problem '%s' not found in source '%s'. Use 'list' to see available problems.%n", problemId, source);
				return 1;
			}

			try {
				Problem problem = problemClass.getDeclaredConstructor().newInstance();
				long start = System.nanoTime();
				Result<?> result = problem.solve();
				long stop = System.nanoTime();

				System.out.println("=======================================");
				System.out.printf("Source: %s%n", source);
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
			System.out.println("Available sources and problems:");
			sourceMap.forEach((source, problems) -> {
				System.out.println("Source: " + source);
				problems.keySet().stream()
						.sorted()
						.forEach(name -> System.out.println("  - " + name));
				System.out.println();
			});
		}
	}

	private static void interactiveMode() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Type 'solve <source> <id>', 'list', or 'exit':");
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
