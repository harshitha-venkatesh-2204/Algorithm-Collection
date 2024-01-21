import csv
import numpy as np
import time
import sys

def read_graph_from_csv(file_path, num_nodes):
    graph = np.full((num_nodes, num_nodes), np.inf)
    np.fill_diagonal(graph, 0)  
    
    with open(file_path, 'r') as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader) 
        for row in csv_reader:
            from_node, to_node, distance = int(row[0]), int(row[1]), float(row[2])
            graph[from_node, to_node] = distance
            
    return graph

def floyd_warshall(graph):
    num_nodes = len(graph)
    distance_matrix = np.copy(graph)
    next_node_matrix = np.zeros((num_nodes, num_nodes), dtype=int)
    
    for i in range(num_nodes):
        for j in range(num_nodes):
            next_node_matrix[i, j] = j
    
    for k in range(num_nodes):
        for i in range(num_nodes):
            for j in range(num_nodes):
                if distance_matrix[i, k] + distance_matrix[k, j] < distance_matrix[i, j]:
                    distance_matrix[i, j] = distance_matrix[i, k] + distance_matrix[k, j]
                    next_node_matrix[i, j] = next_node_matrix[i, k]
    
    return distance_matrix, next_node_matrix

def reconstruct_path(start_node, end_node, next_node_matrix):
    path = []
    if next_node_matrix[start_node, end_node] == 0:
        return path
    
    path.append(start_node)
    while start_node != end_node:
        start_node = next_node_matrix[start_node, end_node]
        path.append(start_node)
    
    return path

def main(num_nodes, test_casesfile4, test_cases):
    total_time = 0
   
   
    
    for test_case in test_casesfile4:
        file_index, start_node, end_node = test_case
        file_path_template = "c:/Users/harsh/Project2_Input_File/Project2_Input_File{}.csv"
        file_path = file_path_template.format(file_index)

        adjacency_list = read_graph_from_csv(file_path, num_nodes)

        start_time = time.time()
        distance_matrix, next_node_matrix = floyd_warshall(adjacency_list)
        end_time = time.time()

        total_time += end_time - start_time
        memory_usage = sys.getsizeof(graph)

        distance = distance_matrix[start_node , end_node]

        path = reconstruct_path(start_node, end_node, next_node_matrix)

        print(f"\nTest Case: {test_case}")
        print(f"From Node: {start_node}\nTo Node: {end_node}")
        print(f"Distance: {distance} feet")
        print(f"Path: {path}\n")
            
    for test_case in test_cases:
        file_index, start_node, end_node = test_case
        file_path_template = "c:/Users/harsh/Project2_Input_File/Project2_Input_File{}.csv"
        file_path = file_path_template.format(file_index)

        adjacency_list = read_graph_from_csv(file_path, num_nodes)

        start_time = time.time()
        distance_matrix, next_node_matrix = floyd_warshall(adjacency_list)
        end_time = time.time()

        total_time += end_time - start_time
        memory_usage = sys.getsizeof(graph)

        distance = distance_matrix[start_node , end_node]

        path = reconstruct_path(start_node, end_node, next_node_matrix)
        print(f"\nTest Case: {test_case}")
        print(f"Total time taken: {total_time:.4f} seconds")
        print(f"Total memory: {memory_usage:.4f} MiB")
        
            

          
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
        (13,0, 1444),
        (14,0, 1566),
        (15, 0, 1716),
      
    ]
    
    main(num_nodes,test_casesfile4,test_cases)


        
      
