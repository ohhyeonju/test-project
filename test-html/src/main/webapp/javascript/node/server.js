var express = require('express');

var app = express();


app.use(function (request, response, next) {
  request.test = 'request.test';
  response.test = 'response.test';
  console.log('first');
  next();
});
app.use(function (request, response, next) {
  console.log('second');
  next();
});
app.use(function (request, response, next) {
  response.send('<h1>Hello Middleware</h1>' 
      + '<h1>' + request.test + '::' + response.test + '</h1>');
});

app.listen(52273, function () {
  console.log('Server Running at http://127.0.0.1:52773');
})