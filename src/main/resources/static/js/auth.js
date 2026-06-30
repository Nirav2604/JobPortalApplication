const BASE_URL = "http://localhost:8080";

// ================= LOGIN =================

async function login() {

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    const msg = document.getElementById("msg");
    msg.innerHTML = "";

    try {

        const response = await fetch(BASE_URL + "/auth/login", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email: email,
                password: password
            })

        });

        if (!response.ok) {

            msg.className = "text-danger mt-3";
            msg.innerHTML = "Invalid Email or Password";
            return;
        }

        const data = await response.json();

        localStorage.setItem("token", data.token);

        msg.className = "text-success mt-3";
        msg.innerHTML = "Login Successful";

        setTimeout(() => {
            window.location.href = "/";
        }, 1000);

    } catch (e) {

        console.error(e);

        msg.className = "text-danger mt-3";
        msg.innerHTML = "Server Error";

    }

}

// ================= REGISTER =================
async function register() {

    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const role = document.getElementById("role").value;

    const msg = document.getElementById("msg");
    msg.innerHTML = "";

    if (name === "" || email === "" || password === "" || role === "") {
        msg.className = "text-danger mt-3";
        msg.innerHTML = "Please fill all fields.";
        return;
    }

    try {

        const response = await fetch(BASE_URL + "/auth/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                email: email,
                password: password,
                role: role
            })
        });

        // Read the response body ONLY ONCE
        const responseText = await response.text();

        if (!response.ok) {
            msg.className = "text-danger mt-3";
            msg.innerHTML = responseText;
            return;
        }

        msg.className = "text-success mt-3";
        msg.innerHTML = responseText;

        setTimeout(() => {
            window.location.href = "/login";
        }, 1500);

    } catch (e) {

        console.error("Register Error:", e);

        msg.className = "text-danger mt-3";
        msg.innerHTML = e.message;

    }
}
// ================= TOKEN =================

function getToken(){

    return localStorage.getItem("token");

}

// ================= LOGOUT =================

function logout(){

    localStorage.removeItem("token");

    window.location.href="/login";

}