const click = document.querySelector("section button:first-child"); // 클릭 이벤트를 걸어야 함
const img = document.querySelectorAll("img"); // 내가 클릭을 했을 때 바꿔야 함
const span = document.querySelector("button span");
const h2 = document.querySelector("h2");
const restart = document.querySelector("section button:last-child");
console.log(img);
let count = 0;
const game = () => {
  //랜덤값 : 1~3까지
  const random = [
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
  ];
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `JavaScript/assets/spy${random[i]}.jpg`);
  }
  //클릭할 때마다 카운트 증가
  span.textContent = ++count;

  if (random[0] === random[1] && random[1] === random[2]) {
    click.disabled = true;
    h2.style.visibility = "visible";
    // h2에 visibility:visible로 변경
  }
};
const end = () => {
  //이미지는 처음 그대로 원위치
  for (let i = 0; i < img.length; i++)
    [img[i].setAttribute("src", `JavaScript/assets/spy${i + 1}.jpg`)];
  //count는 0으로 바꾸고 span은 비우고
  count = 0;
  span.textContent = "";
  //h2 visibility = hidden 처리
  h2.style.visibility = "hidden";
  //click 버튼의 disabled false 처리
  click.disabled = false;
};

// 이미지 3개가 일치한 경우 버튼 disabled 처리
// 1.click.setAttribute("disabled", "disabled")
// 2.click.setAttribute("disabled", true)
// 3.click.disabled = true

// 이거 사용 가능함
// const random = [Math.floor(Math.random() * 3) + 1]
// img[i].setAttribute("src", `JavaScript/assets/spy${random}.jpg`);

// let selected = [];
// selected.push(img);

// if(selected[0] === selected[1] && selected[1] === selected[2]) {
//   click.disabled = true
// }

click.addEventListener("click", game);
restart.addEventListener("click", end);
// restart.addEventListener("click", () => {
// location.reload()  } //페이지 강제 새로고침
