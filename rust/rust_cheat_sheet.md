
# Rust Practical Cheat Sheet

A concise reference with practical Rust tips from *Rust in Action*.

---

## 🛠 Basic Syntax

```rust
// Variables
let x = 5;
let mut y = 10;

// Constants
const MAX_POINTS: u32 = 100;

// Functions
fn add(a: i32, b: i32) -> i32 {
    a + b
}

// Control Flow
if x > y {
    println!("x is bigger");
} else {
    println!("y is bigger");
}

for i in 0..5 {
    println!("{}", i);
}
```

---

## 🏗 Common Data Types

```rust
// Arrays
let arr = [1, 2, 3];

// Vectors
let mut vec = Vec::new();
vec.push(4);

// Slices
let slice = &arr[1..3];

// Structs
struct User {
    name: String,
    age: u32,
}
impl User {
    fn new(name: String, age: u32) -> Self {
        Self { name, age }
    }
}

// Enums
enum Status {
    Active,
    Inactive,
}
```

---

## 🔁 Iteration

```rust
let numbers = vec![1, 2, 3];
for num in &numbers {
    println!("{}", num);
}

// While loop
let mut counter = 0;
while counter < 5 {
    counter += 1;
}

// Loop with break
loop {
    break;
}
```

---

## 🚀 Error Handling

```rust
fn divide(a: f64, b: f64) -> Result<f64, String> {
    if b == 0.0 {
        Err(String::from("Cannot divide by zero"))
    } else {
        Ok(a / b)
    }
}

let result = divide(10.0, 2.0);
match result {
    Ok(v) => println!("Result: {}", v),
    Err(e) => println!("Error: {}", e),
}
```

---

## 🧵 Concurrency Basics

```rust
use std::thread;

let handle = thread::spawn(|| {
    for i in 1..5 {
        println!("Spawned thread: {}", i);
    }
});

handle.join().unwrap();
```

---

## 🛠 Useful Crates & Tools

- `cargo` – Build, run, test projects
  - `cargo build`
  - `cargo run`
  - `cargo test`
- `rayon` – Parallel iterators
- `serde` – Serialization/deserialization
- `reqwest` – HTTP client
- `regex` – Regular expressions

---

## 🏗 Handy Patterns

```rust
// Match
let number = 7;
match number {
    1 => println!("One"),
    2..=10 => println!("Between 2 and 10"),
    _ => println!("Something else"),
}

// Closures
let add = |a, b| a + b;
println!("{}", add(2, 3));

// Option handling
let maybe_value: Option<i32> = Some(10);
if let Some(value) = maybe_value {
    println!("Value: {}", value);
}
```

---

## ✅ Tips
- Use `.iter()`, `.iter_mut()`, `.into_iter()` for collections.
- Use `.unwrap_or()`, `.unwrap_or_else()` for `Option` defaults.
- Remember `ownership`, `borrowing`, and `lifetimes` to avoid compile errors.
- Prefer `.expect()` and `.unwrap()` carefully, handle errors gracefully.

---

Happy Rust coding! 🚀
