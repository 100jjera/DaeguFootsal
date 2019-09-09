<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <% String loginId=(String)session.getAttribute("loginId"); %>
       <%
       String ResDate=(String)request.getParameter("ResDate");
    %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
     
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <style>
       .ui-datepicker{ font-size: 30px; width: 500px; }
	.ui-datepicker select.ui-datepicker-month{ width:30%; font-size: 20px; }
	.ui-datepicker select.ui-datepicker-year{ width:40%; font-size: 20px; }
</style>
    <script>
        $(function(){
            document.getElementById("currentDate").innerHTML = getFormatDate(new Date());
            $("#datepicker").datepicker({
                onSelect: function(dateText, inst){
                    console.log(dateText);
                    console.log(inst);
                    location.href = "/project/GroundCheck?ResDate="+ dateText;
                }, 
                dateFormat: "yy-mm-dd"
            });
            
        });
        
        function getFormatDate(date)
        { 
        	var year = date.getFullYear();	//yyyy 
        	var month = (1 + date.getMonth());	//M 
        	month = month >= 10 ? month : '0' + month;	//month 두자리로 저장 
        	var day = date.getDate();	//d
       		 day = day >= 10 ? day : '0' + day;	//day 두자리로 저장 
        	return year + '-' + month + '-' + day;
       }

    </script>
    <style>
        .logo {
            position: absolute;
            background-color: darkgreen;
            color: white;
            left: 0;
            top: 0;
            padding: 0 16px;
            line-height: 60px;
            height: 60px;
        }

        .header {
            height: 60px;
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            background-color: white;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
            font-family: fantasy;

        }

        .nav {
            position: absolute;
            left: 150px;
            top: 0;
            font-weight: bold;
        }

        .nav2 {
            position: absolute;
            right: 0;
            top: 0;
            font-weight: bold;
        }

        .nav2>li {
            display: inline-block;
            padding: 0 30px;
            line-height: 30px;

        }

        .nav>li {
            display: inline-block;
            padding: 0 50px;
            line-height: 30px;
        }


        .nav>li>a {
            color: darkslategrey;
            text-decoration: none;
        }

        .nav2>li>a {
            color: darkslategrey;
            text-decoration: none;
        }

        .nav>li>a:after {
            display: block;
            content: '';
            border-bottom: solid 3px darkgreen;
            transform: scaleX(0);
            transition: transform 250ms ease-in-out;
        }

        .nav>li>a:hover:after {
            transform: scaleX(1);

        }

        .nav2>li>a:after {
            display: block;
            content: '';
            border-bottom: solid 3px darkgreen;
            transform: scaleX(0);
            transition: transform 250ms ease-in-out;
        }

        .nav2>li>a:hover:after {
            transform: scaleX(1);

        }

        #nav-toggle {
            visibility: hidden;
        }

        .navicon {
            display: none;
        }


        .container {
            padding-top: 60px;

            max-width: 1200px;

            margin: 0 auto;

            min-height: 100%;
        }

        .container::after {
            content: '';
            display: block;
            clear: both;
        }

        .section {
        	
        	display:inline-block;
            height: 600px;
            width: 100%;
            float: left;
            margin-top: 60px;
            text-align: center;
        }

        .section>form>div {
            margin-top: 20px;
        }

        .section>form>div>input {
            width: 30%;
            text-align: center;
        }

  .title {

            font-size:1.5rem;
            font-weight:bold;
            color: #036;
            text-align: center;
            font-family: fantasy;

        }


 

        .button {
            background: darkgreen;
            color: #fff;
            border: none;
            position: relative;
            font-size: 1em;
            padding: 0 2em;
            cursor: pointer;
            transition: 800ms ease all;
            outline: none;
            font-family: fantasy;
            
        }

        .button:hover {
            background: #fff;
            color: darkgreen;
        }

  
  

        table {
            border-collapse: collapse;
            text-align: center;
            line-height: 1;

        }


        table tbody th {
            
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            border-bottom: 1px solid #ccc;
            background: #f3f6f7;
        }

        table tbody td {
            width:300px;
            padding: 10px;
            vertical-align: top;
            text-align:center;
            border-bottom: 1px solid #ccc;
        }
        
        <!--상세페이지 접속--!>
       
   
 
    </style>

</head>

<body>

