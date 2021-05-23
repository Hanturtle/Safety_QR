import requests
import socket
import time


#------------------------------------검사----------------------------------
def check(recv_data):

    url = 'https://www.virustotal.com/vtapi/v2/url/report'  
    mykey = '5b515349e942c36fdb06b793b6fe2f7f0841926a181db41654e996046d0e745c'

    check_data = ""
    for i in recv_data[2:]:
        check_data += i

    params = {'apikey': mykey, 'resource': check_data}
    response = requests.get(url, params=params)

    data = response.json()
    return data
    
#------------------------------------검사----------------------------------

host = "192.168.0.6"          #서버쪽 IP
port = 8080

# 소켓 객체 생성
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((host,port))
server_socket.listen(1)
group = [] # 연결된 클라이언트의 소켓정보
print("wait...")

# ------------------------------클라이언트 접속--------------------------------
while True:
    client_socket, addr = server_socket.accept()
    group.append(client_socket)
    print("client: ", addr)

    if client_socket:
        # 데이터 받기
        recv_data = group[0].recv(1024).decode('utf-8')
        print("url: ", recv_data)
        # 데이터 전송
        data = check(recv_data)
        try:
            malicious = str(data['positives'])
            total = str(data['total'])
            answer = malicious+'/'+total
        except KeyError:
            malicious = str(-1)
            total = str(-1)
            answer = malicious+'/'+total
        
       
        group[0].send(answer.encode("utf-8"))
        print("악성: ", answer)
        # 소켓 종료
        group[0].close()
        # 클라이언트 삭제
        del group[0]

server_socket.close()
print("서버 종료")
