"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function linearSearch(nums, target) {
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] === target)
            return i;
    }
    return -1;
}
exports.default = linearSearch;
