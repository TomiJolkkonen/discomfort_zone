function foo(n) {
    // Base case
    if (n === 1) {
        return 1;
    }
    // We shall recurse!
    return n + foo(n - 1);
}
