# Challenge Solutions

A collection of Java solutions for [Project Euler](https://projecteuler.net/) problems, [Rosalind](https://rosalind.info/) problems, and in the future maybe others. Written using a flexible and extensible problem-solving framework.

## Usage

### Build the project

```bash
./gradlew build
```

### Running the project

The project can be run by either passing arguments directly or without passing any arguments to enter an interactive mode.

### Available Commands

Solve a problem

```bash
./gradlew run --args="solve <source> <id>"
```

Example:

```bash
./gradlew run --args="solve euler 1"
./gradlew run --args="solve rosalind dna"
```

List all available problems

```bash
./gradlew run --args="list"
```

### Interactive mode

If you run without arguments, the program will start an interactive prompt:

```bash
./gradlew run
```

You can then type commands like:

```bash
solve euler 1
solve rosalind dna
list
exit
```

## License

This project is licensed under the [MIT License](LICENSE).

## Contributing

This project is a personal collection of my own solutions, so I am not accepting external contributions at this time.  

However, feel free to fork the repository or open issues if you'd like to discuss ideas or share feedback.

---

### If you find this project helpful, please star it on GitHub!