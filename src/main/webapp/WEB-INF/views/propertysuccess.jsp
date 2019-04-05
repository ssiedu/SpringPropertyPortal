<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<body>
	<h3>Property Details Stored Successfully</h3>
	<h4>Following Details Are Stored</h4>
	<hr>
	<pre>
		PCode	${property.pcode}
		PType	${property.ptype}
		Owner	${property.owneremail}
		Price	${property.price}
	</pre>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>