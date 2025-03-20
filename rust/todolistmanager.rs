use std::fs::{OpenOptions, read_to_string, remove_file};
use std::io::{self, Write};

const FILE_NAME: &str = "todo.txt";

fn add_task(task: &str) {
    let mut file = OpenOptions::new().append(true).create(true).open(FILE_NAME).unwrap();
    writeln!(file, "{}", task).unwrap();
    println!("Task added: {}", task);
}

fn list_tasks() {
    match read_to_string(FILE_NAME) {
        Ok(contents) => {
            if contents.is_empty() {
                println!("No tasks found.");
            } else {
                println!("Your tasks:");
                for (i, task) in contents.lines().enumerate() {
                    println!("{}: {}", i + 1, task);
                }
            }
        }
        Err(_) => println!("No tasks found."),
    }
}

fn clear_tasks() {
    if remove_file(FILE_NAME).is_ok() {
        println!("All tasks cleared.");
    } else {
        println!("No tasks to clear.");
    }
}

fn main() {
    loop {
        println!("\nTo-Do List Manager");
        println!("1. Add Task");
        println!("2. List Tasks");
        println!("3. Clear All Tasks");
        println!("4. Quit");
        print!("Choose an option: ");
        io::stdout().flush().unwrap();

        let mut choice = String::new();
        io::stdin().read_line(&mut choice).unwrap();

        match choice.trim() {
            "1" => {
                print!("Enter task: ");
                io::stdout().flush().unwrap();
                let mut task = String::new();
                io::stdin().read_line(&mut task).unwrap();
                add_task(task.trim());
            }
            "2" => list_tasks(),
            "3" => clear_tasks(),
            "4" => break,
            _ => println!("Invalid choice, try again."),
        }
    }
}
