<%@include file="./common/admHeader.jsp"%>
<%@include file="./common/admNav.jsp"%>



<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Main Categories</h1>
		<a href="addSubCategories"
			class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
			class="fas fa-plus fa-sm text-white-50"></i> Add Sub
			Categories</a>
	</div>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Display Sub
				Categories List</h6>
		</div>
		<div class="card-body">
			<!-- <div class="table-responsive"> -->
			<div class="">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

					<div class="row">
						<div class="col-sm-12">
							<table class="table table-bordered dataTable" id="dataTable"
								width="100%" cellspacing="0" role="grid"
								aria-describedby="dataTable_info" style="width: 100%;">
								<thead>
									<tr role="row" class="text-center">
										<th>S No</th>
										<th>Main Category</th>
										<th>Sub Category</th>
										<th>Order</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:set var="i" value="1" />
									<c:forEach var="list" items="${listSubCatgs}">
										<tr class="text-center">
											<td><c:out value="${i}" /></td>
											<td><c:out
													value="${list.orsMainCategories.ors_mc_category_name}" /></td>
											<td><c:out value="${list.ors_sub_category_name}" /></td>

											<td><c:out value="${list.ors_sub_order}" /></td>
											<td >
											<a
												href="editSubCatg?id=<c:out value="${list.ors_sub_id}"/>"><i class="fas fa-pencil-alt" style="color: #4c4cd2;"></i></a>
											&emsp;<a
												href="deleteSubCatg?id=<c:out value="${list.ors_sub_id}"/>"><i class="fas fa-trash" style="color:red"></i></a></td>
										</tr>
										<c:set var="i" value="${i+1}" />
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</div>





</div>
<!-- End of Main Content -->
<%@include file="./common/admFooter.jsp"%>