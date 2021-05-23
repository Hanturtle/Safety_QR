# 안드로이드

5 / 23
    ksy
    
    - 파이썬 디렉토리 -> Server로 명칭 수정
    - android 디렉토리 내의 server.py - > Server/src 로 옮김
    
    - Client.class
            - (105 line) Server.py로 부터 결과 값 String 값으로 수신하도록 수정
            - (55 line) result 함수로 malicious, total의 결과 값 추출
   
    - ScanResult_Activity.class
            - (44 line) int형 malicious, total intent 추가
                    ** ex) 정상 url -> malicious = 0 / total = 88
                            비정상 url -> malicious = 13 / total = 88
                            등록되지 않은 url -> malicious = -1 / total = -1
                            ** 위 조건들에 따른 if문 수정필요 **
            - (60 line) if 조건문을 malicious로 수정
