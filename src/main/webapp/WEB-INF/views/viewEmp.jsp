<%@ include file="template/header.jsp"%>
<div class="container">
	<h2>The list of employees</h2>
	<a href="/EmployeeManagement/employee/empform" data-toggle="tooltip" title="Click here to add new an employee">Add Employee</a><br>
	<a href="/EmployeeManagement/home" data-toggle="tooltip" title="Click here to return home page">Home Page</a>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Designation</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.email}</td>
				<td>${emp.designation}</td>
				<td><a href="editemp/${emp.id}">Edit</a></td>
				<td><a href="deleteemp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
<%@ include file="template/footer.jsp"%>