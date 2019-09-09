<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<%
	String loginId=(String)session.getAttribute("loginId");
%>
<head>
    <meta charset="UTF-8">
    <title> </title>
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

            font-size: 2rem;
            color: darkgreen;
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

        .ad{
            display: block;
            width: 90%;
            height: 300px;
            border: 1px solid black;
          
            text-align: center;
            vertical-align: center;
        }
        .post{
            display: inline-block;
            width: 30%;
            height:300px;
            border: 3px solid darkgreen;
           	margin-left:15px;
            float:left;
        }
      table {
            border-collapse: collapse;
            text-align: center;
            line-height: 1;

        }

        table thead th {
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            color: #369;
            border-bottom: 3px solid #036;
        }

        table tbody th {
            
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            border-bottom: 1px solid #ccc;
            background: #f3f6f7;
        }

        table td {
            
            padding: 10px;
            vertical-align: top;
            border-bottom: 1px solid #ccc;
        }
        

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
<%} %>
    </div>
    
    
    <div class='container'>
       <center>
           
         <div>
         
         </div>
        <div class='ad'>
            <img src="/project/resources/image/ad.jpg" alt="광고" style="width:100%;height:100%;">
			     
        </div>
        <br>
        
        <div style="width:90%">
        <div class="post">
        	<h3>매칭</h3>
           
           
           <table>
                    <thead>
                        <tr>
                            
                            <th scope="cols" width=300px>제목</th>
                            <th scope="cols" width=100px>작성자</th>

                        </tr>
                    </thead>
                    <c:forEach items="${MatchingPost2}" var="match">
                    <tbody>
                        <tr>
                          

                            <td width=300px>
                            	<a href="/project/api/MatchingContent?num=${match.num}" style="text-decoration: none;color:black;">
                            	${match.title}
                            	</a></td>
                            <td width=100px>${match.id}</td>
                            
                         
                        </tr>

                    </tbody>
                    </c:forEach>
       
                </table>
                <br>
                <div><input type="button" value="더보기" onclick="location.href='/project/MatchingForm'" class="button"></div>
        </div>
         <div class="post">
              	<h3>용병</h3>
           <table>
                    <thead>
                        <tr>
                            
                            <th scope="cols" width=300px>제목</th>
                            <th scope="cols" width=100px>작성자</th>

                        </tr>
                    </thead>
                    <c:forEach items="${GuestPost2}" var="guest">
                    <tbody>
                        <tr>
                          

                            <td width=300px>
                            	<a href="/project/api/GuestContent?num=${guest.num}" style="text-decoration: none;color:black;">
                            	${guest.title}
                            	</a></td>
                            <td width=100px>${guest.id}</td>
                            
                         
                        </tr>

                    </tbody>
                    </c:forEach>
       
                </table>
                <br>
                <div><input type="button" value="더보기" onclick="location.href='/project/GuestForm'" class="button"></div>
        
        </div>
        </div>
         <div class="post">
                    	<h3>커뮤니티</h3>
           <table>
                    <thead>
                        <tr>
                            
                            <th scope="cols" width=300px>제목</th>
                            <th scope="cols" width=100px>작성자</th>

                        </tr>
                    </thead>
                    <c:forEach items="${CommunityPost2}" var="community">
                    <tbody>
                        <tr>
                          

                            <td width=300px>
                            	<a href="/project/api/CommunityContent?num=${community.num}" style="text-decoration: none;color:black;">
                            	${community.title}
                            	</a></td>
                            <td width=100px>${community.id}</td>
                            
                         
                        </tr>

                    </tbody>
                    </c:forEach>
       
                </table>
     <br>
     <div><input type="button" value="더보기" onclick="location.href='/project/CommunityForm'" class="button"></div>
        
        </div>
        </div>
   
           
       </center>
        
        </div>
        
    </div>
</body>

</html>
