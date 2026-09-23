let myDiv = document.querySelector('#addElem');
let btn = document.querySelector('#btn');
let btn2 = document.querySelector('#btn2');

btn.addEventListener("click", addFacts);

const facts = [
    "I enjoy driving.",
    "I love listening to music.",
    "I am scared to fly in a plane",
];

function addFacts() {
    for(let i = 0; i < facts.length; i++){
        let elem = document.createElement("p");
        elem.textContent = facts[i];
        myDiv.appendChild(elem);
    }
    event.target.disabled = true;
}

btn2.addEventListener("click", fetchFacts);

function fetchFacts() {
    let div = document.querySelector('#result');
    let container1 = document.querySelector('#container1');

    if (div) {
        fetch('https://uselessfacts.jsph.pl/api/v2/facts/random')
            .then(response => response.json())
            .then(data => div.innerHTML = data.text);
    } else {
        let myDiv2 = document.createElement('div');
        myDiv2.id = 'result';
        fetch('https://uselessfacts.jsph.pl/api/v2/facts/random')
            .then(response => response.json())
            .then(data => myDiv2.innerHTML = data.text);

        container1.appendChild(myDiv2);
    }
}

