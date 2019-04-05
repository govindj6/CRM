function isDigit(txt)
{  
	for(i=0;i<txt.length;i++)
    {
		var c=txt.charCodeAt(i);
		if(!(c>=48 && c<=57))
		{ 
			return false;
		}
	}
	return true;
}

function validation()
{ 
	var txt=document.getElementById('txt').value;
	var result=document.getElementById('result');
	result.innerHTML="";
	if(!isDigit(txt))
	{ 
		result.innerHTML="Invalid Mobile No...";
	}
	else
	{ 
		if(txt.length!=10)
		{
			result.innerHTML="Mobile No Must Be Of 10 Digit...";
		}
	}
}
