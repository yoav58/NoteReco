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
    userName = validUser(request.form['UserName'])
    password = validUser(request.form['Password'])
    answer = validUser(email,password)
    return answer
