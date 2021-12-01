from Authentication import validUser
from flask import *

app = Flask(__name__)

email = "lior@walla.co.il"
password = "123456"
x = validUser(email, password)
if x:
    print("valid user")
else:
    print("non valid user")

@app.route('/aut', methods=['POST'])
def authentication():
    print("get request")
    print(request.form)
    userName = request.form['username']
    print("1")
    password = request.form['password']
    print("2")
    answer = validUser(userName, password)
    stringAnswer = "Wrong"
    if answer:
        stringAnswer = "Correct"
        print(stringAnswer)
    return stringAnswer

@app.route("/")
def enter():
    return "hello"
