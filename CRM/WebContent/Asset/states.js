$('documenet').ready(function()
	{
		$.getJSON('FetchStatesJSON',{ajax:true},function(data)
		{
			//alert(data);
			$('#ecity').append($('<option>').val('-Select-').text('-Select-'));	  
			$('#estate').append($('<option>').val('-Select-').text('-Select-'));	  
			$.each(data,function(i,item)
			  {
				$('#estate').append($('<option>').val(item.STATEID).text(item.STATENAME));	  
			  });	
		});	


$('#estate').change(function()
	{
		$.getJSON("FetchCityByStateIdJSON",{ajax:true,stateid:$('#estate').val()},function(data)
			{
				 $('#ecity').empty();
				 $('#ecity').append($('<option>').val('-Select-').text('-Select-'));	  
				 $.each(data,function(i,item)
				 {
					 $('#ecity').append($('<option>').val(item.CITYID).text(item.CITYNAME));	  
				 });
			});	
	
	});
});


