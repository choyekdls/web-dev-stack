/* https://api.upbit.com/v1/market/all
{"market": "KRW-BTC",
    "korean_name": "비트코인",
    "english_name": "Bitcoin"
  },
  */
/* const fetchData = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  console.log(response);
  const data = await response.json();
  console.log(data);
  fetchResult.innerHTML = `${data[0].market}`;
  fetchResult.innerHTML = `${data[0].korean_name}`;
};
*/
//사용 함수 별 async의 위치
// async function dataFetch () {}
// const dataFetch = async function() {}

const dataFetch = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const data = await response.json();
  console.log(data);
  //   /* for (let i = 0; i < data.length; i++) {
  //     console.log(data[1]);
  //   }  */
  //   data.forEach((item) => {
  //     // includes 말고 startsWith도 가넝함...
  //     // startsWith : ("")안의 단어로 시작하는 단어 여부 확인, includes : 포함 여부
  //     if (item.market.includes("KRW")) {
  //       //반복문이 돌아갈 때마다 더해야함......무슨 소리
  //       market.innerHTML += `<h2>${item.korean_name}(${item.market})</h2>`;
  //     }
  //     console.log(item.market, item.market.includes("KRW"));
  //     console.log(item.korean_name);

  // })
  // };

  // forEach + 조건문 -> filter
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));

  //   let markets = "";
  //   krwMarkets.forEach((item) => {
  //     markets += item.market + ",";
  //   });

  //   console.log(markets.slice(0, -1));

  // forEach + 내가 원하는 형태로 가공하고자 할 때 -> map
  const markets = krwMarkets.map((item) => item.market).join(",");

  const tickerResponse = await fetch(
    `https://api.upbit.com/v1/ticker?markets=${markets}`
  );
  const tickerData = await tickerResponse.json();
  console.log(tickerData);

  krwMarkets.forEach((item) => {
    const ticker = tickerData.find((ticker) => ticker.market === item.market);
    // .toLocaleString() 세 자리 단위로 끊어줌
    market.innerHTML += `<h2>${item.korean_name}(${item.market})</h2>
 <p>현재가 : ${ticker.trade_price.toLocaleString()}원</p> 
   <p>24시간 거래량 : ${ticker.acc_trade_volume_24h.toFixed(2)}</p>
    <p>전일 대비 : ${
      ticker.change === "RISE"
        ? "상승"
        : ticker.change === "FALL"
        ? "하락"
        : "보합"
    }(${(ticker.change_rate * 100).toFixed(2)}</p>`; //.toFixed(): ()안의 숫자에 맞춰 소수점 자리 끊어줌
  });
};
dataFetch();
