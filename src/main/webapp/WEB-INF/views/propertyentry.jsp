<html>
<body>
	<h3>Property Details</h3>
	<hr>
		<form action="saveproperty" method="post" enctype="multipart/form-data">
		<pre>
			PCode	<input type="text" name="pcode"/>
			PType	<input type="text" name="ptype"/>
			Owner	<input type="text" name="owneremail"/>
			Price	<input type="text" name="price"/>
			Photo	<input type="file" name="f1"/>
			Registry<input type="file" name="f2"/> (pdf only)
				<input type="submit" value="Save"/>
		</pre>
		</form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>