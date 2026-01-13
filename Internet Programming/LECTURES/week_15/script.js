let rows = 3;
let cols = 3;
let counter = 1;
let matrix = [];
let matrix2 = [];
let matrix3 = [];

for (let i = 0; i < rows; i++) {
    let row = []
    for (let j = 0; j < cols; j++) {
        row.push(i + j);
    }
    matrix.push(row);
}

console.log(matrix);

matrix2 = matrix.map(row => row.map(value => value ** 2));
console.log(matrix2);

//do the same thing that i did for matrix with matrix3 using form
matrix3 = Array.from({ length: rows }, (_, i) =>
    Array.from({ length: cols }, (_, j) => i + j)
);
console.log(matrix3);