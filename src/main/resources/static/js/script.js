function getToken() {
    return localStorage.getItem("token");
}

function authHeader() {
    return {
        "Authorization": "Bearer " + getToken(),
        "Content-Type": "application/json"
    };
}