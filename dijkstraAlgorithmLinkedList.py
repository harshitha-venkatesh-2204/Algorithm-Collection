import csv
import numpy as np
import time
from memory_profiler import memory_usage

class Node:
    def __init__(self, to_node, distance):
        self.to_node = to_node
        self.distance = distance
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def add_edge(self, to_node, distance):
        new_node = Node(to_node, distance)
        new_node.next = self.head
        self.head = new_node

def read_graph_from_csv(file_path, num_nodes):
    graph = [LinkedList() for _ in range(num_nodes)]

    with open(file_path, 'r') as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)

        for row in csv_reader:
            from_node, to_node, distance = int(row[0]), int(row[1]), float(row[2])
            graph[from_node].add_edge(to_node, distance)

    return graph

def dijkstra(graph, start_node):
    num_nodes = len(graph)
    distances = np.full(num_nodes, np.inf)
    distances[start_node] = 0
    unvisited = set(range(num_nodes))
    previous_nodes = [None] * num_nodes

    while unvisited:
        current_node = min(unvisited, key=lambda node: distances[node])
        unvisited.remove(current_node)

        for neighbor in range(num_nodes):
            edge = graph[current_node].head
            while edge is not None:
                if edge.to_node == neighbor:
                    weight = edge.distance
                    potential_distance = distances[current_node] + weight
                    if potential_distance < distances[neighbor]:
                        distances[neighbor] = potential_distance
                        previous_nodes[neighbor] = current_node
                edge = edge.next

    return distances, previous_nodes

def reconstruct_path(start_node, end_node, previous_nodes):
    path = []
    current_node = end_node

    while current_node is not None:
        path.insert(0, current_node)
        current_node = previous_nodes[current_node]

    return path

def main(num_nodes, test_casesfile4, test_cases):
    total_time = 0
    total_mem_usage = 0
    
    for test_case in test_casesfile4:
        file_index, start_node, end_node = test_case
        file_path_template = "c:/Users/harsh/Project2_Input_File/Project2_Input_File{}.csv"
        file_path = file_path_template.format(file_index)

        graph = read_graph_from_csv(file_path, num_nodes)

        distances, previous_nodes = dijkstra(graph, start_node)

        if distances[end_node] == np.inf:
            print("No path found.")
        else:
            path = reconstruct_path(start_node, end_node, previous_nodes)
            distance = distances[end_node]

            print(f"\nTest Case: {test_case}")
            print(f"From Node: {start_node}\nTo Node: {end_node}")
            print(f"Distance: {distance} feet")
            print(f"Path: {path}\n")
            print(f"Total time taken: {total_time:.4f} seconds")
            print(f"Total memory: {total_mem_usage:.4f} MiB")


    for test_case in test_cases:
        file_index, start_node, end_node = test_case
        file_path_template = "c:/Users/harsh/Project2_Input_File/Project2_Input_File{}.csv"
        file_path = file_path_template.format(file_index)

        graph = read_graph_from_csv(file_path, num_nodes)

        start_time = time.time()
        mem_usage_before = memory_usage()[0]
        distances, previous_nodes = dijkstra(graph, start_node)
        mem_usage_after = memory_usage()[0]
        end_time = time.time()

        total_time += end_time - start_time
        total_mem_usage += mem_usage_after - mem_usage_before

        if distances[end_node] == np.inf:
            print("No path found.")
        else:
            path = reconstruct_path(start_node, end_node, previous_nodes)
            distance = distances[end_node]

            print(f"\nTest Case: {test_case}")
            print(f"Total time taken: {total_time:.4f} seconds")
            print(f"Total memory: {total_mem_usage:.4f} MiB")

if __name__ == "__main__":
    num_nodes = 1720

    test_casesfile4 = [
        (4, 192, 163),
        (4, 138, 66),
        (4, 465, 22)
    ]
    test_cases = [
        (1, 0, 199),
        (2, 0, 280),
        (3, 0, 392),
        (4, 0, 476),
        (5, 0, 558),
        (6, 0, 646),
        (7, 0, 755),
        (8, 0, 844),
        (9, 0, 958),
        (10, 0, 1098),
        (11, 0, 1212),
        (12, 0, 1320),
        (13, 0, 1444),
        (14, 0, 1566),
        (15, 0, 1716),
    ]

    main(num_nodes, test_casesfile4, test_cases)
