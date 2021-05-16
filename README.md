# 큐싱없는 세상, 안전한 QR코드 검증 앱을 만드는 "Safety QR"
산학캡스톤디자인 02분반 Safety QR팀<br><br>

## 주제 선정의 배경
모바일 보안 플랫폼 업체 모바일아이언(MobileIron)이 지난 9월 발표한 [보고서](https://www.mobileiron.com/en/qriosity)에 따르면 QR코드는 기업과 개인에게 ‘중대한’ 보안 위험을 초래할 수 있다. 전체 응답자의 47%는 최근 들어 QR코드를 많이 사용하고 있고 대다수(84%)가 QR코드를 사용해봤으며, 이 가운데 3분의 1은 최근 일주일 이내에 QR코드를 스캔했다고 답했다. QR코드를 주로 사용한 곳은 소매점, 레스토랑, 술집 및 기타 시설인 것으로 드러났다. 또한 QR코드가 미래의 결제 방식으로 더욱 광범위하게 사용되기를 원한다고 말한 응답자도 많았다.
<br>[2020년 10월 기사](https://github.com/seungyun807)에 따르면 코로나19 사태로 QR코드 사용이 일상화되면서 이를 악용해 개인정보를 탈취하거나 피싱 공격을 시도하는 사례가 늘어나고있다. 해커는 악성코드를 포함한 악성 URL을 QR코드에 삽입해 공격을 시도하고 이를 통해 사용자가 해당 코드를 스캔할 때 모바일 기기에서 데이터를 빼내거나, 피싱 사이트로 유인해 사용자가 인증 정보를 누설하도록 한다. 그러나 **사용자는 QR코드를 스캔할 때 어떤 일이 일어날지 모르는 경우가 많다.** 일반적으로 URL은 클릭하기 전에 URL을 확인할 수 있지만 QR코드는 그렇지 않다. <br><br>

## 주제 및 목표
**QR 작동 이전에 사용자에게 어떤 사이트에 방문하고 작동하는지 미리 알려주어 큐싱을 예방하고 방지한다.** <br><br>
![](https://images.velog.io/images/hanturtle/post/af7fee70-17b9-4619-a669-fc6ca9192137/image.png)<br><br>

## 기대 효과
간편해서 사용은 많이 하지만 이게 어떻게 생성되고 활용되는지에 대해선 아직 낯설기 때문에 위험에 노출될 가능성이 높다. QR코드와 피싱의 합성어, 큐싱이라는 금융 사기 수법도 나타났다. 인증이 필요한 것처럼 QR코드로 앱을 다운로드하게 해서 악성코드를 유포하고 보안카드나 개인 정보를 다 빼내는 식이다. QR코드를 스캔하기 전에는 믿을 수 있는 곳인지 QR코드 출처를 먼저 확인해 줘서 금융 사기 방지, 개인 정보 유출 방지 및 QR코드에 대한 보안 인식을 증가시켜 무분별한 QR코드 스캔을 방지하여 큐싱을 예방하고 방지하여 피해가 줄어들 것으로 예상된다. 
<br><br><br>

## 👩🏻‍💻 팀원 구성 👩🏻‍💻

[![](https://images.velog.io/images/hanturtle/post/813be5b7-e9c5-414b-85e5-5e51978147d4/image.png)](https://github.com/Hanturtle)  | [![](https://images.velog.io/images/hanturtle/post/57f1e5bc-0ef8-4137-aecf-be9b9377123e/image.png)](https://github.com/seungyun807)  | [![](https://images.velog.io/images/hanturtle/post/cd426609-9bb5-419c-927e-b8c509e712a4/image.png)](https://github.com/ssspmj1204)  | [![](https://images.velog.io/images/hanturtle/post/33e9eaba-b709-4389-ab24-5a5b42153cc3/image.png)](https://github.com/inhaaa) 
--------- | --------- | --------- | ---------
한지원 (팀장)| 김승윤 | 박민지 | 박인하
**Github 관리, 안드로이드**<br>QR 리더기 개발<br>안드로이드 프론트앤드| **서버**<br>소켓 통신 |**웹 크롤링**<br>url 데이터 처리 | **안드로이드 DB, 디자인**<br>안드로이드 데이터베이스 관리<br>앱 디자인

<br><br>

## 주요 일정 (주 단위)
단계 | 일정 | 산출물
|:-----: | :-----: | :-----: |
요구사항 분석 및 프로젝트 계획 | 2021-03-1주 ~ 2021-03-4주 | 계획서(주제 선정, 프로젝트 계획서 작성)
설계 | 2021-04-1주 ~ 2021-04-2주 | DB설계서, UI/UX 디자인
구현 | 2021-04-3주 ~ 2021-05-4주 | 소스 코드
테스팅 | 2021-05-5주 | 배포용 apk 파일
유지보수 | 2021-06-1주 ~ | 시연 영상 및 발표 자료

<br><br>

## 개발 환경
### 안드로이드

>안드로이드스튜디오 4.0.1 <br> Runtime version : 1.8.0 <br> VM : OpenJDK 64-Bit Server VM by JetBrains s.r.o

<br>

### 또 뭐있어

<br><br>
## 기능
- QR스캔
- URL 검사
- 악성 URL 판별
- 검색한 URL을 DB에 저장
- 앱 정보
<br>

### QR스캔
QR스캔을 하여 URL 값을 읽어드린다.<br>
<br><br>

### URL 검사
사용자가 입력한 값을 읽어 URL일 경우 악성 URL을 판별할 수 있게 하고, 입력한 값이 URL이 아닐경우 다시 입력하게한다.<br>
![](https://images.velog.io/images/hanturtle/post/aa711040-15d2-42c5-a440-44e36f1fd202/image.png)<br>
<br><br>

### 악성 URL 판별
QR스캔, URL 검사에서 받아온 URL의 악성 여부를 판별한다. 안전한 URL일 경우 OK버튼을 누르면 정상적인 작동을하고, 악셩일 경우 접속하지 못하게 차단한다.<br>
![](https://images.velog.io/images/hanturtle/post/a3e46995-fb7b-4ccd-9b6f-93cf76591d19/image.png)<br>
<br><br>

### 검색한 URL을 DB에 저장
악성 URL을 판별한 값들을 안드로이드 DB에 저장한다.<br>
<br><br>

### 앱 정보
기본적인 앱 정보를 알려준다.<br>
![](https://images.velog.io/images/hanturtle/post/f4f07789-3e8f-4670-83ae-0f6a8b9ae5b8/image.png)<br>
<br><br><br>
## 설계 및 구현

<br><br><br>
## Trouble Shooting
### 서버 & 클라이언트
<br><br><br>
## 관련 학습 내용
### URL 판별 알고리즘
java에서 String에서 URL 추출하기
``` java
 public static String isURL(String str){
 	StringBuffer answer = new StringBuffer();
        String regex ="[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        if(m.find()){
            answer.append(m.group(0));
        }

        return answer.toString();
    }
```
<br><br>
### 소켓통신
**스레드를 통해 서버 연결 요청**

``` java
 Thread checkUpdate = new Thread() {
            public void run(){
```
**서버로 스캔한 URL 전달**
``` java
 try {
	dos = new DataOutputStream(socket.getOutputStream());
	dis = new DataInputStream(socket.getInputStream());
	dos.writeUTF(url);
} 
```

**서버로부터 결과값 수신**

```  java
result = (int)dis.read();
```

**서버 대기**

``` python
server = socket.socker(socket.AF_INET)
server.bind((host,port))
print("서버 연결됨")
server.listen(1)
print("서버 대기중")
```

**결과값 클라이언트로 송신**

``` python
if recv_data:
	print("url: ", recv_data.decode())
connection.send(send_data)
```

**ScaneResult로 결과값 전달**

``` java
public void ScanResult(String url) {
	Intent intent = new Intent(this, ScanResult.class);
	intent.putExtra("url", url);
	intent.putExtra("result", result);
	startActivity(intent);
}
```
<br><br>
### QR리더기 구현
Zxing 라이브러리를 활용하여 QR리더기를 구현하고 필요한 정보(URL)를 얻어오기
<br>
**URL 값 얻어오기**
``` java
Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
```
**Client.class로 인텐트 넘겨주기**
``` java
Intent url = new Intent(this, Client.class);
url.putExtra("url", "http://www.naver.com");
```
<br><br>
### VIRUSTOTAL 데이터 가져오기
- Apikey : 로그인 후 apikey값을 얻어야 데이터를 얻을 수 있음
- Resource : 검색할 리소스
- url : 데이터 요청 사이트
- mykey : 데이터를 가져오기 위한 자신의 키값이 있어야 함
- MD5 : 검사할 URL의 해쉬값 
	- URL를 MD5로 변환할 코드는 연구중
	- URL 데이터는 안드로이드에서 소켓통신을 받을 예정
- Requests.get() : 데이터 요청

<br>
데이터 값이 딕셔너리 형태로 저장되어있음. <br>
데이터를 가공하여 키-값으로 출력하여 데이터 변수에 저장
<br><br>


