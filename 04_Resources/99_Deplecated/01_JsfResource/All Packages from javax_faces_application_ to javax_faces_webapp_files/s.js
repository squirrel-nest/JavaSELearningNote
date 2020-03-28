var req;
var div;
var urx;

function showdocjar(d, n) {
 if(window.XMLHttpRequest) {
   req = new XMLHttpRequest();
   req.onreadystatechange=processReqChange;
   urx =  n+".jsp?q="+d;
   req.open("GET", n+".jsp?q="+d, true);
   req.send(null);
 } else if(window.ActiveXObject) {
  req = new ActiveXObject("Microsoft.XMLHTTP");
  if(req) {
   req.onreadystatechange=processReqChange;
   urx =  n+".jsp?q="+d;
   req.open("GET", n+".jsp?q="+d, true);
   req.send();
  }
 }
}
 
 function processReqChange() {
  div.innerHTML="<font color=red>Please wait ......</font>";
  if (req.readyState == 4) {
   if (req.status == 200) {
    div = document.getElementById("docjar");
    div.innerHTML=req.responseText;
req = null;
   } else {
    if (req.status == 401 ) {
      div.innerHTML = "<br><br><div align=center><a href=# onclick='show(\"<%=ref%>&tx=<%=System.currentTimeMillis()%>\",\"/docjar_new\")'> Please click here and create a DocJar account</a>.<br>Do you forget your password? <a href=/i18n/forgot.jsp>Reset DocJar password</a>.</div><br><br>"       
    } else {
      div.innerHTML="HTTP Error: "+req.status+" - " + urx;
      alert("HTTP Error: "+req.status);
    }
   }
  }
 }

function show(d, n) {
 div = document.getElementById("docjar");
 showdocjar(d, n);
}
