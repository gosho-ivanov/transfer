//1
function containsDigit(str) {
    const pattern = /\d/;
    return pattern.test(str);
}

// Example usage:
console.log(containsDigit("Hello123")); // true
console.log(containsDigit("Hello"));    // false


//2
function replaceSpacesWithDashes(str) {
    const pattern = / /g;
    return str.replace(pattern, '-');
}

// Example usage:
console.log(replaceSpacesWithDashes("Hello World! This is a test.")); // "Hello-World!-This-is-a-test."
console.log(replaceSpacesWithDashes("NoSpacesHere"));                  // "NoSpacesHere"

function replaceLowercaseWithUpperCase(str) {
    const pattern = /[a-z]/g;
    return str.replace(pattern, (match) => match.toUpperCase());
}

// Example usage:
console.log(replaceLowercaseWithUpperCase("Hello World!")); // "HELLO WORLD!"
console.log(replaceLowercaseWithUpperCase("JAVA SCRIPT"));   // "JAVA SCRIPT"

//3
function containsOneLowercase(str) {
    const pattern = /[a-z]/;
    return pattern.test(str);
}

// Example usage:
console.log(containsOneLowercase("HELLO")); // false
console.log(containsOneLowercase("Hello")); // true


//4
function extractNumbers(str) {
    const pattern = /\d+/g;
    return str.match(pattern).join(", ") || "There are no matches.";
}

// Example usage:
console.log(extractNumbers("There are 2 apples and 10 bananas.")); // ["2", "10"]
console.log(extractNumbers("No numbers here."));                   // []
console.log(extractNumbers("123abc456def789"));                     // ["123", "456", "789"]


//6
function validatePhoneNumber(text){
    pattern = /\(?\d{3}\)?(-|\s)\d{3}(-|\s)\d{4}/g;
    return text.match(pattern) !== null;
}

// Example usage:
console.log(validatePhoneNumber("Моите номера са (123) 456-7890 и 987-654-3210.")); // true
console.log(validatePhoneNumber("123-456-7890"));     // false


//7
function removeDuplicateWords(str) {
    const pattern = /\b(\w+)\s+\1\b/g;
    return str.replace(pattern, '$1');
}

// Example usage:
console.log(removeDuplicateWords("This is is a test test.")); // "This is a test."
console.log(removeDuplicateWords("No duplicates here."));      // "No duplicates here."


//8
function checkPasswordStrength(password) {
    const pattern = /^([a-z]|[A-z]|\d|){8,}$/;
    return pattern.test(password);
}

