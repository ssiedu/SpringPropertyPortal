<%@ page isELIgnored="false"%>
<html>
<body>
<h3>Property Details</h3>
<hr>
	<pre>
		PCode	${property.pcode}
		PType	${property.ptype}
		Price	${property.price}
		Owner	${property.owneremail}
		Regisry <a href="registryLoader?pcode=${property.pcode}">View-Registry</a>
		<img src="imageLoader?pcode=${property.pcode}" width="50" height="50"/>
		
	</pre>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>