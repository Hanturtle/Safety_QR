import requests
import Server


url = 'https://www.virustotal.com/vtapi/v2/url/report'
mykey = '5b515349e942c36fdb06b793b6fe2f7f0841926a181db41654e996046d0e745c'

def data_Check(malicious):
    if malicious == 0:
        return 0
    else:
        return 1

#URL = "naver.com"      # 안전URL
URL = "http://198.23.207.82/mad/men.exe"       # 악성 URL

params = {'apikey': mykey, 'resource': URL}
response = requests.get(url, params=params)
data = response.json()
malicious = data['positives']
print(malicious)


#data = response.json()
#malicious = data['positives']
#total = data['total']
#print(total)



answer = data_Check(malicious)
print(answer)