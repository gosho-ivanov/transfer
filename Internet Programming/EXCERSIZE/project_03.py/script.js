const jokeContainer = document.getElementById('jokeContainer');
const generateBtn = document.getElementById('generateBtn');
const jokeCountInput = document.getElementById('jokeCount');
const statusText = document.getElementById('statusText');

async function getJoke() {
    const response = await fetch('https://api.chucknorris.io/jokes/random');
    const data = await response.json();
    return data.value;
}

async function generateJokes() {
    const count = parseInt(jokeCountInput.value);
    if (isNaN(count) || count < 1) {
        statusText.textContent = "Please enter a valid number of jokes!";
        return;
    }

    jokeContainer.innerHTML = '';
    statusText.textContent = `Generating ${count} joke${count > 1 ? 's' : ''}... ⏳`;

    const jokes = [];
    for (let i = 0; i < count; i++) {
        try {
            const joke = await getJoke();
            jokes.push(joke);
        } catch (err) {
            jokes.push("⚠️ Failed to fetch joke.");
        }
    }

    // Display jokes
    jokeContainer.innerHTML = '';
    jokes.forEach(joke => {
        const div = document.createElement('div');
        div.className = 'joke';
        div.textContent = joke;
        jokeContainer.appendChild(div);
    });

    // Update status
    statusText.textContent = `${jokes.length} joke${jokes.length > 1 ? 's were' : ' was'} generated successfully ✅`;
}

generateBtn.addEventListener('click', generateJokes);
