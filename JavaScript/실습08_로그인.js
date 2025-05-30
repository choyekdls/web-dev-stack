//이름이랑 비밀번호 입력하고 로그인 누르면
//화면이 넘어감 뫄뫄님 환영합니다! 와 함께 있는 로그아웃 버튼

const username = document.querySelector("#username");
const password = document.querySelector("#password");
const button = document.querySelector("button");
const h1 = document.querySelector("h1");
const form = document.querySelector("#form");
const login = document.querySelector("#login");
const out = document.querySelector("#out");

username.addEventListener("input", (e) => {
  localStorage.setItem("name", e.target.value);
  if (e.target.value !== "") {
    login.disabled = false;
  } else {
    login.disabled = true;
  }
});
password.addEventListener("input", (e) => {
  localStorage.setItem("password", e.target.value);
  if (e.target.value !== "") {
    login.disabled = false;
  } else {
    login.disabled = true;
  }
});

button.addEventListener("click", (e) => {
  localStorage.getItem("name");
  localStorage.getItem("password");
  h1.innerHTML = `${username}님 환영합니다`;
  form.style.visibility = "hidden";
  out.style.visibility = "visible";
});
