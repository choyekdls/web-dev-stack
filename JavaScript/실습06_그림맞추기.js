const images = ["assets/spy1.jpg", "assets/spy2.jpg", "assets/spy3.jpg"];
const click = document.querySelector("#click");
const restart = document.querySelector("#restart");
const cong = document.querySelector("#h2");
const countSpan = document.querySelector("#count");

// 축하메세지 처음에는 화면에서 숨기기: 사진 일치 시 나오게 -> 조건문(if)
cong.style.display = "none";

// 클릭할 때마다 시도 횟수 카운트 됨됨
let count = 0;
click.addEventListener("click", () => {
  count++;
  countSpan.textContent = count;

  //사진 랜덤으로 돌림. 선택된 사진은 배열에 추가하기
  const random = Math.floor(Math.random() * images.length);
  let selected = [];
  selected.push(random);

  //만약~ 그림이 모두 일치하면 축하메세지 띄우기...아니면~ 안띄우기기
  if (selected[0] === selected[1] && selected[1] === selected[2]) {
    cong.style.display = "block";
  } else {
    cong.style.display = "none";
  }
});
// 리스타트 버튼 누르면~사진 전부 원위치, 축하메세지 사라지고고, 카운트 리셋
restart.addEventListener("click", () => {
  //사진 원위치

  congSection.style.display = "none";

  count = 0;
  countSpan.textContent = count;
});

//setAttribute 사용해야함
// 클릭 버튼 누르면 그림 맞추기 그림 배열 돌아가기......
