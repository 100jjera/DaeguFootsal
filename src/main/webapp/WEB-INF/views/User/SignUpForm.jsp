<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    </style>

</head>

<body>

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
            
            <li><a href="/project/login">로그인</a></li>
        </ul>
    </div>
    <div class='container'>
        <div class='section'>
    		<div class="title">Daegu Footsal</div>
    		<!-- <form action="" method="post"> -->
    		<form action="/project/api/signup" method="post">
    		<div><input type="text" name="id" placeholder="아이디를 입력해주세요"></div>
    		<div><input type="password" name="password" placeholder="비밀번호를 입력해주세요"></div>
    		<div><input type="password" name="password2" placeholder="비밀번호를 한번더 입력해주세요"></div>
    		<div><input type="text" name="name" placeholder="성함을 적어주세요"></div>
    		<div><input type="text" name="phoneNum" placeholder="전화번호를 입력해주세요"></div>
    		<div><input type="text" name="birth" placeholder="생년월일을 입력하세요(-포함)"></div>
    		<div><input type="submit" value="Sign Up" class="button" ></div>
    		
    		</form>
        </div>
    </div>
</body>

</html>
