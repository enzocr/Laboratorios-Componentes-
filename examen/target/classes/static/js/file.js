$(document).ready( function () {
	 var table = $('#table').DataTable({
			"sAjaxSource": "/productos",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
			    { "mData": "product_name" },
				{ "mData": "quality_grade" },
				{ "mData": "total_amount" },
				{ "mData": 	"cant_boxes" },
				{ "mData": "entry_date" },
				{ "mData": "id_storage" }
			]
	 })
});
