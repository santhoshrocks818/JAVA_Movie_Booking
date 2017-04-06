
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
        <style>
        .whitetext{
            color: white
        }
        table{
            border:3px blue
        }
        #brandingtcs{
            margin: 15px 30px 0 21px;
            background-image: url(http://fresherswalkin.careerfriend.in/wp-content/uploads/sites/8/2016/01/TCS-Logo.png);
            background-position: center;
            background-repeat: no-repeat;
            height: 192px;
            padding-top: 5px;
        }
        #tcslogo{
            background-repeat: no-repeat;
            float: left;
            width: 272px;
            height: 18px;
        }
    </style>
    <body background="http://cdn.wonderfulengineering.com/wp-content/uploads/2014/09/blue-wallpaper-36.jpg">
   
        <div id="brandingtcs">
            <div id="tcslogo"></div>
        </div> 
            <form method="post" action="mb_registration_sql.jsp" onSubmit="return validation()" name="myform">
            

                <center>
            <table border="0.5" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th class="whitetext" colspan="2"><h2>Enter Information Here</h2></th>
                    </tr>
                </thead>                              
                        <td class="whitetext" name="uFirstname" id="uFirstname">First Name</td>
                       
                        <td><input type="text" name="fname" value=""/></td>
                    
                    <tr>
                        <td class="whitetext" name="uSecondname" id="uSecondname">Last Name</td>
                        <td><input type="text" name="lname" value=""/></td>
                    </tr>
                    <tr>
                        <td class="whitetext" name="uEmail" id="uEmail">Email</td>
                     <!--<td><input type="email" name="email" value="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/></td>-->
                     <td><input type="email" name="email" value=""/></td>
                    </tr>
                    <tr>
                        <td class="whitetext" name="uDob" id="uDob">Date of Birth</td>
                        <td><input type="date" name="date" value="12/12/1991" />
                        </td>
                    </tr>
                        <td class="whitetext" name="uMobileno" id="uMobileno">Mobile Number</td>
                    <!--<td><input type="number" name="phnum" value="" maxlength="10" pattern="[0-9]{10}" required /></td>.-->
                       <td><input type="tel" name="phone" value=""/></td>
   
                       
                    </tr>
                    <tr>
                        <td class="whitetext" name="uPasswd" id="uPasswd">Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                     <tr>
                        <td class="whitetext" id="uConfpasswd">Confirm Password</td>
                        <td><input type="password" name="conf_pass" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Submit"  style="float: right"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="whitetext">Already registered!! <a class="whitetext" href="mb_login.jsp">Login Here</a></td>
                    </tr>
      
            </table>
            </center>
        </form>
            <footer>
                <center>            
                    <table cellpadding="10">

                    <tbody>
                        <tr>
                            <td colspan="3"> <%= new java.util.Date() %></td>
                            <td colspan="1">www.tcs.com</td>
                            <td colspan="1">tcs@copyright</td>
                        </tr>
                           
                    </tbody>
                    </table>
                </center>
            </footer>
    </body>
<script type="text/javascript">
function validation()
{
        // Firstname validation 
	var x=document.myform.fname.value;
    
	if(x==""){
		alert("Enter Firstname");
		document.myform.fname.focus();
		return false;
	}
    if (x.length<5){
		alert("First name required min 5 characters");
		document.myform.fname.focus();
		return false;
	} else if (x.length>50){
		alert("Firstname should be max 50 characters");
		document.myform.fname.focus();
		return false;
	}
	if (!x.match(/^[a-zA-Z]+(([\'\,\.\- ][a-zA-Z ])?[a-zA-Z]*)*$/)){
            alert("Firstname contains only A-Z a-z 0-9 characters!");
			document.myform.fname.focus();
			return false;
	}
        // Lastname validation 
        var Y=document.myform.lname.value;
    
	if(Y==""){
		alert("Enter Lastname");
		document.myform.lname.focus();
		return false;
	}
       if (Y.length<5){
		alert("Last name required min 5 characters");
		document.myform.lname.focus();
		return false;
	} else if (Y.length>50){
		alert("Lastname should be max 50 characters");
		document.myform.lname.focus();
		return false;
	}
	if (!Y.match(/^[a-zA-Z]+(([\'\,\.\- ][a-zA-Z ])?[a-zA-Z]*)*$/)){
            alert("Lastname contains only A-Z a-z 0-9 characters!");
			document.myform.lname.focus();
			return false;
	}
        
        // Email validation 
        var Email = document.myform.email.value;
        var atpos = Email.indexOf("@");
        var dotpos = Email.lastIndexOf(".");
       if (atpos<1 || dotpos<atpos+2 || dotpos+2>=Email.length) {
           alert("Not a valid e-mail address");
           return false;
        }
        
        
        // Date of birth validation 
        
        // Phone number validation.
        var phone_no = document.myform.phone.value;
	phone = document.myform.phone.value.replace(/[^0-9]/g, '');
	
		if(phone_no == "")
		{
			alert("Phone number should not empty");
			document.myform.phone.focus();
			return false;
		}
                   else if(!phone.match(/^\d+/))
        {
        alert("Please enter numeric characters only for your Phone Number! (Allowed input:0-9)");
		document.myform.phone.focus();
		return false;
        }

	if(phone.length !== 10) { 
	alert("Phone Number Should be 10 digits");
	document.myform.phone.focus();
	return false;
	}
        //Password validation
        
       	var b = document.myform.password.value;
	if(b==""){
		alert("Password shouldn't be empty");
		document.myform.password.focus();
		return false;
	}
	
	var passw=  /(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{7,12})$/;
	var passw1 = /^(?=[^\d_].*?\d)\w(\w|[!@#$%]){7,12}/;
	if( !b.match(passw1)) 
	{ 
	alert("Password should have special characters");
	return false;
	}
	
	var cpass = document.myform.conf_pass.value;
	if( cpass != b){
		alert("Password Does not match");
		document.myform.conf_pass.focus();
		return false;
	}

}
</script>
</html>