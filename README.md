#  Blackjack Java Game
This is a Java-based implementation of the classic card game Blackjack. The application features object-oriented design, a user interface, and persistent data storage.

---

## Functionality

- Play a Blackjack game against the dealer via console
- Player actions: `hit` or `stand`
- Display final hands and scores before showing the result
- Game statistics (wins/losses) are stored in a JSON file
- Console menu:
    - Start a new game
    - View game statistics
    - Exit the program

## Relevant files:
- [Main.java](./src/main/java/main/Main.java) – user interaction and game flow
- [GameEngine.java](./src/main/java/game/GameEngine.java) – core game mechanics
- [StatsManager.java](./src/main/java/main/StatsManager.java) – save/load stats logic
- [DeckFactory.java](./src/main/java/factory/DeckFactory.java) – generates and shuffles the full deck
- [CardFactory.java](./src/main/java/factory/CardFactory.java) – creates individual cards
- [DealerStrategy.java](./src/main/java/strategy/DealerStrategy.java) – AI logic for dealer

---

## How to Run Locally

```bash
mvn compile
mvn exec:java
```

Ensure the class `main.Main` is specified in your `pom.xml` under `exec-maven-plugin`.

---

## Programming Principles
### Single Responsibility Principle (SRP)
Each class is responsible for one thing only:
- [`Main.java`](./src/main/java/main/Main.java) – menu and user interaction ([lines 13–47](./src/main/java/main/Main.java#L13-L47))
- [`StatsManager.java`](./src/main/java/main/StatsManager.java) – JSON file read/write logic ([lines 11–48](./src/main/java/main/StatsManager.java#L11-L48))
- [`GameEngine.java`](./src/main/java/game/GameEngine.java) – Blackjack rules and actions

### DRY (Don't Repeat Yourself)
Repeated code is extracted into reusable methods:
- [`saveResult(...)`](./src/main/java/main/StatsManager.java#L27)
- [`loadStats()`](./src/main/java/main/StatsManager.java#L11)

### Modularity
Project follows the principle "one class — one file":
- UI → `Main.java`
- Persistence → `StatsManager.java`
- Game logic → `GameEngine.java`, `Player.java`, etc.

### KISS (Keep It Simple, Stupid)
Minimal conditions, clear responsibilities:
- Simple menu loop using `while` + `switch` ([Main.java lines 17–45](./src/main/java/main/Main.java#L17-L45))
- Methods like `startGame()`, `showMenu()`, `saveResult()` are short and focused

### YAGNI (You Aren’t Gonna Need It)
Only essential features implemented:
- No multiplayer, AI, or external libraries beyond JSON
- No GUI — console UI is sufficient

---

## Design Patterns

- **Separation of Concerns** (not a GoF pattern, but important architectural principle)

### Singleton Pattern
- [`StatsManager`](./src/main/java/main/StatsManager.java) is implemented as a Singleton to ensure only one instance manages statistics.

### Strategy Pattern
- [`DealerStrategy`](./src/main/java/strategy/DealerStrategy.java) and interface [`PlayStrategy`](./src/main/java/strategy/PlayStrategy.java) abstract the dealer’s playing logic from the game flow.

### Factory Pattern
- [`DeckFactory`](./src/main/java/factory/DeckFactory.java) and [`CardFactory`](./src/main/java/factory/CardFactory.java) encapsulate deck and card creation, improving scalability.


---

## Data Persistence

Statistics are stored in:
```
data/stats.json
```
Automatically created and updated after each game.

---

## Git Workflow Suggestion

- Work in branches
- Develop in `feature/*` branches
- Merge via Pull Requests
- Keep commits small and descriptive

---

## License

MIT License
