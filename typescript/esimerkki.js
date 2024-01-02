function sum_char_codes(n) {
    var sum = 0;
    for (var i = 0; i < n.length; ++i) {
        sum += n.charCodeAt(i);
    }
    return sum;
}
