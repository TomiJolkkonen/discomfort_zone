import pygame
import random
import math

# Initialize Pygame
pygame.init()

# Screen settings
WIDTH, HEIGHT = 800, 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Simple Asteroids Game")

# Colors
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)

# Player
player_pos = [WIDTH // 2, HEIGHT // 2]
player_speed = 5

# Bullets
bullets = []

# Asteroids
asteroids = []
for _ in range(5):
    x = random.randint(0, WIDTH)
    y = random.randint(0, HEIGHT)
    speed = random.uniform(1, 3)
    angle = random.uniform(0, math.pi * 2)
    asteroids.append({'pos': [x, y], 'speed': speed, 'angle': angle})

clock = pygame.time.Clock()

running = True
while running:
    clock.tick(60)
    screen.fill(BLACK)

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Controls
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]:
        player_pos[0] -= player_speed
    if keys[pygame.K_RIGHT]:
        player_pos[0] += player_speed
    if keys[pygame.K_UP]:
        player_pos[1] -= player_speed
    if keys[pygame.K_DOWN]:
        player_pos[1] += player_speed
    if keys[pygame.K_SPACE]:
        bullets.append({'pos': player_pos.copy(), 'speed': 10})

    # Draw player (triangle)
    pygame.draw.polygon(screen, WHITE, [
        (player_pos[0], player_pos[1] - 10),
        (player_pos[0] - 10, player_pos[1] + 10),
        (player_pos[0] + 10, player_pos[1] + 10)
    ])

    # Update and draw bullets
    for bullet in bullets[:]:
        bullet['pos'][1] -= bullet['speed']
        pygame.draw.circle(screen, WHITE, bullet['pos'], 3)
        if bullet['pos'][1] < 0:
            bullets.remove(bullet)

    # Update and draw asteroids
    for asteroid in asteroids:
        x, y = asteroid['pos']
        x += math.cos(asteroid['angle']) * asteroid['speed']
        y += math.sin(asteroid['angle']) * asteroid['speed']
        asteroid['pos'] = [x % WIDTH, y % HEIGHT]
        pygame.draw.circle(screen, WHITE, (int(x), int(y)), 20)

    pygame.display.flip()

pygame.quit()
