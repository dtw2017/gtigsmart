/**
 * Author: Thomas JIAO
 */

$(function() {
	$('#packinglist').edatagrid({
		url : 'datagrid_data.json',
	});
});

function saveTruckInvoice() {
	var invno = $("#invno").val();
	var invdate= $("#invdate").val();
	var duedate=$("#duedate").val();
	var shipdate=$("#shipdate").val();
	var arrivaldate=$("#arrivaldate").val();
	var reference_no=$("#reference_no").val();
	var oprefer_no=$("#oprefer_no").val();
	var shipper=$("#shipper").val();
	var shipto=$("#shipto").val();
		
	//get edatagrid item
	var rows = $('#truckcharge').edatagrid('getRows');
	var str = [];
	for (i=0;i<rows.length;i++)
		{
			var charge = {};
			charge.chargeItem = rows[i].itemid;
			charge.chargeDesc = rows[i].desc;
			charge.chargeAmount = rows[i].amount;
			charge.invoiceNo = invno;
			str[i] = charge;
		}
	
	var invdataset = {
		"invoiceNo" : invno,
		"invoiceDate":invdate,
		"referenceNo":reference_no,
		"shipDate":shipdate,
		"arrivalDate":arrivaldate,
		"opReferenceNo":oprefer_no,
		"shipper":shipper,
		"shipTo":shipto,
		"dueDate":duedate,
		"opReferenceNo":oprefer_no,
		"chargeItems":str,
	};



	console.log(str)
	console.log(invdataset)
	
	$.ajax({
		type : 'POST',
		url : '/truckinv?save',
		dataType : 'JSON', // data type expected from server
		contentType : "application/json",
		data : JSON.stringify(invdataset),
		timeout : 100000,
		success : function(data) {
			alert("saved");
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	})
}

function retrieveTruckInvoice() {
	var invno=$("#invno").val();
	
	$.ajax({
		type : 'POST',
		url : '/truckinv?retrieve',
		dataType : 'JSON', 		// data type expected from server
		contentType : "application/json",
		data : invno,
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#invno").val(data.invoiceNo);
			$("#shipto").val(data.shipTo);
			$("duedate").val(data.dueDate);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	})

}

function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}

function saveTruckCharge(){
	var rows = $('#truckcharge').edatagrid('getRows');
	var str = [];
	for (i=0;i<rows.length;i++)
		{
			var charge = {};
			charge.itemid = rows[i].itemid;
			charge.desc = rows[i].desc;
			charge.amount = rows[i].amount;
			str[i] = charge;
		}

	console.log(str)
}