
function getRandomColour() {
    colour = '';
    for (let i = 0; i < 3; i++) {
        let part = Math.floor(Math.random() * 256).toString(16);
        colour += part;
    }
    return `#${colour}`;
}

function getCharacters() {
    let text = document.querySelector('input').value;
    let p = ``;
    for (let element of text) {
        p += `${element}<br>`;
    }
    p += ``;
    return p;
}

function clickButton(){
    document.getElementById('text').style.color = getRandomColour();
    document.getElementById('text').innerHTML = getCharacters();
}