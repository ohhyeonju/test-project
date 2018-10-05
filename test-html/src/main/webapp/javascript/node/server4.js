var http = require('http');
var express = require('express');

var app = express();
app.use(express.static('public'));

app.get('/data.json', function (request, response) {
  var callback = request.query.callback;
  
  response.send(callback + '(' + JSON.stringify({
    제품명: '건조 망고',
    유형: '당절임',
    성분: '망고, 설탕, 메타중아황산나트륨, 치자황색소',
    원산지: '필리핀'
  }) + ')');
});

app.get('/data.redirect', function (request, response) {
  // 기상청 RSS 페이지에 데이터 요청
  http.get('http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000',
    function (web) {
      // 데이터를 읽을 때마다
    web.on('data', function (buffer) {
      response.write(buffer);
    });
    web.on('end', function () {
      response.end();
    });
  })
});


app.get('/data.redirect1', function (request, response) {
  var url = request.param('url');
  if (url) {
    http.get(url, function (web) {
      web.on('data', function (buffer) {
        response.write(buffer);
      });
      web.on('end', function () {
        response.end();
      });
    });
  } else {
    response.send('url 속성이 정의되지 않았습니다.')
  }
});

app.listen(52273, function () {
  console.log('Server Running at http://127.0.0.1:52773');
})