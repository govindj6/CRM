$('document').ready(function(){

	$('#btn').click(function(){
		
	$.getJSON("FetchComplaintByDateJSON",{ajax:true,scid:$('#scid').val(),fd:$('#date1').val(),td:$('#date2').val()},function(data){
	if(data.length>0)
		{
		
		
		var h = '<table border=1>';
		  $.each(data, function(i,item){
		  h+='<tr><td><b><i>Complaint Id:</i></b>'+item.COMPLAINTID+'</ br><b><i>Date of Complaint:</i></b>'+item.CURRENTDATE+'</td>';
		  h+='<td><b><i>Company:</i></b>'+item.CNAME+'</br><b><i>ProductDetails:</i></b>'+item.PRODUCTDETAILS+'</td>';
		  h+='<td><b><i>Name:</i></b>'+item.CUSTOMERNAME+'</br><b><i>MobileNo:</i></b>'+item.MOBILENO+'</td>';
		  h+='<td><b><i>Communication:</i></b>'+item.CONVERSATION+'</td>';
		  h+='<td><b><i>Status:</i></b>'+item.STATUS+'</td><td><b><a href=ComplaintAssign?cmid='+item.COMPLAINTID+' id=assign>Assign To</a></b></td></tr>';
		
		  });
		
		
		$('#cresult').html(h);
		
		
		}
	else
		{
		
		$('#cresult').html('Record Not FOUND');
		
		}
		
	});	
		
	});
	
	
});