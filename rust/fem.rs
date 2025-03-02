/*
What can I build with Rust?
- web servers
- cli s
- native desktop applications
- operating systems, linux kernel even
- in-browser apps via webassembly
- performance-intensive libraries

Why use Rust? 
- speed
- performance, efficient
- going real fast
- reliable
- C/C++ level performance with
    - nice ergonomics and a language server
    - automatic memory mgmgt
    - a package manager and code formatter
    - more compiler help with concurrency
    - rust ia s big language, lots to learn
    - smaller ecosystem than C/C++ but FFI (foreign function interface, but you start loose safety)
    - slower iteration cycle than most languages (strict compiler, satisfying/fighing the borrow checker, slow compile times for full builds, tests can take awhile to build)
    - safer than C++, less safe than e.g. pure FP
*/


fn main() {
    let answer = multiply_both(1.1, 2.2);

    println!("1.1 x 2.2 = {}", answer)
}

fn multiply_both(x: f64, y: f64) -> f64 {
    x * y
}


