// 랜덤 배경 색상
const backGround = ["#ED833A", "#EA839B", "#42B667", "#FFC228", "#005456", "#ACDED5"]

// 날짜에서 요일
const days = ["일", "월", "화", "수", "목", "금"];

// 오늘의 명언목록
const quotes = [
  "약간의 광기를 띠지 않은 위대한 천재란 없다",
  "인내할 수 있는 사람은 그가 바라는 것은 무엇이든지 손에 넣을 수 있다",
  "두 사람이 만나는 것은 두 가지 화학 물질이 접촉하는 것과 같다. 어떤 반응이 일어나면 둘다 완전히 바뀌게 된다",
  "사랑이란 서로 마주보는 것이 아니라둘이서 똑같은 방향을내다보는 것이라고 인생은 우리에게 가르쳐 주었다",
  "우리가 어떤형태로든 '될대로 되라지!'라고 할 때 마다 무슨 일이 생긴다",
  " 스스로 라는 명사가 동사가 된다. 현실에서 이러한 창조의 순간은 일과 오락이 하나가 될 때 일어난다",
  "미래를 결정짓고 싶다면 과거를 공부하라",
  "진지한 사람이라면 도덕성을수양하기 위해 필요한 노력의 상당 부분이 바로 자신의 과거와 현재 행동으로 야기된 불쾌한 결과를 인정할 수 있는 용기라는 점을 안다",
  "인생에서 가장 의미없이 보낸 날은 웃지 않고 보낸 날이다",
  "희망은 좋은 소식이 나쁜 소식보다 우세한지 계산하는 데서 오는 것이 아니다. 희망이란 그저 행동하겠다는 선택이다",
];

//오늘의 날짜, 현재 시각, 올해까지 남은 시간
function Todaydate() {
  const now = new Date();

  //1. 오늘의날짜
  const tdate = document.querySelector("#Tdate");

  const year = now.getFullYear();
  const month = now.getMonth() + 1;
  const date = now.getDate();
  const day = days; //요일..? 저 배열에서 어떻게 현재 요일을 설정하지..?
  tdate.textContent = `${year}년 ${month}월 ${date}일 (${day})`;

  // 2. 현재 시각: 1초마다
  const clock = document.querySelector("#clock")

  const hours = 
  const minutes = 
  const seconds = 
  clock.textContent = `${hours}:${minutes}:${seconds}`
  setInterval(clock, 1000);

  // 3. 올해까지 남은 시간: 1초마다 
  const countdown = document.querySelector("#countdown")
const endOfYear = new Date(2025, 11, 31, 23, 59, 59)
const left = endOfYear - now

const leftDays = 
const leftHours = 
const leftMin = 
const leftSec = 
countdown.textContent = `${leftDays}일 ${lefthours}시간 ${leftMin}분 ${leftSec}초초`
setInterval(countdown, 1000);
}  

// 4. 오늘의 명언
const quote = document.querySelector(#quote)
function randomQuote() {
    const randomQ = Math,floor(Math.random()* quotes.length)
    quote.textContent = `"${quotes[random]}"`
    setInterval(quote, 6000);

// 5. 배경색: 랜덤덤
const background = document.querySelector("#background")
    const randomC = backGround[Math.floor(Math.random()*backGround.length)]
    background.style.backgroundColor = randomC
    setInterval(background, 6000);
}
