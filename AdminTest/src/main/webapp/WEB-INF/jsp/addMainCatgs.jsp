<%@include file="./common/admHeader.jsp"%>
<%@include file="./common/admNav.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>


<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Main Categories</h1>

	</div>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Add Main
				Categories List</h6>
		</div>
		<div class="card-body">
			<!-- <div class="table-responsive"> -->
			<div class="">

				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<form:form action="saveMainCatergories" method="post"
							modelAttribute="catg">
							<form:hidden path="ors_mc_id" />
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_mc_category_name">Main Category Name:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control form-control-user"
											aria-describedby="" name="loginId"
											placeholder="Main Category Name" path="ors_mc_category_name" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_order">Assigned order</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
											<form:select path="ors_order" class="form-control"> 
									<form:option value="NONE" label="Select" />
									<form:options items="${alphabetOrder}" />
								</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 py-md-2">
								</div>
								<div class="col-md-6">
								<input type="submit" value="Submit" class="btn btn-success">
								</div>
							</div>
			
							
						</form:form>
					</div>
					<div class="col-sm-2"></div>
				</div>

			</div>
		</div>
	</div>

</div>





</div>
<!-- End of Main Content -->
<%@include file="./common/admFooter.jsp"%>