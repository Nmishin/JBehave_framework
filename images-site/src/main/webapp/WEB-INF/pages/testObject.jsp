<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval expression="@propertyConfigurer.getProperty('baseline.image.path')"  var="baselineImagePath"/>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="resources/css/main.css">
  <link rel="stylesheet" href="resources/css/pure-min.css">
  <script type="text/javascript" src="jquery-1.2.6.min.js"></script>
  <title>Test Objects</title>
</head>

<header>
  <div style="position: absolute; top: 0px; left:-8px;">
    <span class="green header-line header-line-first"/>
    <span class="green header-line"/>
    <span class="aqua header-line"/>
    <span class="purple header-line"/>
    <span class="red header-line"/>
  </div>

  <div class="header-title green-text">Test Object</div><div class="header-icon green cone-light"/><a class="header-back" href="/"></a>
</header>


<body class="body">
<table class="pure-table">
            <tr>
                <td>ID:</td>
                <td>${testObject.areaId}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${testObject.areaName}</td>
            </tr>
            <tr>
                <td>Browser: </td>
                <td>${testObject.browserName}</td>
            </tr>
            <tr>
                <td>Browser version: </td>
                <td>${testObject.browserVersion}</td>
            </tr>
            <tr>
                <td>Browser width: </td>
                <td>${testObject.browserWidth}</td>
            </tr>
            <tr>
                <td>Browser height: </td>
                <td>${testObject.browserHeight}</td>
            </tr>
            <tr>
                <td>Area width: </td>
                <td>${testObject.width}</td>
            </tr>
            <tr>
                <td>Area height: </td>
                <td>${testObject.height}</td>
            </tr>
            <tr>
                <td>Pos Y: </td>
                <td>${testObject.posX}</td>
            </tr>
            <tr>
                <td>Pos Y: </td>
                <td>${testObject.posY}</td>
            </tr>
        </table>
        <br/>
        <br/>
        Baseline image:
        <br/>
        <img src="${baselineImagePath}${testObject.fileName}" alt="Baseline image" >
</body>
</html>