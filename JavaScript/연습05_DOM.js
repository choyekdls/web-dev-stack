// 1번 문제 O
function printText() {
  const result1 = document.querySelector("#result1");
  const p = document.createElement("p");
  p.textContent = "안녕하세요";
  result1.appendChild(p);
}
// ******2번 문제
function printInputValue() {
  const customer = document.querySelector("#customer");
  console.log(customer.value);
}
// 3번 문제 O
function changeColor() {
  const divtest = document.querySelector(".div-test");
  divtest.style.backgroundColor = "lightpink";
}

// 4번 문제
function stringLength() {
  const text = document.querySelector("#text");

  let input = text.value;
  console.log(input.length);
}

// 5번 문제
function stringSplit() {
  const la = document.querySelector("#la");
  const latext = la.innerHTML;

  const ul = document.createElement("ul");
  const li = document.createElement("li");
  li.textContent = latext;
  la.appendChild(li);
}

// 6번 문제
function arrayTest() {
  const preview = document.querySelector("#preview");
  const strpre = preview.innerHTML;
  const preArr = strpre.split(" ");
  console.log(preArr);
}

// 7번 문제 : prompt로 이름, 나이, 주소 순으로 입력받아서 출력
function addStudent() {}

// 8번
function addItem() {
  const list = document.getElementById("list");
}

// 9번
function toggleClass() {}

// 10번
function addToCart() {}
