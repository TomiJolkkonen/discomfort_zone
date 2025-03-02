// notes
const add = (x, y) => x + y

const toPair = f => 
    ([x, y]) => f(x, y)

const FromPair = f =>
    (x, y) => f([x, y]) 

const result = FromPair(toPair(add))(1,2)

console.log(result)
