$('document').ready(function(){
	
	$('#ecity').change(function(){
		
		$.getJSON("FetchServiceCenterByCompanyId_CityIdJSON",{ajax:true,cityid:$('#ecity').val(),cid:$('#cid').val()},function(data){
			 $('#sid').empty();
			 $('#sid').append($('<option>').val('-Select-').text('-Select-'));	  
			$.each(data,function(i,item){
				  $('#sid').append($('<option>').val(item.SERVICECENTERID).text(item.FIRMNAME+' ['+item.ADDRESS+']'));	  
				  });
			
		});	
			
		});	
	
})