<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String loginId=(String)session.getAttribute("loginId"); %>
<!DOCTYPE html>
<html lang="en">

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
        table {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    margin: 20px 10px;
}
table th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    text-align:center;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #efefef;
}
table td {
    width: 350px;
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
            <li><a href="/project/InfoForm">매칭</a></li>
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
            <li><a href="/project/InfoForm">매칭</a></li>
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
        <div class='section'>
            <center>

			<form action="/project/api/CommunityUpdate" method="post">
				<input type=hidden name= num value="${CommunityContent.num }">
				<table >
				    <tr>
				        <th scope="row">작성자</th>
				        <td><input type=text name="id" value=${loginId} style="width:500px;border:none;"></td>
				    </tr>
				    <tr>
				        <th scope="row">제목</th>
				        <td><input type=text name="title" value="${CommunityContent.title}" style=" width:500px "></td>
				    </tr>
				    <tr>
				        <th scope="row">내용</th>
				        <td><input type=text name="content" value="${CommunityContent.content}" style=" width:500px;height: 300px;"></td>
				    </tr>
				       
                       
                    
				</table>
				<div>
					<input type="submit" value="글  수정" class=button>
                    <input type="button" value="취소" onclick="location.href='/project/CommunityForm'" class=button>
				</div>
			  
			</form>
              

            </center>

        </div>
    </div>
</body></html>
