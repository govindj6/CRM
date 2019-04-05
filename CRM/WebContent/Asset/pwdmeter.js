function call()
{
	var pwd=document.getElementById("pwd").value;
	var img=document.getElementById("img");

	if(pwd.length==0)
	{
		img.src="images/Pwd/ps0.gif";
	}
	else if(pwd.length==1)
	{
		img.src="images/Pwd/ps1.gif";
	}
	else if(pwd.length==2)
	{
		img.src="images/Pwd/ps2.gif";
	}
	else if(pwd.length==3)
	{
		img.src="images/Pwd/ps3.gif";
	}
	else if(pwd.length==4)
	{
		img.src="images/Pwd/ps4.gif";
	}
	else if(pwd.length==5)
	{
		img.src="images/Pwd/ps5.gif";
	}
	else if(pwd.length==6)
	{
		img.src="images/Pwd/ps6.gif";
	}
	else if(pwd.length==7)
	{
		img.src="images/Pwd/ps7.gif";
	}
	else if(pwd.length==8)
	{
		img.src="images/Pwd/ps8.gif";
	}
	else if(pwd.length==9)
	{
		img.src="images/Pwd/ps9.gif";
	}
	else if(pwd.length>=10)
	{
		img.src="images/Pwd/ps10.gif";
	}
}

function check()
{
	  var pwd=document.getElementById("pwd");
	  var cpwd=document.getElementById("cpwd");
	  var img=document.getElementById("cimg");
	   if(pwd.value==cpwd.value)
	   {
	     img.src="images/Pwd/tick.png";
	   }
	   else
	   {  img.src="images/Pwd/crs.png";
	   }
}