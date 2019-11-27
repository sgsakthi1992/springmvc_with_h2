<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<html>
	<head>
	<title>Phone Directory</title>
	</head>
	<body>
		<div>
			<table>
				<thead>
		            <tr>
			            <th>Id</th>
		                <th>First Name</th>
		                <th>Last Name</th>
		                <th>Phone Number</th>
		                <th>Phone Company</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${usersList}" var="user">
		        		<tr>
		        			<td>${ user.id }</td>
		        			<td>${ user.firstName }</td>
		        			<td>${ user.lastName }</td>
		        			<td>${ user.phoneNumber }</td>
		        			<td>${ user.phoneCompany }</td>
			        	</tr>
		        	</c:forEach>
		        </tbody>
			</table>
		</div>
	</body>
</html>