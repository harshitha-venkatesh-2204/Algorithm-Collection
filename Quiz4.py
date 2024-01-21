import math

def function(x):
    return 10**(-x)

def derivative_function(x):
    return -10**(-x) * math.log(10)

def newtons_method(initial_guess, tolerance, max_iterations):
    x = initial_guess
    for i in range(max_iterations):
        f_x = function(x)
        f_prime_x = derivative_function(x)
        if abs(f_prime_x) < tolerance:
            print("Derivative too small. Newton's method stops.")
            break
        x -= f_x / f_prime_x
        print(f"Iteration {i + 1}: x = {x:.5f}")
        if i == 4:
            break  
    return x

initial_guess = 0.5
tolerance = 1e-6
max_iterations = 5 

result = newtons_method(initial_guess, tolerance, max_iterations)
print(f"\nApproximation of 10^(-1/3) using Newton's method after 5 iterations: {result:.5f}")
