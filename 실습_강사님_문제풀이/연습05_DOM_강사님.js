// 1번 문제 O
const result1 = document.querySelector("#result1");
function printText() {
  result1.textContent = "안녕하세요";
}
// 2번 문제
const result2 = document.querySelector("#result2");
const customer = document.querySelector("#customer");
function printInputValue() {
  //input값(customer)을 가지고 오기
  console.log(customer.value);
  // 가지고 와서 result2에 출력
  console.log(result2);
  result2.textContent = customer.value;
  // input 값(customer.value)을 비우기
  customer.value = "";
}
// 3번 문제 O
function changeColor() {
  const divtest = document.querySelector(".div-test");
  divtest.style.backgroundColor = "lightpink";
}

// 4번 문제 O
const text = document.querySelector("#text");
const result4 = document.querySelector("#result4");
function stringLength() {
  console.log(text.value.length);
  result4.innerHTML = text.value.length;
  text.value = "";

  // console.log(text.value.length)
  // result.innetHTML = text.value.length
  // text.value = ""
}

// 5번 문제 (반복문을 쓰십쇼)
const la = document.querySelector("#la");
const result5 = document.querySelector("#result5");
function stringSplit() {
  // 1.  사과, 바나나, 오렌지, 포도 문자 가지고 오기
  // console.log(la.innerHTML)
  // const latext = la.innerHTML
  // 2. 가지고 온 문자열 분리하기 -> 배열로 만들기 (split)
  // console.log(latext.split(","))
  // const laArr = latext.split(",")
  // 6. ul 태그 만들기 -> 반복문 바깥에
  // const ul = document.createEliment("ul");
  // 3. 배열 값 하나씩 가지고 오기 -> 반복문
  // for(let i = 0; i<laArr.length; i++){console.log(laArr[i])}
  // 4. 반복문에서 li태그를 만들어서 출력
  // const li = document.createEliment("li");
  // 5. li 태그에 값 넣기
  // li.innerHTML = laArr[i])
  // 7. ul태그에 만들어 놓은 li태그들 추가하기
  // ul.appendChild(li) or ul.innerHTML += `<li>${laArr[i]}</li>`
  // 8. result 5에 ul 담기
  // result5.appendChild(ul)
}

// ????????????????????????????????????? 6번 문제 : 진짜 다시 해봐라
const preview = document.querySelector("#preview");
const remove = document.querySelector("#remove");
const add = document.querySelector("#add");
function arrayTest() {
  const strpre = preview.innerHTML;
  const preArr = strpre.split(" ");
  console.log(preArr);

  for (let i = 0; i < preArr.length; i++) {
    // 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
    if (preArr[i] === remove.value) {
      preArr.splice(i, 1); // 배열에서 제거 (splice(인덱스, 1))
    }
  }

  console.log(preArr.join(" "));
  preview.textContent = preArr.join(" ");

  /* 
      const delIdx = preArr.indexOf(remove.value);
      if(delIdx !== -1) preArr.splice(delIdx, 1) 
      */

  /*
      console.log(preArr.includes(remove.value));
      if(preArr.includes(remove.value)) preArr.splice(delIdx, 1)
      */
}
// preArr.push(add.value);

// 7번 문제 : prompt로 이름, 나이, 주소 순으로 입력받아서 출력
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");
function addStudent() {
  for (let i = 0; i < 3; i++) {
    const name = prompt(`${i}번째 학생 이름`);
    const age = prompt(`${i}번째 나이`);
    const addr = prompt(`${i}번째 주소`);
    names[i].textContent = name;
    ages[i].textContent = age;
    addrs[i].textContent = addr;
  }
}

// 8번
const list = document.getElementById("list");
function addItem() {
  // 1. li 태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "요소 추가";
  list.appendChild(li);

  // 2. innerHTML로 문자로 추가하는 방식
  list.innerHTML += "<li>요소 추가</li>";
}
function removeItem() {
  // 1. 부모에서 제거
  console.log(list.childNodes);
  list.removeChild(list.childNodes[0]);
  // 2. 본인이 제거
  const li = document.querySelectorAll("#list li");
  li.remove();
}

// 9번
const result9 = document.querySelector("#result9");
function toggleClass() {
  result9.classList.toggle("active");
}

// 10번
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("cart");
const total = document.querySelector("#total span");
let sum = 0;
function addToCart() {
  cart.innerHTML += `<li>${item.value} - ${price.value}</li>`;

  console.log(isNaN(Number(price.value)));
  if (!isNaN(Number(price.value))) sum += Number(price.value);
  total.innerHTML = sum;
  console.log(sum);

  item.value = "";
  price.value = "";
}
