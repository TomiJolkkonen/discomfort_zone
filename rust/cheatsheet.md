// Variables and Data Types
let x: i32 = 10;
let mut y: f64 = 3.14; // Mutable
let z = "Hello"; // Immutable
const PI: f64 = 3.1415; // Constant

// Control Structures
if x > 5 { println!("Greater!"); }
for i in 0..10 { println!("{}", i); }
while y > 0.0 { y -= 1.0; }

// Functions
fn add(a: i32, b: i32) -> i32 { a + b }

// Structs
struct Car { brand: String, speed: u32 }
impl Car {
    fn honk(&self) { println!("Beep!"); }
}

// Enums
enum Direction { Up, Down, Left, Right }

// Vectors
let mut nums = vec![1, 2, 3];
nums.push(4);
