function validateForm() {
    let id = document.forms[0]["id"].value;
    let password = document.forms[0]["password"].value;
    let email = document.forms[0]["email"].value;

    if (id.length < 3) {
        alert("ID는 최소 3글자 이상 입력하세요.");
        return false;
    }
    if (password.length < 6) {
        alert("비밀번호는 최소 6자 이상 입력하세요.");
        return false;
    }
    if (!email.includes("@")) {
        alert("올바른 이메일 형식을 입력하세요.");
        return false;
    }
    return true;
}
