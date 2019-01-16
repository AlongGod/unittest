var TestCaseTableAjax = function() {

	var handleRecords = function() {

		var grid = new Datatable();
		grid.init({
					src : $("#testCaseManagementTable"),
					onSuccess : function(grid) {

					},
					onError : function(grid) {

					},
					dataTable : {
						"sAjaxDataProp" : "records",
						"sAjaxSource" : testCaseManagementURL,
						"aoColumns" : [
								/*{
									"mDataProp" : null,
									"sDefaultContent" : "",
									// "sWidth":"23%",
									bSortable : false,
									"fnRender" : function(oObj) {
										var id = oObj.aData.id;
										return '<input type="checkbox" class="checkboxes" value="1"/>';
									}
								},*/
				                    {
										"mDataProp" : "id",
	                                    bSortable : true,
										"sClass" : "center"
									},
				                    {
										"mDataProp" : "name",
	                                    bSortable : true,
										"sClass" : "center"
									},
				                    {
										"mDataProp" : "desc",
	                                    bSortable : true,
										"sClass" : "center"
									},
								{
									"mDataProp" : null,
									// "sWidth":"23%",
									"sDefaultContent" : "",
									bSortable : false,
									"fnRender" : function(oObj) {
										var id = oObj.aData.id;
									    var queryParams = id;
										var str1 = '<a name="editTestCaseBtn" onclick="editTestCase(\''
											    + queryParams
												+ '\')" href="javascript:;" class="btn default btn-sm purple ">'
												+ '<i class="fa fa-edit"></i> 编辑   '
												+ '</a>    ';
                                        if(globalAdminType==1) {
                                            str1 = str1 + '<a name="deleteTestCaseBtn" onclick="deleteTestCase(\''
                                                + queryParams
                                                + '\')"  href="javascript:;" class="btn default btn-sm black">'
                                                + '<i class="fa fa-trash-o"></i> 删除'
                                                + '</a>   ';
                                        }
										return str1;
									}
								} ],
						"aaSorting" : [ [ 2, "desc" ] ],
						"aoColumnDefs" : [ {
							'bSortable' : false,
							'aTargets' : [ 0 ]
						}, /*{
							'bSortable' : false,
							"bVisible" : false,
							'aTargets' : [ 2 ]
						}, */{/* "sWidth": "10%",*/
							"bSearchable" : false,
							"aTargets" : [ 0 ]
						}, {
							"bSearchable" : false,
							"aTargets" : [ 1 ]
						} ]
					}
				});
		return grid;
	}
	return {
		init : function() {
			return handleRecords();

		}

	};

}();