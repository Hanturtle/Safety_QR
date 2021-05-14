import requests
import socket
import time
host = "192.168.0.6"          #서버쪽 IP
port = 8080

# 소켓 객체 생성
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((host,port))
server_socket.listen(1)
print("wait...")

# 클라이언트 접속
client_socket, addr = server_socket.accept()
print("client: ", addr)

# 데이터 받기
recv_data = client_socket.recv(1024)
recv_data = recv_data.decode("utf-8")
print("url: ", recv_data)

#------------------------------------검사----------------------------------
url = 'https://www.virustotal.com/vtapi/v2/url/report'
mykey = '5b515349e942c36fdb06b793b6fe2f7f0841926a181db41654e996046d0e745c'
URL = recv_data
params = {'apikey': mykey, 'resource': URL}
response = requests.get(url, params=params)
data = response.json()
malicious = data['positives']

def data_Check(malicious):
    if malicious == 0:
        return 0
    else:
        return 1

answer = data_Check(malicious)
print(answer)
#------------------------------------검사----------------------------------
# 데이터 전송
# send_data = 바이러스 검사 함수(url)
send_data = answer
print(send_data)
print(type(send_data))
client_socket.send(send_data.to_bytes(4, byteorder='little'))
print("send: ", send_data)

# 소켓 종료
client_socket.close()
print("클라이언트 종료")
server_socket.close()
print("서버 종료")