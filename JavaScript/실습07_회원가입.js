// 1. 아이디
const username = document.querySelector("#username");
const idresult = document.querySelector("#idresult");
// 2. 비밀번호
const pw = document.querySelector("#pw");
const pwresult = document.querySelector("#pwresult");
// 3. 비밀번호 확인
const confirmpw = document.querySelector("#confirmpw");
const confirmresult = document.querySelector("#confirmresult");
// 4. 이름(한글)
const name = document.querySelector("#name");
const nameresult = document.querySelector("#nameresult");
// 5. 이메일
const email = document.querySelector("#email");
const emailresult = document.querySelector("#emailresult");
// 6. 전화번호
const call = document.querySelector("#call");
const callresult = document.querySelector("#callresult");
// 7. 회원가입
const success = document.querySelector("#success");
// 8. 취소
const resign = document.querySelector("#resign");

// 아이디 입력 - h3 글자 빨갛게 - 형식에 맞으면 OK!
username.addEventListener("input", (i) => {
  //console.log(i.target.value);

  let idExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;

  if (idExp.test(i.target.value)) {
    console.log("아이디 입력 방식 O");
    idresult.innerHTML = "OK!";
    idresult.style.color = "green";
  } else {
    console.log("아이디 입력 방식 X");
    idresult.innerHTML = "NO!";
    idresult.style.color = "red";
  }

  // 비밀번호 입력
  pw.addEventListener("input", (p) => {
    //console.log(p.target.value);

    let pwExp =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;

    if (pwExp.test(p.target.value)) {
      console.log("비밀번호 입력 방식 O");
      pwresult.innerHTML = "OK!";
      pwresult.style.color = "green";
    } else {
      console.log("바밀번호 입력 방식 X");
      pwresult.innerHTML = "NO!";
      pwresult.style.color = "red";
    }

    // 비밀번호 확인

    confirmpw.addEventListener("input", (c) => {
      //console.log(c.target.value);

      let confirmExp =
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;

      if (c.target.value === p.target.value) {
        console.log("비밀번호 문제 없음");

        confirmresult.innerHTML = "OK!";
        confirmresult.style.color = "green";
      } else {
        console.log("바밀번호 입력 방식 X");
        confirmresult.innerHTML = "NO!";
        confirmresult.style.color = "red";
      }
    });

    // 이름 입력 (한글)
    name.addEventListener("input", (n) => {
      //console.log(n.target.value);

      let nameExp = /^[가-힣]{2,}$/;

      if (nameExp.test(n.target.value)) {
        console.log("이름 입력 방식 O");
        nameresult.innerHTML = "OK!";
        nameresult.style.color = "green";
      } else {
        console.log("이름 입력 방식 X");
        nameresult.innerHTML = "NO!";
        nameresult.style.color = "red";
      }

      // 이메일 입력
      email.addEventListener("input", (m) => {
        //console.log(m.target.value);

        let emailExp = /^[\w.-]+@[\w.-]+\.[A-Za-z]{3,}$/;

        if (emailExp.test(m.target.value)) {
          console.log("이름 입력 방식 O");
          emailresult.innerHTML = "OK!";
          emailresult.style.color = "green";
        } else {
          console.log("이름 입력 방식 X");
          emailresult.innerHTML = "NO!";
          emailresult.style.color = "red";
        }

        // 전화번호 입력
        call.addEventListener("input", (call) => {
          //console.log(call.target.value);

          let callExp = /^010-\d{4}-\d{4}$/;

          if (callExp.test(call.target.value)) {
            console.log("전화번호 입력 방식 O");
            callresult.innerHTML = "OK!";
            callresult.style.color = "green";
          } else {
            console.log("전화번호 입력 방식 X");
            callresult.innerHTML = "NO!";
            callresult.style.color = "red";
          }

          // 회원가입 버튼 - 비활성화 - 모든 항목이 OK! 떴을 때, 활성화하기(색 바꾸기)
          success.addEventListener("click", (s) => {
            s.disabled = true;

            if (
              idExp.test(i.target.value) &&
              pwExp.test(p.target.value) &&
              nameExp.test(n.target.value) &&
              emailExp.test(m.target.value) &&
              callExp.test(call.target.value)
            ) {
              success.style.color = "green";
              s.disabled = false;
            }
            alert("회원가입 성공!");
          });

          // 취소버튼 - 누르면 재작성하기(내용 다 지워지기)
          resign.addEventListener("click", () => {
            location.reload();
          });
        });
      });
    });
  });
});
