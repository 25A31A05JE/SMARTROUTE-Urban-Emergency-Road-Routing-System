import java.util.*;

class Edge {
    int destination;
    double distance, time;

    Edge(int destination, double distance, double time) {
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }
}

class Node {
    int vertex;
    double time;

    Node(int vertex, double time) {
        this.vertex = vertex;
        this.time = time;
    }
}

class Graph {

    Map<Integer, List<Edge>> adj = new HashMap<>();

    void addRoad(int u, int v, double distance,
                 double time, boolean twoWay) {

        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());

        adj.get(u).add(new Edge(v, distance, time));

        if (twoWay) {
            adj.get(v).add(new Edge(u, distance, time));
        }
    }

    void deleteRoad(int u, int v, boolean twoWay) {

        if (adj.containsKey(u)) {
            adj.get(u).removeIf(e -> e.destination == v);
        }

        if (twoWay && adj.containsKey(v)) {
            adj.get(v).removeIf(e -> e.destination == u);
        }

        System.out.println("Road closed successfully!");
    }

    void dijkstra(int source, int destination) {

        Map<Integer, Double> time = new HashMap<>();
        Map<Integer, Double> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (int v : adj.keySet()) {
            time.put(v, Double.POSITIVE_INFINITY);
            distance.put(v, Double.POSITIVE_INFINITY);
        }

        if (!adj.containsKey(source) ||
            !adj.containsKey(destination)) {
            System.out.println("Invalid location!");
            return;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            Comparator.comparingDouble(n -> n.time)
        );

        time.put(source, 0.0);
        distance.put(source, 0.0);

        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();
            int u = current.vertex;

            if (current.time > time.get(u))
                continue;

            for (Edge e : adj.get(u)) {

                int v = e.destination;

                double newTime = time.get(u) + e.time;

                if (newTime < time.get(v)) {

                    time.put(v, newTime);

                    distance.put(v,
                        distance.get(u) + e.distance);

                    parent.put(v, u);

                    pq.add(new Node(v, newTime));
                }
            }
        }

        if (time.get(destination) == Double.POSITIVE_INFINITY) {
            System.out.println("No available route!");
            return;
        }

        List<Integer> path = new ArrayList<>();

        int current = destination;

        while (current != source) {
            path.add(current);
            current = parent.get(current);
        }

        path.add(source);
        Collections.reverse(path);

        System.out.println("\n--- EMERGENCY ROUTE ---");

        System.out.print("Route: ");

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));

            if (i != path.size() - 1)
                System.out.print(" -> ");
        }

        System.out.println("\nTotal Distance: "
            + distance.get(destination) + " km");

        System.out.println("Travel Time: "
            + time.get(destination) + " minutes");
    }

    void displayRoads() {

        System.out.println("\nCity Road Network:");

        for (int u : adj.keySet()) {
            System.out.print(u + " -> ");

            for (Edge e : adj.get(u)) {
                System.out.print(e.destination +
                    "(" + e.time + " min) ");
            }

            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();

        // Sample city roads

        g.addRoad(1, 2, 4, 5, true);
        g.addRoad(1, 3, 2, 3, true);
        g.addRoad(2, 4, 3, 4, true);
        g.addRoad(3, 4, 2, 2, true);
        g.addRoad(4, 6, 5, 6, true);
        g.addRoad(2, 6, 8, 10, true);
        g.addRoad(3, 5, 3, 4, true);
        g.addRoad(5, 6, 2, 3, true);

        int choice;

        do {

            System.out.println("\n===== URBAN EMERGENCY ROUTING =====");
            System.out.println("1. Display Road Network");
            System.out.println("2. Find Fastest Route");
            System.out.println("3. Close Road");
            System.out.println("4. Add/Reopen Road");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    g.displayRoads();
                    break;

                case 2:

                    System.out.print("Enter source: ");
                    int s = sc.nextInt();

                    System.out.print("Enter destination: ");
                    int d = sc.nextInt();

                    g.dijkstra(s, d);
                    break;

                case 3:

                    System.out.print("Enter first location: ");
                    int u = sc.nextInt();

                    System.out.print("Enter second location: ");
                    int v = sc.nextInt();

                    System.out.print("Two-way road (true/false): ");
                    boolean both = sc.nextBoolean();

                    g.deleteRoad(u, v, both);
                    break;

                case 4:

                    System.out.print("Enter first location: ");
                    int a = sc.nextInt();

                    System.out.print("Enter second location: ");
                    int b = sc.nextInt();

                    System.out.print("Enter distance: ");
                    double dist = sc.nextDouble();

                    System.out.print("Enter travel time: ");
                    double t = sc.nextDouble();

                    System.out.print("Two-way road (true/false): ");
                    boolean twoWay = sc.nextBoolean();

                    g.addRoad(a, b, dist, t, twoWay);

                    System.out.println("Road added successfully!");
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}