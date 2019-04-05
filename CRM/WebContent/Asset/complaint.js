$('document').ready(function(){

	$('#btn').click(function(){
		
	$.getJSON("FetchComplaintByIdJSON",{ajax:true,cmid:$('#cmid').val()},function(data){
	if(data.length>0)
		{
		
		
		var h='<form action=FollowUpSubmit><input type=hidden name=cmid value='+$('#cmid').val()+'><table border=1>';
		h+='<tr><td><b><i>Complaint Date:</i></b>'+data[0].CURRENTDATE+'<br>Provider:'+data[0].FNAME+'</td><td><b><i>Company:</i></b>'+data[0].CNAME+'</td><td><b><i>Customer Name:</i></b>'+data[0].CUSTOMERNAME+"</td></tr>";
		h+='<tr><td><b><i>Address:</i></b>'+data[0].ADDRESS+'<br>'+data[0].CITY+','+data[0].SNAME+'</td><td><b><i>Mobile:</i></b>'+data[0].MOBILENO+'</td><td><b><i>Status:</i></b>'+data[0].STATUS+"</td></tr>";
				
		h+='</table><br>';
		h+='<b><i>Employee Name:</i></b>:'+data[0].ENAME+'<br>';
		h+='<textarea rows=5 cols=40>'+data[0].COMMUNICATION+"</textarea><br>";
		h+='<b><i>Complaint Details:</i></b><br>';
		h+='<textarea rows=5 cols=40>'+data[0].PRODUCTDETAILS+"</textarea><br>";
		h+='<b><i>Write Conversation:</i></b><br>';
		h+='<textarea rows=5 cols=40 name=ec></textarea><br><br>';
		h+='<input type=submit></form>';
		
		
		$('#cresult').html(h);
		
		
		}
	else
		{
		
		$('#cresult').html('Record Not FOUND');
		
		}
		
		
		
		
	});	
		
	});
	
	///////////////dialog/////////////
	
	$('#more').click(function(event) {



		 $.getJSON('FetchFollowUpComplaintsByIdJSON',{ajax:true,cmid:$('#cmid').val()},function(data){


	    var dynamicDialog = $('<div id="conformBox" >'+
	    '<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;">'+
	    '</span>'+data.MSG+'</div>');

	    dynamicDialog.dialog({
	            title : "Follow Up Details By Date",
	            closeOnEscape: true,
	            width: 450,
                height: 450,
	            modal : true,
	            
                

	           buttons :
	                    [{
	                            text : "Exit",
	                            click : function() {
	                                   $(this).dialog("close");
	                                    //currentForm.submit();
	                                  //  window.location.href='UserLogin?qty='+$('#qty').val();
	                            }
	                    } ]
	    });
	    return false;
	});

	
	});
	
	
	//////////////////////////////////////
	
	
	
	
	
	
	
});