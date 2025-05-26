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
- [GameEngine.java](./src/main/java/game/GameEngine.java) – game logic
- [StatsManager.java](./src/main/java/main/StatsManager.java) – statistics load/save

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
- Could be extended to include Factory or Strategy patterns for AI/Dealer logic in future versions

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
- Keep commits small and descriptive

---

## License

MIT License
