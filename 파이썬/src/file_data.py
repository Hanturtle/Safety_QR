import requests
import Hash

url = 'https://www.virustotal.com/vtapi/v2/file/report'
mykey = '5b515349e942c36fdb06b793b6fe2f7f0841926a181db41654e996046d0e745c'

# 악성코드파일 : 안드로이드에서 받기 -> 악성코드를 MD5로 변환
#MD5 = "9F7D893E2054612E7644B4EC4D2D3B22" 

client_file = "pmj.txt"
yes = "9F7D893E2054612E7644B4EC4D2D3B22" 

MD5 = Hash.get_MD5(client_file)
SHA1 = Hash.get_SHA1(client_file)
SHA256 = Hash.get_SHA256(client_file)

params = {'apikey': mykey, 'resource': yes}
response = requests.get(url, params=params)

data = response.json()

malicious = data['positives']
total = data['total']
print(malicious)
print(total)

# 악성 판별 함수
# 0이면 안전한 URL
# 1이면 악성URL
def data_Check(malicious):
    if malicious == 0:
        return 0
    else :
        return -1

answer = data_Check(malicious)
print(answer)