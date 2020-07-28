## 0317 폴더(매우 좋은 예제임) - 흐름알기에 매우 좋은 예제. 직접 하기에는 비효율.(servlet을 하드코딩 할 일은 별로 없으므로) 
나중에 볼 때 직접 코딩하지 말고 전체 MVC흐름(get/post 와 변수의 이동들)과 경로(/servlet/..) 생각하면서 review하기

MVC패턴으로 게시판, 목록 다 보여주고 목록 중 명단 클릭하면 개인 정보 보여줌
회원 등록, 회원 삭제, 회원정보 수정 다 있음

DB연동은 간단하게만. 서블릿 이용해서 MVC패턴
DB-local의 오라클(stored procedure안 만들고 그냥 prepared statement로)

**프로그램 흐름** : register.html 에서 정보입력후 가입하기(서블릿으로 보냄) -> servlet/RegisterServlet이 받음 -> service -> dao -> DB(localhost_scott의 테이블)
 
 
### 20200317
[강의1](https://youtu.be/3TBEuvsrfL4) / 서블릿, DB에 저장 MVC 구현3 (DB에 자료입력과 출력) cf) ListServlet(회원목록) 15분부터 작성(selectall), index.html만들기  
[강의2](https://youtu.be/DTh8Yp1fKWw) / 서블릿, DB에 저장 MVC 구현1 cf) localhost_scott계정으로 local에 시퀀스, 테이블(member) 만들고 코딩 시작  
[강의3](https://youtu.be/QI6PFkpUIrk) / 서블릿, DB에 저장 MVC 구현2 cf) register.html에서 첫 데이터 입력->서블릿-> .. ->DB까지 cf) insert. selectAll(45분부터)  
[강의4](https://youtu.be/dNqsgncMdY4) / 서블릿, B에 저장 MVC 구현3 (DB에 자료입력과 출력) cf) ListServlet(회원목록) 15분부터 작성(selectall), index.html만들기  
[강의5](https://youtu.be/bcC7bKbtgXo) / 서블릿 /  apache와 tomcat 연동(192.168.56.2 와 192.168.56.3 을 연결)하다가 중단, / MVC 구현4 (15분부터), insert했을 때 페이지 redirect(js이용해서), (45분부터 select)특정회원불러오기  
[강의6](https://youtu.be/Sr6N504sY3U) / 서블릿 /  MVC 구현5, (MVC 구현4의 select만들던 것 이어서 25분까지 완성) cf) 25분까지 CRRUD전체 중 CRR까지 완성, 28분부터 회원Delete시작  
[강의7](https://youtu.be/lt31loomH8o) / 서블릿 /  MVC 구현6, (이어서)회원Delete, 회원update(23:50부터) cf) (29:30) 서블릿탄생과 jsp등장의 변화  
[강의8](https://youtu.be/24xb87KylkM) / 서블릿 /  MVC 구현7, (이어서)회원update  
[강의9](https://youtu.be/rS01jWEwGck)/ 서블릿 /  MVC 구현8, (이어서)회원update(10분까지), 배포하는 법  cf) (CRRUD까지 완성)(10분까지)    
