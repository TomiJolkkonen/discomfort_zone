use std::{thread, time::Duration};

fn countdown_timer(seconds: u64) {
    for i in (1..=seconds).rev() {
        println!("Time left: {} seconds", i);
        thread::sleep(Duration::from_secs(1));
    }
    println!("Time's up!");
}

fn main() {
    println!("Enter countdown time in seconds:");
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).expect("Failed to read input");
    let seconds: u64 = input.trim().parse().expect("Please enter a valid number");
    
    countdown_timer(seconds);
}
