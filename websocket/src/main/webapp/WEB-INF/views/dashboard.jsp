<%--
  Created by IntelliJ IDEA.
  User: i11073
  Date: 5/24/2019
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../res/css/one.css"/>
    <script type="text/javascript" src="webjars/sockjs-client/1.1.2/sockjs.js"></script>
    <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.js"></script>
    <script type="text/javascript" src="webjars/stomp-websocket/2.3.3-1/stomp.js"></script>
</head>
<body onload="connect()">
<h1>Write your message</h1>
<form method="POST">
    <input type="text" id="sentBy" name="sentBy"/>
    <input type="text" id="messageText" name="messageText"/>
    <input type="button" onclick="sendNow()" value="send Now"/>
</form>
<input type="text" name="resp" id="resp">


</body>

<script type="text/javascript">
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/questions');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            // sendMessage();
            console.log('Connected: ' + frame.body);
            stompClient.subscribe('/topic/questions', function (messageOutput) {
                showMessageOutput(JSON.parse(messageOutput.body));
            });
        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendNow(){
        sendMessage();
    }

    function sendMessage() {
        var from = document.getElementById('sentBy').value;
        var text = document.getElementById('messageText').value;
        stompClient.send("/app/messages", {},
            JSON.stringify({'from': from, 'text': text}));
    }

    function showMessageOutput(messageOutput) {
        var response = document.getElementById('resp');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(messageOutput.from + ": "
            + messageOutput.text + " (" + messageOutput.time + ")"));
        response.appendChild(p);
    }
</script>
</html>