<%
	if(loginId==null){
%>
    <div class='header'>
   	
        <div class='logo'>
            <a href="/project/home" style="text-decoration: none; color:white; font-family: fantasy;">Daegu Footsal</a>
        </div>

        <input id='nav-toggle' type='checkbox'>
        <label class='navicon' for='nav-toggle'>menu</label>
       <ul class='nav'>
            <li><a href="/project/InfoForm">공지사항</a></li>
            <li><a href="/project/GroundForm">구장 예약</a></li>
            <li><a href="/project/MatchingForm">매칭</a></li>
            <li><a href="/project/GuestForm">용병</a></li>
            <li><a href="/project/CommunityForm">커뮤니티</a></li>
        </ul>
        <ul class='nav2'>
            <li><a href="/project/signup">회원가입</a></li>
            <li><a href="/project/login">로그인</a></li>
        </ul>

    </div>
    </div>
    <div class='container'>
        <div class='section'>
			<div> 로그인 하셔야 이용하 실 수 있습니다 .</div>
			<div><input type="submit" value="로그인하러가기" class="button" onclick="location.href='/project/login'" /></div>
		
		</div>
    </div>
    <%}
	else{  
    %>
     <div class='header'>
   	
        <div class='logo'>
            <a href="/project/home" style="text-decoration: none; color:white; font-family: fantasy;">Daegu Footsal</a>
        </div>

        <input id='nav-toggle' type='checkbox'>
        <label class='navicon' for='nav-toggle'>menu</label>
          <ul class='nav'>
            <li><a href="/project/InfoForm">공지사항</a></li>
            <li><a href="/project/GroundForm">구장 예약</a></li>
            <li><a href="/project/MatchingForm">매칭</a></li>
            <li><a href="/project/GuestForm">용병</a></li>
            <li><a href="/project/CommunityForm">커뮤니티</a></li>
        </ul>
        <ul class='nav2'>
            <li><%=loginId %> 님</li>
            <li><a href="/project/logout">로그아웃</a></li>
   
        </ul>
        </div>
    	<div class='container'>
        <div class='section'>
          
            <center>
         	<div style=" display:inline-block;min-width:900px">
         		<div id="datepicker" style="float:left;"></div>
         		<div style="float:left;margin-left:20px;"> 
         		<form action="/project/api/Ground" method="get" >
         			<%if(ResDate!=null){ %>
					<table>
		                   <tbody>
		                        <tr>
		                           
		                            <th>예약날짜</th>
		                           
		                            <td >
		                            <input type="text"id="currentDate" name="ResDate" value=<%=ResDate %> style="border:none;font-size:1.1rem;font-weight: bold;">
		                            </td>
		                        </tr>
		                        <tr>
		                        	<th>예약자</th>
		                        	<td><input type="hidden" name="ResId" value=${loginId}><%=loginId %></td>
		                        </tr>
		                        <tr >
		                        	<th rowspan="5">시간대</th>
		                        	<td>
		                        	<c:if test="${GroundCheck.time1 eq null}">
		                        	<input type="checkbox" name="Time1" value="${GroundCheck.time1}">12:00~14:00
		                        	</c:if>
		                        	<c:if test="${not empty GroundCheck.time1}">
		                        	<div style="text-decoration: line-through;">12:00~14:00</div>
		                        	</c:if>
		                        	</td>
			                    </tr>
		                        
		                        <tr>
		                        	<td>
		                        	<c:if test="${empty GroundCheck.time2}">
		                        	<input type="checkbox" name="Time2" value="${GroundCheck.time2}">14:00~16:00
		                        	</c:if>
		                        	<c:if test="${not empty GroundCheck.time2}">
		                        	<div style="text-decoration: line-through;">14:00~16:00</div>
		                        	</c:if>
		                        	</td>
		                        </tr>
		                        <tr>
		                        	<td>
		                        	<c:if test="${empty GroundCheck.time3}">
		                        	<input type="checkbox" name="Time3"value="${GroundCheck.time3}">16:00~18:00
		                        	</c:if>
		                        	<c:if test="${not empty GroundCheck.time3}">
		                        	<div style="text-decoration: line-through;">16:00~18:00</div>
		                        	</c:if>
		                        	</td>
		                        </tr>
		                   		<tr>
		                   			<td>
		                        	<c:if test="${empty GroundCheck.time4}">
		                        	<input type="checkbox" name="Time4" value="${GroundCheck.time4}">18:00~20:00
		                        	</c:if>
		                        	<c:if test="${not empty GroundCheck.time4}">
		                        	<div style="text-decoration: line-through;">18:00~20:00</div>
		                        	</c:if>
		                        	</td>
		                   		</tr>
		                   		<tr>
		                   			<td>
		                        	<c:if test="${empty GroundCheck.time5}">
		                        	<input type="checkbox" name="Time5" value="${GroundCheck.time5}">20:00~22:00
		                        	</c:if>
		                        	<c:if test="${not empty GroundCheck.time5}">
		                        	<div style="text-decoration: line-through;">20:00~22:00</div>
		                        	</c:if>
		                        	</td>
		                   		</tr>
		                        	
		                        
		                    </tbody>
		                </table>
		                <br>
		                <input type="submit" value="예약하기" class="button">
		         <%}else{ %>
		         <table>
		                   <tbody>
		                        <tr>
		                           
		                            <th>예약날짜</th>
		                           
		                            <td >
		                            <input type="hidden"id="currentDate" name="ResDate" value=<%=ResDate %> style="border:none;font-size:1.1rem;font-weight: bold;">
		                            	원하시는 날짜를 선택하세요!
		                            </td>
		                        </tr>
		                        <tr>
		                        	<th>예약자</th>
		                        	<td><input type="hidden" name="ResId" value=${loginId}><%=loginId %></td>
		                        </tr>
		                      
		                     
		                        
		                    </tbody>
		                </table>
		               
		         
		         <%} %>
		         
		         </form>
      			
         		
	             </div>
         	
         	</div>
      		</center>
        </div>
    </div>
    <%}%>
      
</body>

</html>
<!-- 
<form action="/project/GroundCheck" method="get" >
         			<input type="text" id="currentDate" name ="ResDate">
         	        <input type="submit" value="조회하기" class="button">
		         </form> -->
