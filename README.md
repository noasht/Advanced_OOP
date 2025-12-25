# Advanced Object Oriented Programming 

🏆 Advanced OOP course assignments at SCE College of Engineering
 
**Language:** Java | **Topics:** Interfaces, GUI, Multithreading, Design Patterns

---

## 🎯 Project Theme: Animal Olympics 🦁🏅

A semester-long project building an Animal Olympics competition system with GUI and multithreading.

---

## 🗂️ Project Structure
```
├── HW1_animal_hierarchy/
├── HW2_gui/
└── HW3_threads/
```

---

## 📝 Assignments

### Assignment 1: Class Hierarchy & Foundations
**Topics:** Inheritance, Interfaces, Abstract Classes, Encapsulation

Built a complete animal hierarchy for the Olympics system:

| Package | Description |
|---------|-------------|
| `Olympics` | `Medal` class with enum type (BRONZE, SILVER, GOLD), tournament name, and year. |
| `mobility` | `ILocatable` interface, `Point` class for coordinates, abstract `Mobile` class tracking total distance traveled. |
| `animals` | Abstract `Animal` class with name, speed, and medals array. |

**Animal Hierarchy:**
```
Mobile (abstract)
├── TerrestrialAnimal (abstract)
│   ├── Dog
│   ├── Cat (with castration status)
│   └── Snake (with toxicity level: low/medium/high)
├── WaterAnimal (abstract)
│   ├── Whale
│   ├── Dolphin
│   └── Alligator (also Terrestrial - uses Delegator pattern)
└── AirAnimal (abstract)
    ├── Eagle (with altitude and wingspan)
    └── Pigeon
```

---

### Assignment 2: GUI & Interfaces
**Topics:** Swing GUI, Event Handling, Interfaces, Exceptions

Added graphical interface to the Olympics system:

| Class | Description |
|-------|-------------|
| `CompetitionFrame` | Main JFrame window with menu and controls. Contains the `main()` method. |
| `ZooPanel` | JPanel for drawing and animating animals on screen. |
| `AddAnimalDialog` | JDialog for adding new animals with input validation. |

**Interfaces Implemented:**
| Interface | Description |
|-----------|-------------|
| `IDrawable` | Methods for loading images and drawing animals: `loadImages()`, `drawObject()`. |
| `IMoveable` | Methods for animal movement: `getAnimalName()`, `getSpeed()`, `move()`. |
| `IAnimal` | Combines IMoveable with animal-specific behavior. |
| `IClonable` | For cloning animal objects. |

---

### Assignment 3: Multithreading & Concurrency
**Topics:** Threads, Synchronization, wait/notify, Race Conditions

Added real-time race simulation with multithreading:

| Class | Description |
|-------|-------------|
| `AnimalThread` | Implements `Runnable`. Moves animal forward, waits for start signal, notifies on finish. Uses `synchronized` blocks and `wait()`/`notify()`. |
| `Scores` | Thread-safe score storage using `Collections.synchronizedMap()`. Records finish times. |
| `Referee` | Waits for animals to finish, records their times to Scores. |
| `Tournament` | Manages multiple competitions and coordinates threads. |

**Competition Types:**
| Type | Animals |
|------|---------|
| 🏃 Running | Dog, Cat, Snake, Alligator |
| 🏊 Swimming | Whale, Dolphin, Alligator |
| 🦅 Flying | Eagle, Pigeon |

**Thread Synchronization:**
- `startFlag` - shared Boolean for race start signal
- `finishFlag` - shared Boolean for finish notification
- Synchronized blocks on animal movement to prevent race conditions

  
## 👩‍💻 Contributors
Linoy Nisim Pur  
Noa Shem Tov


---

## 📄 License

Academic coursework at SCE College of Engineering.
