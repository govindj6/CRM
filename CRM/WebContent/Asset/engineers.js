$('document').ready(function()
		{
	
				$.getJSON("FetchEngineersBySCIdJSON",{ajax:true,scid:$('#scid').val()},function(data)
					{
						//alert(data);
						$('#eid').append($('<option>').val('-Select-').text('-Select-'));	 
						  
						$.each(data,function(i,item)
						{
							$('#eid').append($('<option>').val(item.ENGINEERID).text(item.ENGINEERNAME));	  
						});	
					});
			
		});