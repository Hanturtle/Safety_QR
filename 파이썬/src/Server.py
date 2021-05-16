import socket
import Virus
import time

host = "127.0.0.1"          #서버쪽 IP
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
recv_data = recv_data.decode()

# print("url: ", recv_data.decode())  

# 데이터 전송
# send_data = 바이러스 검사 함수(url)
send_data = 1
client_socket.send(send_data)
print("send: ", send_data)

# 소켓 종료
client_socket.close()
print("클라이언트 종료")
server_socket.close()
print("서버 종료")