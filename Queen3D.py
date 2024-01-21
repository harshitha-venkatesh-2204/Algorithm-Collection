def is_safe(board, row, col, depth, n):
    # Check for queens in the same row, column, and depth layer
    for i in range(n):
        if board[row][i][depth] == 1 or board[i][col][depth] == 1 or board[row][col][i] == 1:
            return False

    # Check for queens in the allowed diagonals in 3D
    for i in range(-1, 2):
        for j in range(-1, 2):
            for k in range(-1, 2):
                if i == 0 and j == 0 and k == 0:
                    continue  # Skip the case where all values are 0
                for m in range(1, n):
                    if 0 <= row + i * m < n and 0 <= col + j * m < n and 0 <= depth + k * m < n:
                        if board[row + i * m][col + j * m][depth + k * m] == 1:
                            return False

    return True

def solve_nqueens_3d(board, depth, n):
    if depth == n:
        return 1

    count = 0
    for i in range(n):
        for j in range(n):
            if is_safe(board, i, j, depth, n):
                board[i][j][depth] = 1
                count += solve_nqueens_3d(board, depth + 1, n)
                board[i][j][depth] = 0

    return count

def count_3d_nqueens(n):
    board = [[[0 for _ in range(n)] for _ in range(n)] for _ in range(n)]
    return solve_nqueens_3d(board, 0, n)

# Test the function for n = 2, 3, 4, 5
for n in range(2, 6):
    print(f"Number of legal configurations for n = {n}: {count_3d_nqueens(n)}")
