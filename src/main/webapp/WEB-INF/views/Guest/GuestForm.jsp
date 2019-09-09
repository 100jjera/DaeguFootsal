<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="title">용병</div>
            <br>
            <center>
                 <table>
                    <thead>
                        <tr>
                            <th scope="cols" width=50px>번호</th>
                            <th scope="cols" width=300px>제목</th>
                            <th scope="cols" width=100px>작성자</th>

                            <th scope="cols" width=200px>작성일</th>
                            <th scope="cols" width=50px>조회수</th>
                        </tr>
                    </thead>
                    <c:forEach items="${GuestPost}" var="guest">
                    <tbody>
                        <tr>
                            <th scope="row" width=50px>${guest.num }</th>

                            <td width=300px>
                            	<a href="/project/api/GuestContent?num=${guest.num}" style="text-decoration: none;">
                            	${guest.title}
                            	</a></td>
                            <td width=100px>${guest.id}</td>
                            
                            <td width=200px>${guest.regdate}</td>
                            <td width=50px>${guest.viewcnt}</td>
                        </tr>

                    </tbody>
                    </c:forEach>
       
                </table>
             <br>
                <div>
                    <c:if test="${pagination.curRange ne 1 }">
                        <a href="/project/GuestForm?pageNum=1&searchOption=${searchOption }&keyword=${keyword}" onClick="fn_paging(1)">[처음]</a> 
                    </c:if>
                    <c:if test="${pagination.curPage ne 1}">
                        <a href="/project/GuestForm?pageNum=${pagination.prevPage}&searchOption=${searchOption }&keyword=${keyword}" onClick="fn_paging('${pagination.prevPage }')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
                        <c:choose>
                            <c:when test="${pageNum eq  pagination.curPage}">
                                <span style="font-weight: bold;"><a href="/project/GuestForm?pageNum=${pageNum}&searchOption=${searchOption }&keyword=${keyword}" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
                            </c:when>
                            <c:otherwise>
                                <a href="/project/GuestForm?curPage=${pageNum}&searchOption=${searchOption }&keyword=${keyword}" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
                        <a href="/project/GuestForm?curPage=${pagination.nextPage}&searchOption=${searchOption }&keyword=${keyword}" onClick="fn_paging('${pagination.nextPage }')">[다음]</a> 
                    </c:if>
                    <c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
                        <a href="/project/GuestForm?curPage=${pagination.pageCnt}&searchOption=${searchOption }&keyword=${keyword}" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a> 
                    </c:if>
                </div>
                	<br>       
       			<div>
       				<form action="/project/GuestForm", method="post" >
       				<select name="searchOption">
       					<option value="all" <c:if test="${searchOption eq 'all'}">selected</c:if>>제목+아이디+내용</option>
       					<option value="id"<c:if test="${searchOption eq 'id'}">selected</c:if>>아이디</option>
       					<option value="content" <c:if test="${searchOption eq 'content'}">selected</c:if> >내용</option>
       					<option value="title" <c:if test="${searchOption eq 'title'}">selected</c:if> >제목</option>
       				</select>
       				<input type="text" name="keyword" placeholder="search" value="${keyword}">
       				<input type="submit" value="검색" class="button"/>
       			<input type="button" value="글 작성하기" class="button" onclick="location.href='/project/Guest'" />
       				</form>
       				
       				
       			</div>
                   </center>
         </div>
    </div>
<%} %>
    
</body>

</html>
