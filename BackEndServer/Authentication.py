import pyrebase


"""
fireBase configurations.
"""
# config file of our project in fireBase
config = {
    "apiKey": "AIzaSyBHe0Mkw_wzJH2teGsdxKY8bTZZ6wBno6o",
    "authDomain": "notereco-50ac7.firebaseapp.com",
    "projectId": "notereco-50ac7",
    "storageBucket": "notereco-50ac7.appspot.com",
    "messagingSenderId": "910037595831",
    "appId": "1:910037595831:web:243e1abdded3436c38ff32",
    "measurementId": "G-92BXHYVL77",
    "databaseURL": ""
}
# create authentication object
firebae = pyrebase.initialize_app(config)
authentication = firebae.auth()



"""""""""""""""""""""
validUser:
input: the email and password of ther user
output: boolean, True if the user exists False otherwise
"""""""""""""""""""""
def validUser(email,password):
    try:
        value = authentication.sign_in_with_email_and_password(email, password)
        return True
    except:
        return False

