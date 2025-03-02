import numpy as np
import matplotlib.pyplot as plt

a=np.array([2, 5, 7, 4, 7, 0, 3, 1, 9, 2])

plt.plot(a)                   # plot the points in the array a
plt.title("My first figure")  # Add a title to the figure
plt.xlabel("My x-axis")       # Give a label to the x-axis
plt.ylabel("My y-axis")       # Give a label to the y-axis
plt.show()                    # Tell matplotlib to output the figure.
