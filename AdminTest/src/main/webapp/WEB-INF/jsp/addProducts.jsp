<%@include file="./common/admHeader.jsp"%>
<%@include file="./common/admNav.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<script>
	function getSubCatgBYCatg() {
		var subCatg = $('#ors_mc_id').val();
		$.ajax({
			url : 'getSubCatgByCatg',
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			type : 'GET',
			data : {
				subCatgId : subCatg
			},
			success : function(data) {
				var options = '';
				if (data != null) {
					$.each(data, function(key, value) {
						options += "<option value='" + key + "'>" + value
								+ "</option>";
					});
					$('#subCatg').html(options);
				}
			}
		});
	}

	function validate() {
		if ($('#subCatg').val() === "-1") {

			alert("Please Select Sub Category!");
			$('#subCatg').focus();
			return false;
		}

	}
</script>

<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Product Categories</h1>

	</div>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Add Product
				Categories </h6>
		</div>
		<div class="card-body">
			<!-- <div class="table-responsive"> -->
			<div class="">

				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<form:form action="saveProducts" method="post"
							modelAttribute="prod">
							<form:hidden path="ors_prds_id" />
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="orsMainCategories.ors_mc_id">Select Main Catergories:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:select path="orsMainCategories.ors_mc_id"
											onchange="getSubCatgBYCatg()" id="ors_mc_id" class="form-control">
											<form:option value="">-SELECT-</form:option>
											<form:options items="${allMainCatgs}"
												itemLabel="ors_mc_category_name" itemValue="ors_mc_id" />
										</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<span>Select Sub Categories:</span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<select id="subCatg" name="ors_sub_id" class="form-control">
											<option value="-1">Select Sub Categories</option>
										</select>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_cat_no">Enter Cat No:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby="" 
											placeholder="Enter Cat No" path="ors_prds_cat_no" />
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_desc">Enter Product Description:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby="" 
											placeholder="Enter Product Description" path="ors_prds_desc" />
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_grade">Enter Product Grade:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby="" 
											placeholder="Enter Product Grade" path="ors_prds_grade" />
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_synonyms">Enter Synonyms:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby="" 
											placeholder="Enter Synonyms" path="ors_prds_synonyms" />
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_cas_no">Enter Cas No:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby=""
											placeholder="Enter Cas No" path="ors_prds_cas_no" />
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_make">Enter Make:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby=""
											placeholder="Enter Make" path="ors_prds_make" />
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_pack_size">Enter Pack Size:</form:label>
									</div>
								</div>
								<div class="col-md-6">  
									<div class="form-group">
										<form:input type="text" class="form-control"
											aria-describedby=""
											placeholder="Enter Pack Size" path="ors_prds_pack_size" />
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_avalibility">Enter Available:</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
									<form:input type="text" class="form-control"
											aria-describedby=""
											placeholder="Enter Available" path="ors_prds_avalibility" value="Contact US" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-3 py-md-2">
									<div class="form-group">
										<form:label path="ors_prds_orderBy">Assigned order</form:label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:select path="ors_prds_orderBy" class="form-control">
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