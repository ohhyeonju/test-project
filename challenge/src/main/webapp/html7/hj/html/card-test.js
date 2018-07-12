// div#header 태그에 /html/header.html 내용을 삽입한다.
/*$.get(serverRoot + "/html7/header.html", (data) => {
	$("#header").html(data);
	loadLoginUser();
});*/

/*var no = location.href.split("?")[1].split("=")[1];*/
$.getJSON(serverRoot + "/json/program/listCard", (data) => {
	$(ctitle).val(data.pname);
	$(cdegree).val(data.pth);
	$(cprice).val(data.pprice);
	$(clocal).val(data.bas_addr);
	$(cmax).val(data.maxqty);
	$(cday).val(data.sdt);
});



/*
$.ajax("../../json/board/list", {
    dataType: "json",
    success(data) {
    	for (var item of data) {
            var tr = document.createElement("tr");
            tr.innerHTML = "<td>" + item.no + "</td>" + 
                "<td><a href='form.html?no=" + item.no + "'>" + item.title + "</a></td>" + 
                "<td>" + item.createdDate + "</td>";
            tableBody.appendChild(tr);
        }
    },
    error() {
        window.alert("실행 오류!");
    }
});
*/