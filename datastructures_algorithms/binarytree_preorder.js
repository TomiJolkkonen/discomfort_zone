"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function walk(curr, path) {
    if (!curr) {
        return path;
    }
    path.push(curr.value);
    walk(curr.left, path);
    walk(curr.right, path);
    return path;
}
function pre_order_search(head) {
    var path = [];
    walk(head, path);
    return path;
}
exports.default = pre_order_search;
