"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function linear_search(haystack, needle) {
    for (var i = 0; i < haystack.length; i++) {
        if (haystack[i] === needle) {
            return true;
        }
    }
    return false;
}
exports.default = linear_search;
