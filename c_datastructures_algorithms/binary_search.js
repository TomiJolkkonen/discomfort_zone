"use strict";
// binäärihaku O(log n)
Object.defineProperty(exports, "__esModule", { value: true });
function bs_list(haystack, needle) {
    var lo = 0;
    var hi = haystack.length;
    do {
        var m = Math.floor(lo + (hi - lo) / 2);
        var v = haystack[m];
        if (v === needle) {
            return true;
        }
        else if (v > needle) {
            hi = m;
        }
        else {
            lo = m + 1;
        }
    } while (lo < hi);
    return false;
}
exports.default = bs_list;
