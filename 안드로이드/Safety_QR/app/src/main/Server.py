import socket
import time
host = "192.168.25.11"
port = 8080

server = socket.socket(socket.AF_INET)
server.bind((host,port))
print(231)
server.listen(1)
print(123)

connection, addr = server.accept()
print(343)
print("client: ", addr)

send_data = "malicious"
recv_data = connection.recv(1024)

if recv_data:
    print("url: ", recv_data.decode())
connection.send(send_data)

server.close()
connection.close()