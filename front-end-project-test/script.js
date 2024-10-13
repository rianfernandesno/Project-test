const form = document.querySelector("form")

const inputName = document.querySelector(".name")
const inputEmail = document.querySelector(".email")
const inputPassword = document.querySelector(".password")
const inputTel = document.querySelector(".tel")

function cadastrar (){
    fetch("http://localhost:8080/cadastrar",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                name: inputName.value,
                email: inputEmail.value,
                password: inputPassword.value,
                tel: inputTel.value})
        }
    )
    .then(function(res) {console.log(ress)})
    .catch(function(res){console.log(res)})

}

function clear(){
    inputName.value = "";
    inputEmail.value = "";
    inputPassword.value = "";
    inputTel.value = "";
}

form.addEventListener("submit", (event) => {
    event.preventDefault();


    cadastrar();
    clear();
})