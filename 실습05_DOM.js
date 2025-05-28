//오늘의 날짜, 현재 시각, 올해까지 남은 시간

const Todaydate = () => {
  const now = new Date();
  const days = ["일", "월", "화", "수", "목", "금", "토"];

  //1. 오늘의날짜
  const tdate = document.querySelector("#tdate");

  const year = now.getFullYear();
  const month = String(now.getMonth() + 1).padStart(2, "0");
  const date = String(now.getDate()).padStart(2, "0");
  const day = now.getDay(); //요일 (0 : 일요일, 1 : 월요일)
  tdate.textContent = `${year}년 ${month}월 ${date}일 (${days[day]})`;

  // 2. 현재 시각: 1초마다
  const clock = document.querySelector("#clock");

  const hours = String(now.getHours()).padStart(2, "0");
  const minutes = String(now.getMinutes()).padStart(2, "0");
  const seconds = String(now.getSeconds()).padStart(2, "0"); //(1, 2) 1 = 몇 칸을 차지할 것이냐, 2 = 1-9이외 나머지는 어떻게 채울거냐
  clock.textContent = `${hours}:${minutes}:${seconds}`;
};

// 3. 올해까지 남은 시간: 1초마다
const count = () => {
  const endOfYear = new Date("2026-01-01 00:00:00");
  const now = new Date();

  const countdown = document.querySelector("#countdown");
  const leftDays = Math.floor(leftHours / 24).padStart(2, "0");
  const leftHours = String(Math.floor(leftMin / 60)).padStart(2, "0");
  const leftMin = String(Math.floor(leftSec / 60)).padStart(2, "0");
  const leftSec = String(Math.floor((last - now) / 1000)).padStart(2, "0");

  countdown.textContent = `올해 남은 시간 ${leftDays}일 ${leftHours}시간 ${leftMin}분 ${leftSec}초`;
};

//const countdown = () => {
//const endOfYear = new Date("2026-01-01 00:00:00");
//const now = new Date();

const randomBackground = () => {
  const background = document.querySelector("#background");
  const backGround = [
    "#ED833A",
    "#EA839B",
    "#42B667",
    "#FFC228",
    "#005456",
    "#ACDED5",
  ];
  randomBackground = [Math.floor(Math.random() * backGround.length)];
};

import quotes from "./JavaScript/quotes.js";

const randomQuote = () => {
  const random = quotes[Math.floor(Math.random() * quotes.length)];
  const quoteE = document.querySelector("#quoteE");
  const quoteK = document.querySelector("#quoteK");
};

Todaydate();
count();
randomBackground();
randomQuote();

setInterval(() => {
  Todaydate();
  count();
}, 1000);

setInterval(() => {
  randomBackground();
  randomQuote();
}, 5000);

// 4. 오늘의 명언

/* const quote = document.querySelector("#quote");
function randomQuoteBack() {
  const randomQ = Math.floor(Math.random() * quotes.length);
  quote.textContent = `"${quotes[random]}"`;
} */

// 5. 배경색: 랜덤(이렇게 해두됨)
//const randomBackground = () => {
//const body = document.body;
//const r = Math.floor(Math.random() * 256);
//const g = Math.floor(Math.random() * 256);
//const b = Math.floor(Math.random() * 256);
//body.style.background = rgba(${r}, ${g}, ${b}, 0.4);

/*const background = document.querySelector("#background");
  
  background.style.backgroundColor = randomC;
  setInterval(background, 6000);
}*/

// 오늘의 명언목록
/*const quotes = [ 

  {"약간의 광기를 띠지 않은 위대한 천재란 없다",}
  {"인내할 수 있는 사람은 그가 바라는 것은 무엇이든지 손에 넣을 수 있다",}
  {"두 사람이 만나는 것은 두 가지 화학 물질이 접촉하는 것과 같다. 어떤 반응이 일어나면 둘다 완전히 바뀌게 된다",}
  "사랑이란 서로 마주보는 것이 아니라둘이서 똑같은 방향을내다보는 것이라고 인생은 우리에게 가르쳐 주었다",
  "우리가 어떤형태로든 '될대로 되라지!'라고 할 때 마다 무슨 일이 생긴다",
  " 스스로 라는 명사가 동사가 된다. 현실에서 이러한 창조의 순간은 일과 오락이 하나가 될 때 일어난다",
  "미래를 결정짓고 싶다면 과거를 공부하라",
  "진지한 사람이라면 도덕성을수양하기 위해 필요한 노력의 상당 부분이 바로 자신의 과거와 현재 행동으로 야기된 불쾌한 결과를 인정할 수 있는 용기라는 점을 안다",
  "인생에서 가장 의미없이 보낸 날은 웃지 않고 보낸 날이다",
  "희망은 좋은 소식이 나쁜 소식보다 우세한지 계산하는 데서 오는 것이 아니다. 희망이란 그저 행동하겠다는 선택이다",
]; */
