<%@ include file="template/header.jsp"%>
<div class="container">
<h2>Welcome to Website</h2>
<a href="/EmployeeManagement/employee/viewemp" data-toggle="tooltip" title="Click here to view list of employees">List of Employees</a>
<br>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</div>
<%@ include file="template/footer.jsp"%>