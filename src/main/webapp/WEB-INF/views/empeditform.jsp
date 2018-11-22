<%@ include file="template/header.jsp"%>
<div class="container">
	<h2>Edit Employee</h2>
	<form:form method="POST" action="/EmployeeManagement/employee/editsave" modelAttribute="employeeManufacture" cssClass="form-horizontal">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="col-lg-3 control-label">Name:</label>
			<div class="col-lg-8">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-lg-3 control-label">Email:</label>
			<div class="col-lg-8">
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-lg-3 control-label">Designation:</label>
			<div class="col-lg-8">
				<form:input path="designation" cssClass="form-control" />
			</div>
		</div>



		<div class="form-group">
			<label class="col-md-3 control-label"></label>
			<div class="col-md-8">
				<input type="submit" value="Edit Save" class="btn btn-primary" /> <span></span>
			</div>
		</div>
	</form:form>
</div>
<%@ include file="template/footer.jsp"%>
