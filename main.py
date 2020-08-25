import hashlib
import itertools
import string

def md5_100(password):
    hashedPassword = hashlib.md5(password.encode())
    hashStore = [hashedPassword]
    for _ in range(1, 100):
        reHash = hashlib.md5(hashStore[-1].hexdigest().encode('utf-8'))
        hashStore.append(reHash)
    return hashStore[99].hexdigest()

def sha256_100(password):
    hashedPassword = hashlib.sha256(password.encode())
    hashStore = [hashedPassword]
    for _ in range(1, 100):
        reHash = hashlib.sha256(hashStore[-1].hexdigest().encode('utf-8'))
        hashStore.append(reHash)
    return hashStore[99].hexdigest()

def sha512_100(password):
    hashedPassword = hashlib.sha512(password.encode())
    hashStore = [hashedPassword]
    for _ in range(1, 100):
        reHash = hashlib.sha512(hashStore[-1].hexdigest().encode('utf-8'))
        hashStore.append(reHash)
    return hashStore[99].hexdigest()

def creat_set():
    text_file = open("charSet.txt", "w")
    charset = string.ascii_lowercase
    result = itertools.product(charset, repeat=5)
    result_list = [*result]
    final_list = [""] * 11881376
    for i in range(0, 11881376):
        chars = ""
        for j in range(0, 5):
            chars = chars + result_list[i][j]
        final_list[i] = chars

    for line in final_list:
        text_file.write(line)
        text_file.write("\n")
    text_file.close()

f = open("charSet.txt","r")
deshash = "f032601da1955ec89ca006d349a044c315c8cf02a6c5f0dae7a652e28d8d2e47546f2ef12a977cf55c0dc8fe8981641ffbe632a9fad2f3913fb324f95d7cc618"
pw = ""
for x in f:
    pw = x.strip()
    hashpwmd5 = md5_100(pw)
    hashsha256 = sha256_100(hashpwmd5)
    hsha512 = sha512_100(hashsha256)
    if(hsha512 == deshash):
        print("Crack!")
        print(pw)
        break
f.close()

