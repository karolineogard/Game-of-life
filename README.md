# Game-of-life

# Game of Life

Two implementations of Conway's Game of Life: one in Python and one in Java.

The project simulates a grid of cells that evolve over successive generations
according to Conway's Game of Life rules.

## Repository structure

```text
game-of-life/
├── python/
│   ├── celle.py
│   ├── rutenett.py
│   ├── verden.py
│   ├── hovedprogram.py
│   └── test_*.py
└── java/
    ├── Celle.java
    ├── Rutenett.java
    ├── Verden.java
    ├── GameOfLife.java
    └── Test*.java
```

## Rules

Each cell is either alive or dead. For every new generation:

- A live cell with fewer than two live neighbours dies.
- A live cell with two or three live neighbours survives.
- A live cell with more than three live neighbours dies.
- A dead cell with exactly three live neighbours becomes alive.

## Python implementation

The Python implementation is located in [`python/`](python/).

### Run

From the repository root:

```bash
cd python
python3 hovedprogram.py
```

### Tests

```bash
cd python
python3 test_celle.py
python3 test_rutenett.py
python3 test_verden.py
```

## Java implementation

The Java implementation is located in [`java/`](java/).

### Compile and run

From the repository root:

```bash
cd java
javac *.java
java GameOfLife
```

### Run tests

The project includes test classes for the main components:

```bash
cd java
javac *.java
java TestCelle
java TestRutenett
java TestVerden
```

## Implementation

Both versions model the simulation using separate components:

- `Celle` / `celle` represents an individual cell and its state.
- `Rutenett` / `rutenett` represents the grid of cells.
- `Verden` / `verden` manages generations and updates the simulation.
- `GameOfLife` / `hovedprogram` starts the program.

## Notes

This repository contains source code only. Generated files, such as Python
`__pycache__` folders and Java `.class` files, are excluded through
`.gitignore`.
