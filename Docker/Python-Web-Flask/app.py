from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/')
def hello():
    return jsonify(message="Hello, welcome to the API!, Tanver Ahammed")

@app.route('/<name>')
def greet(name):
    return jsonify({'message': f'Hello, {name}!'})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
