from collections import deque

def read_maze(file_path):
    with open(file_path, 'r') as file:
        maze = [list(line.strip('\n')) for line in file]
    return maze

def find_position(maze, symbol):
    for y, row in enumerate(maze):
        for x, char in enumerate(row):
            if char == symbol:
                return (x, y)
    return None

def bfs(maze, start, end):
    queue = deque()
    queue.append((start, [start]))
    visited = set()

    while queue:
        (x, y), path = queue.popleft()
        if (x, y) == end:
            return path
        for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]:
            nx, ny = x + dx, y + dy
            if (0 <= nx < len(maze[0]) and
                0 <= ny < len(maze) and
                maze[ny][nx] != '#' and
                (nx, ny) not in visited):
                queue.append(((nx, ny), path + [(nx, ny)]))
                visited.add((nx, ny))
    return None

def mark_path(maze, path):
    for x, y in path:
        if maze[y][x] not in ('S', 'E'):
            maze[y][x] = '.'

def print_maze(maze):
    for row in maze:
        print(''.join(row))

def main():
    maze = read_maze('maze.txt')
    start = find_position(maze, 'S')
    end = find_position(maze, 'E')

    if not start or not end:
        print("Start or End position not found.")
        return

    path = bfs(maze, start, end)

    if path:
        print(f"Path found! Steps: {len(path)}")
        mark_path(maze, path)
    else:
        print("No path found.")

    print_maze(maze)

if __name__ == "__main__":
    main()
