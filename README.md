🚑 SMARTROUTE – Urban Emergency Road Routing System

A Dynamic Shortest-Path Routing System Using Java and Graph Algorithms

---

📌 Project Overview

SMARTROUTE is a Java-based Urban Emergency Road Routing System designed to identify the fastest available routes for emergency vehicles such as ambulances, fire engines, and police vehicles.

In urban areas, emergency vehicles often face challenges such as road closures, one-way restrictions, construction activities, and changing road conditions. These situations can make previously selected routes unavailable and cause delays in emergency response.

SMARTROUTE addresses this problem using graph data structures and Dijkstra's Shortest Path Algorithm to calculate the fastest available route dynamically.

This project is developed under UN Sustainable Development Goal 11 (SDG 11) – Sustainable Cities and Communities.

---

🎯 Problem Statement

Civil Engineering and Urban Planning (SDG 11): Urban Emergency Road Routing

The objective is to compute the fastest emergency routes under road closures by representing city roads as a weighted graph and implementing shortest-path algorithms.

The system should support:

- Weighted graph representation of city roads.
- Dijkstra's algorithm using a priority queue.
- Dynamic road addition and deletion.
- Calculation of route, total distance, and travel time.
- Handling one-way roads and road closures.
- Comparison with Bellman-Ford for special cases.
- Complexity analysis and map-style output.

---

💡 Proposed Solution

SMARTROUTE models a city's road network as a weighted graph.

- Vertices: Represent city locations and intersections.
- Edges: Represent roads connecting locations.
- Weights: Represent road distance and estimated travel time.
- Priority Queue: Helps process locations with the minimum travel time.
- Dijkstra's Algorithm: Identifies the fastest available route.

Whenever a road is closed or reopened, the graph is updated and the algorithm is executed again to calculate the updated fastest route.

---

✨ Features

- Fastest Route Calculation: Finds the minimum travel-time route using Dijkstra's algorithm.
- Weighted Graph Representation: Stores road distance and travel time.
- Dynamic Road Management: Supports adding and deleting roads.
- Road Closure Simulation: Finds alternative routes when roads become unavailable.
- One-Way Road Support: Respects directional road restrictions.
- Distance and Time Calculation: Displays total distance and estimated travel time.
- Unreachable Destination Detection: Identifies when no valid route exists.
- Menu-Driven Interface: Provides interactive options through the console.

---

🛠️ Technologies Used

Technology| Purpose
Java| Programming language
Graph| City road network representation
HashMap| Adjacency list implementation
ArrayList| Stores connected roads
PriorityQueue| Efficient minimum-cost selection
Dijkstra's Algorithm| Fastest route calculation
Scanner| User input handling

---

🧠 Data Structures and Algorithms

1. Graph

The city road network is represented using an adjacency list.

2. Priority Queue

A Java PriorityQueue processes the location with the minimum accumulated travel time.

3. Dijkstra's Algorithm

Finds the shortest path based on non-negative travel-time weights.

4. Dynamic Graph Operations

Roads can be added or removed while the application is running.

5. Path Reconstruction

Parent information is maintained to reconstruct the selected route from source to destination.

---

🗺️ Sample City Road Network

The sample network contains six locations:

Location ID| Description
1| Hospital
2| Junction A
3| Junction B
4| Junction C
5| Junction D
6| Accident Location

Sample road connections:

From| To| Distance| Travel Time
1| 2| 4 km| 5 min
1| 3| 2 km| 3 min
2| 4| 3 km| 4 min
3| 4| 2 km| 2 min
4| 6| 5 km| 6 min
2| 6| 8 km| 10 min
3| 5| 3 km| 4 min
5| 6| 2 km| 3 min

---

▶️ How to Run the Project

Prerequisites

- Java Development Kit (JDK 8 or above).
- Visual Studio Code / IntelliJ IDEA / Eclipse.
- Java Extension Pack (for VS Code).

Steps

1. Clone the repository

git clone YOUR_GITHUB_REPOSITORY_URL

2. Navigate to the project directory

cd SMARTROUTE

3. Compile the Java program

javac Main.java

4. Execute the program

java Main

---

🖥️ Application Menu

===== URBAN EMERGENCY ROUTING =====

1. Display Road Network
2. Find Fastest Route
3. Close Road
4. Add/Reopen Road
5. Exit

Enter choice:

---

📊 Sample Execution

Scenario 1: Normal Road Network

Input:

Enter choice: 2

Enter source: 1
Enter destination: 6

Output:

--- EMERGENCY ROUTE ---

Route: 1 -> 3 -> 5 -> 6

Total Distance: 7.0 km

Travel Time: 10.0 minutes

Scenario 2: Road Closure

Suppose road 3 ↔ 5 is closed.

The system removes the road from the graph and recalculates the fastest route.

Output:

--- EMERGENCY ROUTE ---

Route: 1 -> 3 -> 4 -> 6

Total Distance: 9.0 km

Travel Time: 11.0 minutes

Scenario 3: Road Reopening

After reopening road 3 ↔ 5, the original fastest route becomes available again.

Output:

--- EMERGENCY ROUTE ---

Route: 1 -> 3 -> 5 -> 6

Total Distance: 7.0 km

Travel Time: 10.0 minutes

---

⏱️ Time Complexity Analysis

Let:

- V = Number of vertices (locations).
- E = Number of edges (roads).

Operation| Time Complexity
Graph creation| O(V + E)
Dijkstra's Algorithm| O((V + E) log V)
Road addition| O(1) amortized
Road deletion| O(degree of vertex)
Path reconstruction| O(V)

---

🌍 SDG 11 – Sustainable Cities and Communities

SMARTROUTE contributes to SDG 11 by demonstrating how graph algorithms and computational techniques can support smarter urban infrastructure and emergency route planning.

The system aims to:

- Improve emergency route planning.
- Adapt to changing road conditions.
- Reduce unnecessary travel time.
- Support efficient urban mobility.

---

🚀 Future Enhancements

- Integration with real-time traffic data.
- Interactive graphical city map.
- GPS-based location tracking.
- Automatic road closure updates.
- Bellman-Ford algorithm implementation and comparison.
- Emergency vehicle prioritization.
- Integration with mapping services.

---

⚠️ Limitations

- Uses a predefined sample road network.
- Does not currently receive live traffic information.
- Road closures are entered manually.
- Travel times are predefined estimates.
- The current implementation uses a console-based interface.

---

👩‍💻 Project Information

Project Title: SMARTROUTE – Urban Emergency Road Routing System

Domain: Data Structures and Algorithms

Subject Area: Single Source Shortest Path (SSSP)

Programming Language: Java

Algorithm: Dijkstra's Shortest Path Algorithm

SDG: 11 – Sustainable Cities and Communities

---

Conclusion

SMARTROUTE demonstrates the application of graph data structures and shortest-path algorithms to a real-world urban planning problem. By supporting dynamic road network modifications and fastest-route calculation, the system provides a foundation for intelligent emergency navigation and more efficient urban mobility.

Building smarter routes for faster emergency response. 🚑
