var express = require('express');
var bodyParser = require('body-parser');

var app = express();
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: false }));

var messages = [];

app.get('/messages', function (request, response) {
  response.send(messages);
});
app.post('/messages', function (request, response) {
  var name = request.body.name;
  var content = request.body.content;
  var message = {
      name: name,
      content: content
  }
  messages.push(message);
  
  response.send({
    message: '데이터를 추가했습니다.',
    data: message
  });
});

app.listen(52273, function () {
  console.log('Server Runnig at http://127.0.0.1:52273');
});