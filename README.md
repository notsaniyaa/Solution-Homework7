
# Part1 - Streaming Service Binge Mode – Iterator Pattern

## Overview

This project implements the **Iterator Design Pattern** to traverse through TV series episodes stored in different ways.  
The idea is to hide collection internals and provide a uniform way to iterate over episodes regardless of how they are stored.

The project includes:
- **Normal iteration** (SeasonIterator)
- **Reverse iteration** (ReverseSeasonIterator)
- **Shuffle iteration** (ShuffleSeasonIterator)
- **Binge iteration across seasons** (BingeIterator)

The project also makes `Season` implement `Iterable<Episode>` to support Java's enhanced for-loop (`for (Episode e : season)`).

---

## Why Use the Iterator Pattern?

Instead of exposing the internal structure (`List<Episode>`, `LinkedList<Episode>`, or even a file loader), the **Iterator Pattern**:
- **Encapsulates** the traversal logic.
- **Separates** concerns between data storage and data usage.
- **Allows multiple traversal strategies** (normal, reverse, shuffle).
- **Simplifies client code**, e.g., easy to use `hasNext()` and `next()`.

This improves **flexibility**, **maintainability**, and **readability** of the codebase.

---

## Project Structure

![image](https://github.com/user-attachments/assets/b2e4ed93-9dcf-4a14-a8af-388fffb18d1a)


---

## How It Works

- `Episode`: Represents a single episode (title, runtime in seconds).
- `Season`: Stores a collection of episodes and provides three types of iterators:
  - Normal (SeasonIterator)
  - Reverse (ReverseSeasonIterator)
  - Shuffle (ShuffleSeasonIterator)
- `Series`: A collection of Seasons.
- `BingeIterator`: Allows continuous viewing across multiple seasons without manual switching.

`DemoMain.java` demonstrates the functionality by:
- Creating a sample Series with two Seasons.
- Printing episodes in normal order.
- Printing all episodes across seasons using BingeIterator.

---

## How to Run

![image](https://github.com/user-attachments/assets/57f87b58-b55d-4b2d-af87-c7b3741d2858)

# Part2 - Streaming Service Binge Mode – Iterator Pattern

## Overview

This project implements the **Iterator Design Pattern** to traverse through TV series episodes stored in different ways.  
The idea is to hide collection internals and provide a uniform way to iterate over episodes regardless of how they are stored.

The project includes:
- **Normal iteration** (`SeasonIterator`)
- **Reverse iteration** (`ReverseSeasonIterator`)
- **Shuffle iteration** (`ShuffleSeasonIterator`)
- **Binge iteration across seasons** (`BingeIterator`)

The project also makes `Season` implement `Iterable<Episode>` to support Java's enhanced for-loop (`for (Episode e : season)`).

---

## Why Use the Iterator Pattern?

Instead of exposing the internal structure (`List<Episode>`, `LinkedList<Episode>`, or even a file loader), the **Iterator Pattern**:
- **Encapsulates** the traversal logic.
- **Separates** concerns between data storage and data usage.
- **Allows multiple traversal strategies** (normal, reverse, shuffle).
- **Simplifies client code**, e.g., easy to use `hasNext()` and `next()`.

This improves **flexibility**, **maintainability**, and **readability** of the codebase.

---

## Project Structure

![image](https://github.com/user-attachments/assets/8a4ffa01-47fa-40a6-a901-eb34d1d4044a)


## How It Works

- `Episode`: Represents a single episode (title, runtime in seconds).
- `Season`: Stores a collection of episodes and provides three types of iterators:
  - Normal (`SeasonIterator`)
  - Reverse (`ReverseSeasonIterator`)
  - Shuffle (`ShuffleSeasonIterator`)
- `Series`: A collection of Seasons.
- `BingeIterator`: Allows continuous viewing across multiple seasons without manual switching.

`DemoMain.java` demonstrates the functionality by:
- Creating a sample `Series` with two `Season` objects.
- Printing episodes in normal order.
- Printing all episodes across seasons using `BingeIterator`.

---

## How to Run

![image](https://github.com/user-attachments/assets/1a4933de-5c11-41ee-a21e-e8d6dda1748d)
