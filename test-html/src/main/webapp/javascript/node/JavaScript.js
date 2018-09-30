var output = '';
for (var i = 0; i < 10; i++) {
  console.log(output += '*');
}
console.log('-----------------------------');
var os = require('os');
console.log(os);
console.log('-----------------------------');
console.log(os.hostname());
console.log(os.type());
console.log(os.platform());
console.log(os.arch());
console.log(os.release());
console.log(os.uptime());
console.log(os.loadavg());
console.log(os.totalmem());
console.log(os.freemem());
console.log(os.cpus());
console.log(os.getNetworkInterfaces());
console.log('-----------------------------');
var request = require('request');
request('http://www.google.com', function (error, response, body) {
  console.log(body);
});