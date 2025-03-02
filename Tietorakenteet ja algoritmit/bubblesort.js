"use strict";
// bubblesort: jos olen isompi kuin sinä, vaihdetaan paikkaa. O(n2)
Object.defineProperty(exports, "__esModule", { value: true });
function bubble_sort(arr) {
    for (var i = 0; i < arr.length; ++i) {
        for (var j = 0; j < arr.length - 1 - i; ++j) {
            if (arr[j] > arr[j + 1]) {
                var tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }
}
exports.default = bubble_sort;
