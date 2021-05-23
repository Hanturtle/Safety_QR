import hashlib
import os


#file_name = "pmj.txt"


def get_MD5(file_name):
    f = open(file_name, 'rb')
    data = f.read()
    f.close()

    hash_md5 = hashlib.md5()
    hash_md5.update(data)
    md5 = hash_md5.hexdigest()
    return md5

def get_SHA1(file_name):
    f = open(file_name, 'rb')
    data = f.read()
    f.close()

    hash_sha1 = hashlib.sha1()
    hash_sha1.update(data)
    sha1 = hash_sha1.hexdigest()
    return sha1

def get_SHA256(file_name):
    f = open(file_name, 'rb')
    data = f.read()
    f.close()

    hash_sha256 = hashlib.sha256()
    hash_sha256.update(data)
    sha256 = hash_sha256.hexdigest()
    return sha256
   
def file_Remove(file_name):
    os.remove("pmj.txt")

